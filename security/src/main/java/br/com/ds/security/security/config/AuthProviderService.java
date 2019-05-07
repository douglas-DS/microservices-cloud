//package br.com.techis.heimdall.security.auth.config;
//
//import br.com.techis.citadel.userconfig.error.ResourceNotFoundException;
//import br.com.techis.citadel.userconfig.model.User;
//import UserRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
///**
// * @author Douglas Souza on 24/04/2019
// */
//
//@Component
//@Slf4j
//@AllArgsConstructor(onConstructor = @__({@Autowired}))
//public class AuthProviderService implements AuthenticationProvider {
//
//    private UserRepository userRepository;
//
//    @Override
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        String login = auth.getName();
//        String pass = auth.getCredentials().toString();
//
//        User user = userRepository.findUserByEmail(login);
//
//        if (user != null) {
//
//            if(!user.getPassword().equals(pass))
//                throw new UsernameNotFoundException("Invalid password: " + pass);
//
//            return new UsernamePasswordAuthenticationToken(login, pass, new ArrayList<>());
//        } else throw new UsernameNotFoundException("User not found");
//
//    }
//
//    @Override
//    public boolean supports(Class<?> auth) {
//        return auth.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
