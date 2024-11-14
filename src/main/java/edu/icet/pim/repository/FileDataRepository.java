package edu.icet.pim.repository;

import edu.icet.pim.entity.FileDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileDataEntity,Integer> {
    Optional<FileDataEntity> findByName(String fileName);
    @Query(value = "SELECT id FROM file_data ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findLastId();


}
