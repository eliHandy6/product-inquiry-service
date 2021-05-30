package com.example.productinquiryservice.controller;

import com.example.productinquiryservice.beans.ProductInquiryBean;
import com.example.productinquiryservice.beans.ProductStockBean;
import com.example.productinquiryservice.client.ProductStockClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/apis/v1/product-inquiry")
public class ProductInquiryController {

    private final ProductStockClient productStockClient;


    @PostMapping
    public ResponseEntity<ProductStockBean> saveProductStock(@RequestBody ProductStockBean productStockBean) {
        return productStockClient.saveProductStock(productStockBean);
    }

    @GetMapping()
    public ResponseEntity<List<ProductStockBean>> getAllProducts() {
        return productStockClient.getAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductStockBean> updateProduct(@PathVariable Long id, ProductStockBean productStockBean) {
        return productStockClient.updateProduct(id, productStockBean);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productStockClient.deleteProduct(id);
    }

    @GetMapping("/search/units/{quantity}")
    public ResponseEntity<ProductInquiryBean> searchForProductInStock(@RequestParam String name, @RequestParam String availability, @PathVariable int quantity) {
        ProductInquiryBean productInquiryBean = productStockClient.searchForProductInStock(name, availability).getBody();

        double totalAmount = productInquiryBean.getProductPrice().doubleValue() * quantity;
        double discount = productInquiryBean.getDiscountOffer();
        double discount_offer = totalAmount * discount / 100;

        ProductInquiryBean productInquiryBean1 = new ProductInquiryBean().builder()
                .id(productInquiryBean.getId())
                .productName(productInquiryBean.getProductName())
                .productPrice(productInquiryBean.getProductPrice())
                .productAvailability(productInquiryBean.getProductAvailability())
                .discountOffer(discount_offer)
                .totalPrice(totalAmount)
                .units(quantity)
                .build();

        return new ResponseEntity<>(productInquiryBean1, HttpStatus.OK);

    }


}
