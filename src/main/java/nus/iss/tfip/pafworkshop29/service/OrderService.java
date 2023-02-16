package nus.iss.tfip.pafworkshop29.service;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.tfip.pafworkshop29.Constants;
import nus.iss.tfip.pafworkshop29.Util.DocumentConversion;
import nus.iss.tfip.pafworkshop29.model.Order;
import nus.iss.tfip.pafworkshop29.repository.OrderRepository;

@Service
public class OrderService implements Constants {

    @Autowired
    private OrderRepository orderRepo;

    public String insertOrder(Order order) {
        Document doc = DocumentConversion.toDocument(order);
        Document response = orderRepo.insertOrder(doc);

        // get objectId from the response doc
        String mongoObjectIdString = response.get(FIELD_OBJ_ID).toString();
        order.setOrderId(mongoObjectIdString);
        // do something else with the order

        // check objectid validity
        if (ObjectId.isValid(response.getObjectId(FIELD_OBJ_ID).toHexString())) {
            return mongoObjectIdString;
        } else {
            return null;
        }
    }
}
