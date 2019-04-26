package br.com.ds.security.security.user;

import br.com.ds.core.userconfig.model.User;
import br.com.ds.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Douglas Souza on 25/04/2019
 */

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user;

        if(login.contains("@")) {
            log.info("Searching in DB for email: " +login);
            user = userRepository.findUserByEmail(login);
        } else {
            log.info("Searching in DB for nickname: " + login);
            user = userRepository.findUserByNickname(login);
        }

        Optional.ofNullable(user)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User '%s' not found", login)));

        String auth = "ROLE_" + user.getUserRole().getName().toString();

        log.info("Getting authority: " + auth);
        List<GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(auth);

        return new org.springframework.security.core.userdetails.User(login, user.getPassword(), authorities);
    }
}
