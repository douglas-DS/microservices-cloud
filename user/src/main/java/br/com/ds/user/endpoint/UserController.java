package br.com.ds.user.endpoint;

import br.com.ds.core.userconfig.model.User;
import br.com.ds.core.userconfig.model.UserRole;
import br.com.ds.user.repository.UserRepository;
import br.com.ds.user.repository.UserRoleRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @GetMapping
    @HystrixCommand
    public Iterable<User> listAll() {
        log.info("Listing users");
        return userRepository.findAll();
    }

    @PostMapping
    @HystrixCommand
    public User save(@RequestBody User user) {
        UserRole userRole = userRoleRepository.save(user.getUserRole());
        userRoleRepository.save(user.getUserRole());
        user.setUserRole(userRole);
        userRepository.save(user);
        log.info("User saved: " + user);
        return user;
    }
}
