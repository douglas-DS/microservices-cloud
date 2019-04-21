package br.com.ds.user.service;

import br.com.ds.core.userconfig.model.User;
import br.com.ds.core.userconfig.model.UserRole;
import br.com.ds.user.repository.UserRepository;
import br.com.ds.user.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public ResponseEntity<Iterable<User>> findAllUsers() {
        Iterable<User> users = userRepository.findAll();
        log.info("Listing all users");
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<User> save(@Valid User user) {
        UserRole userRole = userRoleRepository.save(user.getUserRole());

        user.setUserRole(userRole);
        userRepository.save(user);
        log.info("User saved: " + user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
