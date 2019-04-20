package br.com.techis.soscitadel.userconfig.repository;

import br.com.techis.soscitadel.userconfig.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositry extends JpaRepository<Role, Integer> {
}
