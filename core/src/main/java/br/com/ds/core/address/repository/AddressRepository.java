package br.com.ds.core.address.repository;

import br.com.ds.core.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressById(Long id);
}
