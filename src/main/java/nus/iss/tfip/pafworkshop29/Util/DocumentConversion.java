package nus.iss.tfip.pafworkshop29.Util;

import org.bson.Document;
import nus.iss.tfip.pafworkshop29.model.Order;
import nus.iss.tfip.pafworkshop29.model.LineItem;
import nus.iss.tfip.pafworkshop29.Constants;

public class DocumentConversion implements Constants{

    public static Document toDocument(LineItem li) {
        Document doc = new Document();
        doc.put(FIELD_ITEM, li.getItem());
		doc.put(FIELD_QTY, li.getQuantity());
        return doc;
    }

    public static Document toDocument(Order order) {
        Document doc = new Document();
        doc.put(FIELD_NAME, order.getName());
        doc.put(FIELD_EMAIL, order.getEmail());
        doc.put(FIELD_DELIVERYDATE, order.getDeliveryDate());
        doc.put(FIELD_LINEITEMS, order.getLineItems()
                .stream()
                .map(li -> DocumentConversion.toDocument(li))
                .toList());
        return doc;
    }
}
