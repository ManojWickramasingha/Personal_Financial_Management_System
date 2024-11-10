package edu.icet.pim.repository;

import edu.icet.pim.entity.ReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<ReceiptEntity,Integer> {
}
