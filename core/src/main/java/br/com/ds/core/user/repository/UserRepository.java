package br.com.ds.core.user.repository;

import br.com.ds.core.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
