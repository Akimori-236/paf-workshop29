package nus.iss.tfip.pafworkshop29.model;

import java.sql.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import nus.iss.tfip.pafworkshop29.Constants;

@Data
public class Order implements Constants {
    private String orderId;
    @NotNull(message = "please enter name")
    private String name;
    private String email;
    private Date deliveryDate;
    private List<LineItem> lineItems;
}
