package nus.iss.tfip.pafworkshop29.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.tfip.pafworkshop29.Constants;
import nus.iss.tfip.pafworkshop29.model.Order;
import nus.iss.tfip.pafworkshop29.repository.OrderRepository;

@Service
public class OrderService implements Constants {

    @Autowired
    private OrderRepository orderRepo;

    public String insertOrder(Order order) {
        Document doc = order.toDocument();
        Document response = orderRepo.insertOrder(doc);
        return response.get(FIELD_OBJ_ID).toString();
    }
}
