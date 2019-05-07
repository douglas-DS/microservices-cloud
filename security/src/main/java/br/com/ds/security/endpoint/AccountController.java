package br.com.ds.user.endpoint;

import br.com.ds.core.account.model.Account;
import br.com.ds.core.account.repository.AccountRepository;
import br.com.ds.core.address.repository.AddressRepository;
import br.com.ds.core.role.repository.RoleRepository;UserR
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AccountController {
    private AccountRepository accountRepository;
    private RoleRepository roleRepository;
    private AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<Iterable<Account>> listAllAccount() {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }
//
//    @PostMapping
//    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
//        Address address = addressRepository.findAddressById(account.getAccountAddress().getId());
//        account.setAccountAddress(address);
//
//        List<Role> roles = new ArrayList<>();
//        account.getRole().forEach(role -> {
//                    roles.add(roleRepository.findRoleById(role.getId()));
//                    log.info("Role: " + role);
//                }
//        );
//        log.info("Roles: " + roles);
//        account.setRole(roles);
//        return new ResponseEntity<>(accountRepository.save(account), HttpStatus.CREATED);
//    }

}
