package HackA.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HackA.server.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
