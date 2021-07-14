package ru.rustisk.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rustisk.insta.entity.Comment;
import ru.rustisk.insta.entity.Post;
import ru.rustisk.insta.entity.User;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
    Optional<Comment> findByIdAndUserId(Long commentId, Long userId);
}
