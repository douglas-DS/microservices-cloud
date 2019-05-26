package br.com.ds.security.endpoint;

import br.com.ds.core.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Douglas Souza on 25/04/2019
 */

@RestController
@RequestMapping("v1/access")
public class UserInfoAccessController {

    @GetMapping
    public ResponseEntity<?> currentUserInfo(Principal principal) {
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return ResponseEntity.ok(user);
    }

}
