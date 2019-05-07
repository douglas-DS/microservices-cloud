package br.com.ds.security.repository;

import br.com.ds.core.userconfig.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Douglas Souza on 19/04/2019
 *
 */

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findUserRoleById(Long id);
}
