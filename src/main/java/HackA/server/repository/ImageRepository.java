package HackA.server.repository;

import HackA.server.domain.UploadImage;
import java.awt.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<UploadImage, Long> {
}
