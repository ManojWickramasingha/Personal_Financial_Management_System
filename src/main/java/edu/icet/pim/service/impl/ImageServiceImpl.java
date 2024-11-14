package edu.icet.pim.service.impl;

import edu.icet.pim.entity.FileDataEntity;
import edu.icet.pim.entity.ImageDataEntity;
import edu.icet.pim.repository.FileDataRepository;
import edu.icet.pim.repository.StorageRepository;
import edu.icet.pim.service.ImageService;
import edu.icet.pim.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {


   private final StorageRepository repository;


   private final FileDataRepository fileDataRepository;

    private final String FOLDER_PATH="C://Users/ASUS/OneDrive/Desktop/MyFile";

    public String uploadImage(MultipartFile file) throws IOException {
        ImageDataEntity imageData = repository.save(ImageDataEntity.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }



    public byte[] downloadImage(String fileName) {
        Optional<ImageDataEntity> dbImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileDataEntity fileData=fileDataRepository.save(FileDataEntity.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileDataEntity> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

}
