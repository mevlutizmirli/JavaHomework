package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface OrderItemEntityRepository extends JpaRepository <OrderItemEntity, Long> {

    @Modifying
    void deleteByUuid(UUID uuid);


    Optional<OrderItemEntity> findByUuid(UUID uuid);
}
