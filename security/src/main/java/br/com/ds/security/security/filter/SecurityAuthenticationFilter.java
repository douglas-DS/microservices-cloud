package br.com.ds.security.security.filter;

import br.com.ds.core.login.UserLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Douglas Souza on 25/04/2019
 */

@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class SecurityAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {

        UserLogin user = new ObjectMapper().readValue(req.getInputStream(), UserLogin.class);
        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUser(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {

        res.getOutputStream().println("User authenticated");
        res.flushBuffer();
    }
}
