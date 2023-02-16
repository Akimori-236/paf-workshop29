package nus.iss.tfip.pafworkshop29.model;

import java.sql.Date;
import java.util.List;

import org.bson.Document;

import lombok.Data;
import nus.iss.tfip.pafworkshop29.Constants;

@Data
public class Order implements Constants {
    private String name;
    private String email;
    private Date deliveryDate;
    private List<LineItem> lineItems;

    public Document toDocument() {
        Document doc = new Document();
        doc.put(FIELD_NAME, this.getName());
        doc.put(FIELD_EMAIL, this.getEmail());
        doc.put(FIELD_DELIVERYDATE, this.getDeliveryDate());
        doc.put(FIELD_LINEITEMS, this.getLineItems()
                .stream()
                .map(li -> li.toDocument())
                .toList());
        return doc;
    }
}
