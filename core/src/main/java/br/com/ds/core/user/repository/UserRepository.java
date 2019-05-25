package br.com.ds.core.user.repository;

import br.com.ds.core.user.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAccount_Id(Long accountId, Sort sort);
    Optional<User> findUserByNickname(String nickname);
    Optional<User> findUserByEmail(String email);
}
