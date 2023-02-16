package nus.iss.tfip.pafworkshop29.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String name;
    private String email;
    private Date deliveryDate;
    private List<LineItem> lineItems;
}
