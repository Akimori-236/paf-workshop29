package nus.iss.tfip.pafworkshop29.controller;

import java.util.Map;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
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
        String response = orderSvc.insertOrder(order);


        System.out.println("RESPONSE >>> " + response);
        if (response.isBlank() || response.isEmpty()) {
            // JsonObject json = Json.createObjectBuilder().add("id", response).build();
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}
