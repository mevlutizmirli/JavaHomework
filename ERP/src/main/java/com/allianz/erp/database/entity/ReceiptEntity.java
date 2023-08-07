package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="customer_uuid"))
@Data
public class ReceiptEntity extends BaseEntity {

    @Column
    private int receiptNo;
    @Column
    private double totalPriceWithVAT;
    @Column
    private double totalVATAmount;
    @Column
    private double totalPriceWithoutVAT;
    @OneToOne(mappedBy = "receipt")
    private OrderEntity order;
}
