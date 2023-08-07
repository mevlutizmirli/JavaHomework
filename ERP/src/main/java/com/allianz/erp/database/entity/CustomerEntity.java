package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@Data
public class CustomerEntity extends BaseEntity {


        @Column
        private String name;
        @Column
        private String surname;
        @Column
        private int birthYear;
        @Column
        private String email;
        @Column
        private int cardNo;
        @Column
        private String address;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderEntity>orderHistory = new ArrayList<>();




}
