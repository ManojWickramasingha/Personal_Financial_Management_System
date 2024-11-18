package edu.icet.pim.repository;

import edu.icet.pim.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);
    Optional<UserEntity> findOneByEmailAndPassword(String email, String password);
}
