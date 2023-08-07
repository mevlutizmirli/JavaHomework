package com.allianz.erp.controller;

import com.allianz.erp.database.entity.ReceiptEntity;
import com.allianz.erp.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("order-item")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    // This endpoint retrieves a receipt from the database based on its UUID.
    @GetMapping("order-receipt-uuid/{uuid}")
    public ResponseEntity<ReceiptEntity> getReceiptByUUID(@PathVariable UUID uuid){
        ReceiptEntity receiptEntity = receiptService.getReceiptByUUID(uuid);
        if (receiptEntity != null){
            return new ResponseEntity<>(receiptEntity, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
