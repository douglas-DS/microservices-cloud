package br.com.ds.user;

import br.com.ds.core.userconfig.model.User;
import br.com.ds.core.userconfig.model.UserRole;
import br.com.ds.core.userconfig.repository.UserRepository;
import br.com.ds.core.userconfig.repository.UserRoleRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @GetMapping
    @HystrixCommand
    public List<User> listAll() {
        log.info("Listing users");
        return userRepository.findAll();
//        return new Customer("Bruce Wayne", "BatCave", "PORT: 8080");

    }

    @PostMapping
    @HystrixCommand
    public User save(@RequestBody User user) {
        UserRole userRole = user.getUserRole();
        userRoleRepository.save(userRole);
        userRepository.save(user);
        log.info("User saved: " + user);
        return user;
    }
}
