package ru.rustisk.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rustisk.insta.entity.Image;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long > {
    Optional<Image> findByUserId(Long id);
    Optional<Image> findByPostId(Long id);
}
