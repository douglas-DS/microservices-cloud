package br.com.techis.soscitadel.userconfig.repository;

import br.com.techis.soscitadel.userconfig.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
