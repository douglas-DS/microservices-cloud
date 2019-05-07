package br.com.ds.core.role.repository;

import br.com.ds.core.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleById(Long id);
}
