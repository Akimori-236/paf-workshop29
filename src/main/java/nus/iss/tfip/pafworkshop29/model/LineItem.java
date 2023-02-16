package nus.iss.tfip.pafworkshop29.model;

import org.bson.Document;

import lombok.Data;
import nus.iss.tfip.pafworkshop29.Constants;
@Data
public class LineItem implements Constants {
    private String item;
    private Integer quantity;

    public Document toDocument() {
        Document doc = new Document();
        doc.put(FIELD_ITEM, this.getItem());
		doc.put(FIELD_QTY, this.getQuantity());
        return doc;
    }
}
