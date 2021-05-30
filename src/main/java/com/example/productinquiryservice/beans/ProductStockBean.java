package com.example.productinquiryservice.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockBean {

    private long id;
    private String productName;
    private BigDecimal productPrice;
    private String productAvailability;
    private double discountOffer;
    private int port;
}
