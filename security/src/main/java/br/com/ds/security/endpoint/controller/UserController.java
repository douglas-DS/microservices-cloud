package br.com.ds.security.endpoint.controller;

import br.com.ds.core.userconfig.model.User;
import br.com.ds.security.endpoint.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Douglas Souza on 24/04/2019
 */

@RestController
@RequestMapping("v1")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController {

    private UserService userService;

    @GetMapping(path = "protected/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand
    public ResponseEntity<User> getUserById(@PathVariable Long id,
                                            @AuthenticationPrincipal UserDetails userDetails) {
        log.info("User Details: " +userDetails);
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping(path = "protected/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand
    public ResponseEntity<Iterable<User>> listAll(Pageable pageable) {
        return new ResponseEntity<>(userService.listUsers(pageable), HttpStatus.OK);
    }

    @PostMapping(path = "access/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "admin/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand
    public ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping(path = "admin/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand
    public ResponseEntity delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
