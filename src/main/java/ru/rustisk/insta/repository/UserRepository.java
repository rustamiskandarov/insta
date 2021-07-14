package ru.rustisk.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rustisk.insta.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String username);
    Optional<User> findUserById(Long id);
}
