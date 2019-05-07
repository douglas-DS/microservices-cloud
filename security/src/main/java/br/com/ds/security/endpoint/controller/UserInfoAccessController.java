package br.com.ds.security.endpoint.controller;

import br.com.ds.core.userconfig.model.User;
import br.com.ds.security.endpoint.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Douglas Souza on 25/04/2019
 */

@RestController
@RequestMapping("v1/access")
public class UserInfoAccessController {

    private UserService service;

    public ResponseEntity getUser(Principal principal) {
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
