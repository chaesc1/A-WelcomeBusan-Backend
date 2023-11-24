package HackA.server.service;

import HackA.server.domain.UploadImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import HackA.server.repository.ImageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	private static String uploadPath = "/src/main/resources/static/img";
	private ImageRepository imageRepository;
	@Override
	public String uploadImage(MultipartFile file) throws IOException {
//		String originFileName = file.getName();
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path filePath = Paths.get(uploadPath, fileName);

		File f = new File(String.valueOf(filePath));

		try {
			file.transferTo(filePath);
			UploadImage image = UploadImage.builder()
					.name(fileName)
					.build();

			imageRepository.save(image);

		} catch (Exception e) {
			e.getStackTrace();
		}


		return fileName;
	}

	@Override
	public Resource getImage(String fileName) throws MalformedURLException {
		Path filePath = Paths.get(uploadPath).resolve(fileName).normalize();
		Resource resource = new UrlResource(filePath.toUri());

		if (resource.exists()) {
			return resource;
		}

		return null;
	}
}
