package br.com.ds.token.security.config;

import br.com.ds.token.handler.RestAuthenticationEntryPoint;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

public class TokenSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                    .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                    .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                    .exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and().authorizeRequests()
                    .antMatchers("/**/actuator/**").permitAll()
                    .antMatchers(GET, "/**/swagger-resources/**", "/**/webjars/springfox-swagger-ui/**", "/**/v2/api-docs/**").permitAll()
                    .antMatchers("/**/swagger-ui.html").permitAll()
                    .antMatchers("/**/access").hasAnyRole("ADMIN", "MASTER", "VIEWER")
                    .antMatchers("/**/token/**").hasAnyRole("ADMIN", "MASTER", "VIEWER")
                .anyRequest().authenticated();
    }

}
