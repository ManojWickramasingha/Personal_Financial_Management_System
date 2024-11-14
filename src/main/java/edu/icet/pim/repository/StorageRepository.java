package edu.icet.pim.repository;

import edu.icet.pim.entity.ImageDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageDataEntity,Long> {


    Optional<ImageDataEntity> findByName(String fileName);
}
