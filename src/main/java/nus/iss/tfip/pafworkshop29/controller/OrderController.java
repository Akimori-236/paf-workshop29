package nus.iss.tfip.pafworkshop29.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import nus.iss.tfip.pafworkshop29.model.Order;
import nus.iss.tfip.pafworkshop29.service.OrderService;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

        @Autowired
        private OrderService orderSvc;

        @PostMapping(path = { "/order",
                        "/order/" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> postOrderForm(@RequestBody Order order) {

                // System.out.println(order);
                String objIdString = orderSvc.insertOrder(order);

                System.out.println("MONGO OBJECT ID >>> " + objIdString);
                if (objIdString.isBlank() || objIdString.isEmpty()) {
                        JsonObject json = Json.createObjectBuilder()
                                        .add("orderId", objIdString)
                                        .add("message", "Error: Invalid form entries")
                                        .build();
                        System.out.println(json.toString());
                        return ResponseEntity
                                        .status(HttpStatus.NOT_ACCEPTABLE)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(json.toString());
                } else {
                        JsonObject json = Json.createObjectBuilder()
                                        .add("orderId", objIdString)
                                        .add("message", "Order successfully recorded")
                                        .build();
                        System.out.println(json.toString());
                        return ResponseEntity
                                        .status(HttpStatus.CREATED)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(json.toString());
                }
        }
}
