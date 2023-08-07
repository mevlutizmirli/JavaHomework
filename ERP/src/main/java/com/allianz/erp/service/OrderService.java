package com.allianz.erp.service;

import com.allianz.erp.database.entity.CustomerEntity;
import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.database.entity.OrderItemEntity;
import com.allianz.erp.database.repository.OrderEntityRpository;
import com.allianz.erp.model.OrderStatusEnum;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderEntityRpository orderEntityRpository;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReceiptService receiptService;

    public OrderEntity createOrder(){
      OrderEntity order =  new OrderEntity();
      order.setOrderStatus(OrderStatusEnum.PENDING);

      orderEntityRpository.save(order);
      return order;
    }

    public OrderEntity getOrderByUuid (UUID uuid){
        Optional<OrderEntity> orderEntityOptional = orderEntityRpository.findByUuid(uuid);
        return orderEntityOptional.orElse(null);
    }

    public OrderEntity addItemToOrder(UUID uuid, UUID orderItemUUID){
        OrderEntity order = getOrderByUuid(uuid);
        OrderItemEntity orderItem = orderItemService.getOrderItemByUUID(orderItemUUID);
        if (orderItem.getProduct().getStock()>0){
            order.getOrderItemList().add(orderItem);
            orderItem.setOrder(order);

            return order;
        }
        System.out.println("Cannot add item. ...");
        return null;
    }

       public OrderEntity approveOrder(UUID uuid){
           OrderEntity order = getOrderByUuid(uuid);
           boolean allItemsInStock = allItemsInStock(order.getOrderItemList());

           if (allItemsInStock){
               updateStockOfOrderItems(order.getOrderItemList());
               order.setOrderStatus(OrderStatusEnum.APPROVED);
               receiptService.createReceipt(order);
               return order;
           }else {
               order.setOrderStatus(OrderStatusEnum.CANCELLED);
               System.out.println("Your order has been cancelled due to insufficient stock");
               return null;
           }

        }
        public boolean allItemsInStock(List<OrderItemEntity> orderItemEntityList){

            for (OrderItemEntity orderItem : orderItemEntityList){
                if (orderItem.getProduct().getStock() < 0){
                    return false;
                }
            }return true;
        }

        public void updateStockOfOrderItems(List<OrderItemEntity> orderItemEntityList){
            for (OrderItemEntity orderItem : orderItemEntityList){
                orderItem.getProduct().setStock(orderItem.getProduct().getStock()-orderItem.getQuantity());
            }
        }




}
