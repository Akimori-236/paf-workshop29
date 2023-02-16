package nus.iss.tfip.pafworkshop29.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nus.iss.tfip.pafworkshop29.model.Order;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

    @PostMapping(path = { "/order", "/order/" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String postOrderForm(@RequestBody Order order) {
        System.out.println(order);

        return "success";
    }

}
