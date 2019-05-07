package br.com.ds.security.security.config;

import br.com.ds.security.security.props.JWTConfig;
import br.com.ds.security.security.user.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.security.config.http.SessionCreationPolicy.ALWAYS;

/**
 * @author Douglas Souza on 24/04/2019
 */

@EnableWebSecurity
@Configuration
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private CustomUserDetailService customUserDetailService;
    private JWTConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/*/access/**").permitAll()
//                    .antMatchers(jwtConfig.getTokenAccessURL()).permitAll()
                    .antMatchers("/*/protected/**").hasAnyRole("OPERATOR", "ADMIN", "MASTER")
                    .antMatchers("/*/admin/**").hasAnyRole("ADMIN", "MASTER")
                    .anyRequest().authenticated()
                .and()
                    .httpBasic()
                .and()
                    .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                    .sessionManagement().sessionCreationPolicy(ALWAYS)
                .and()
                    .exceptionHandling().authenticationEntryPoint(
                            (req, resp, ex) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
//                    .addFilter(new UsernamePasswordAuthenticationFilter())
//                .and()
                    .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passEncoder());
    }



    @Bean
    public BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

}
