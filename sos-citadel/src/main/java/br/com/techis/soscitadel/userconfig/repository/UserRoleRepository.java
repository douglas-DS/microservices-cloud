package br.com.techis.soscitadel.userconfig.repository;

import br.com.techis.soscitadel.userconfig.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
