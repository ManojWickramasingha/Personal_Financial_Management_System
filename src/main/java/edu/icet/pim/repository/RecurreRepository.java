package edu.icet.pim.repository;

import edu.icet.pim.entity.RecurrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurreRepository extends JpaRepository<RecurrEntity,Long> {
}
