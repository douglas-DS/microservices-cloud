package br.com.ds.security.security.config;

import br.com.ds.security.security.filter.SecurityAuthenticationFilter;
import br.com.ds.token.security.config.TokenSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Douglas Souza on 24/04/2019
 */

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class SecurityConfiguration extends TokenSecurityConfig {

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http
                .addFilter(new SecurityAuthenticationFilter(authenticationManager()))

                .authorizeRequests()
                    .antMatchers("/**/login", "/**/access/**").permitAll()
                    .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
