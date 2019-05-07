package br.com.ds.user.endpoint;

import br.com.ds.core.address.model.Address;
import br.com.ds.core.address.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AddressController {
    private AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<Iterable<Address>> getAllAddress() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
    }
}
