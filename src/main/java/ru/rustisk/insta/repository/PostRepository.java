package ru.rustisk.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rustisk.insta.entity.Post;
import ru.rustisk.insta.entity.User;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserOrderByCreateDateDesc(User user);
    List<Post> findAllByOrderByCreateDate();
    Optional<Post> findByIdAndUser(Long id, User user);


}
