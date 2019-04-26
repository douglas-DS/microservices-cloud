package br.com.ds.security.repository;

import br.com.ds.core.userconfig.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Douglas Souza on 19/04/2019
 *
 */

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findUserById(Long id);
    User findUserByNickname(String nickname);
    User findUserByEmail(String email);
//    User findUserByNicknameAndPassword(String nick, String pass);
}
