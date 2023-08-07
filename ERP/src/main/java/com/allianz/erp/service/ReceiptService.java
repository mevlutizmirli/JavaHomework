package com.allianz.erp.service;

import com.allianz.erp.database.entity.*;
import com.allianz.erp.database.repository.ReceiptEntityRepository;
import com.allianz.erp.model.ProductTypeEnum;
import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReceiptService {
    @Autowired
    ReceiptEntityRepository receiptEntityRepository;

    public ReceiptEntity createReceipt(OrderEntity order){
        ReceiptEntity receipt = new ReceiptEntity();
        receipt.setOrder(order);
        order.setReceipt(receipt);

        receiptEntityRepository.save(receipt);

        double totalPriceWithVAT = 0.0;
        double totalPriceWithoutVAT = 0.0;




        List<OrderItemEntity> orderItems = order.getOrderItemList();
        for (OrderItemEntity orderItem : orderItems){
            totalPriceWithVAT += calculatePriceWithVAT(orderItem);
            totalPriceWithoutVAT += calculatePriceWithoutVAT(orderItem);
            System.out.println("Order Item: " + orderItem.getProduct().getName() + ", Quantity " + orderItem.getQuantity()
                    + ", Unit Price: " + orderItem.getProduct().getPrice());
        }
        receipt.setTotalPriceWithVAT(totalPriceWithVAT);
        receipt.setTotalPriceWithoutVAT(totalPriceWithoutVAT);
        receipt.setTotalVATAmount(totalPriceWithVAT-totalPriceWithoutVAT);
        return receipt;
    }

    public double  calculatePriceWithVAT(OrderItemEntity orderItem){
        ProductEntity product = orderItem.getProduct();

        if (product.isHasVAT()){
           return product.getPrice();
        }else {
            return addVATToProduct(product);

        }

    }

    public double addVATToProduct(ProductEntity product){
        VatEntity vat = new VatEntity();
        if (product.getProductType()==ProductTypeEnum.BASIC_NEED){
            return product.getPrice()*(vat.getBasicNeed()/100 + 1 );
        }else if (product.getProductType()==ProductTypeEnum.CONSUMER_PRODUCT){
            return product.getPrice()*(vat.getConsumerProduct()/100 + 1);
        }else {
            return product.getPrice()*(vat.getLuxuryItem()/100 + 1);
        }
    }


    public double calculatePriceWithoutVAT(OrderItemEntity orderItem){
        ProductEntity product = orderItem.getProduct();
        if (!product.isHasVAT()){
            return product.getPrice();
        }else {
          return subtractVATFromProduct(product);

        }

    }



    public double subtractVATFromProduct(ProductEntity product){

        VatEntity vat = new VatEntity();

        if (product.getProductType()==ProductTypeEnum.BASIC_NEED){
            return product.getPrice()*(vat.getBasicNeed()/100);
        }else if (product.getProductType()==ProductTypeEnum.CONSUMER_PRODUCT){
            return product.getPrice()*(vat.getConsumerProduct()/100);
        }else {
            return product.getPrice()*(vat.getLuxuryItem()/100);
        }
    }

    public ReceiptEntity getReceiptByUUID(UUID uuid){
        Optional<ReceiptEntity> receiptEntityOptional = receiptEntityRepository.findByUuid(uuid);

        return receiptEntityOptional.orElse(null);
    }




}
