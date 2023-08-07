package com.allianz.erp.controller;

import com.allianz.erp.database.entity.OrderEntity;
import com.allianz.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Called with a POST request to create a new order
    @PostMapping("order")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order){
        OrderEntity order1 = orderService.createOrder();
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }
    // Called with a GET request to retrieve a specific order by UUID
    @GetMapping("order-uuid/{uuid}")
    public ResponseEntity<OrderEntity> getOrderByUUID(@PathVariable UUID uuid){
        OrderEntity orderEntity = orderService.getOrderByUuid(uuid);
        if (orderEntity != null){
            return new ResponseEntity<>(orderEntity,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND)
        }
    }
    // Called with a PUT request to add an item to an order
    @PutMapping("add-item-to-order/{uuid}/{orderItemUUID}")
    public ResponseEntity<OrderEntity> addItemOrder
            (@PathVariable UUID uuid, @PathVariable UUID orderItemUUID){
        OrderEntity orderEntity = orderService.addItemToOrder(uuid,orderItemUUID);
        if (orderEntity != null){
            return new ResponseEntity<>(orderEntity,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }
    // Called with a PUT request to approve an order
    @PutMapping("approve/{uuid}")
    public ResponseEntity<OrderEntity> approveOrder(@PathVariable UUID uuid){
        OrderEntity orderEntity = orderService.approveOrder(uuid);
        if (orderEntity != null){
            return new ResponseEntity<>(orderEntity,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }



}
