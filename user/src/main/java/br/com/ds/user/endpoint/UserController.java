package br.com.ds.user.endpoint;//

import br.com.ds.core.userconfig.model.User;
import br.com.ds.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController {

    private UserService userService;

    @GetMapping
    @HystrixCommand
    public ResponseEntity<?> listAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    @HystrixCommand
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return userService.save(user);
    }
}
