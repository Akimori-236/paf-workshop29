package nus.iss.tfip.pafworkshop29.model;

import lombok.Data;
import nus.iss.tfip.pafworkshop29.Constants;
@Data
public class LineItem implements Constants {
    private String item;
    private Integer quantity;
}
