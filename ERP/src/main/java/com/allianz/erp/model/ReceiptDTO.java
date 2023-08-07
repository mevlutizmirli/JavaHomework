package com.allianz.erp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ReceiptDTO {
    private UUID uuid;
    private int receiptNo;
    private double totalPrice;
    private double totalPriceWithoutVAT;
    private OrderDTO order;


    public ReceiptDTO(){this.uuid = UUID.randomUUID();}
}
