package br.com.techis.soscitadel.userconfig.repository;

import br.com.techis.soscitadel.userconfig.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
