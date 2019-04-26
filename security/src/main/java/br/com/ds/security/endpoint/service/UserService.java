package br.com.ds.security.endpoint.service;

import br.com.ds.core.error.ResourceNotFoundException;
import br.com.ds.core.userconfig.model.User;
import br.com.ds.core.userconfig.model.UserRole;
import br.com.ds.security.repository.UserRepository;
import br.com.ds.security.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Douglas Souza on 24/04/2019
 */

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

//    public User getUserDetails(String login, String pass) {
//        log.info("Searching user in DB {}, Login: ", login + " Pass: " + pass);
//        User user = userRepository.findUserByNicknameAndPassword(login, pass);
//
//        if (user == null)
//            throw new UserNotFoundException("User not found by login: " + login +
//                    ", pass: " + pass);
//
//        return user;
//    }

    public User getUser(Long id) {
        userValidation(id);
        return userRepository.findUserById(id);
    }

    public Iterable<User> listUsers(Pageable pageable) {
        log.info("Listing all users");
        return userRepository.findAll(pageable);
    }

    public User saveUser(User user) {
        UserRole userRole = userRoleRepository.findUserRoleById(user.getUserRole().getId());
        log.info("User role: " + userRole.toString());

        user.setNickname(user.getEmail());

        user.setUserRole(userRole);
        userRepository.save(user);

        log.info("User saved: " + user);

        return user;
    }

    public User updateUser(User user) {
        userValidation(user.getId());
        userRepository.save(user);
        log.info("User saved: " +user);

        return user;
    }

    public ResponseEntity deleteUser(Long id) {
        userValidation(id);
        userRepository.deleteById(id);
        log.info("User deleted for ID: " +id);
        return new ResponseEntity(HttpStatus.OK);
    }

    private void userValidation(Long id) {
        if (userRepository.findUserById(id) == null)
            throw new ResourceNotFoundException("User not found for ID: " +id);
    }

}
