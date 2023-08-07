package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.ReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface ReceiptEntityRepository extends JpaRepository<ReceiptEntity, Long> {

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<ReceiptEntity> findByUuid(UUID uuid);

}
