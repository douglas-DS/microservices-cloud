package br.com.ds.security.security.user;

import br.com.ds.core.error.ResourceNotFoundException;
import br.com.ds.core.user.model.User;
import br.com.ds.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collection;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

/**
 * @author Douglas Souza on 25/04/2019
 */

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        log.info("Loading user by username (CustomUser): " + login);
        User user;

        if(login.contains("@"))
            user = repository.findUserByEmail(login)
                    .orElseThrow(() -> new ResourceNotFoundException("invalid.login.email"));

        else user = repository.findUserByNickname(login)
                    .orElseThrow(() -> new ResourceNotFoundException("invalid.login.nickname"));


        log.info("User found in DB '{}'", user);

        return new CustomUserDetail(user);
    }

    private static class CustomUserDetail extends User implements UserDetails {
        CustomUserDetail(@NotNull User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return commaSeparatedStringToAuthorityList("ROLE_" +this.getUserRole().getName());
        }

        @Override
        public String getUsername() {
            return super.getNickname();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
