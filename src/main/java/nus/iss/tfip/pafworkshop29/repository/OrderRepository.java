package nus.iss.tfip.pafworkshop29.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.tfip.pafworkshop29.Constants;
import nus.iss.tfip.pafworkshop29.model.Order;

@Repository
public class OrderRepository implements Constants{

    @Autowired
    private MongoTemplate template;

    public Document insertOrder(Order order) {
        Document doc = template.insert(Order.class, COLLECTION_ORDERS);
        return doc;
    }
}
