package com.example.productinquiryservice.client;

import com.example.productinquiryservice.beans.ProductInquiryBean;
import com.example.productinquiryservice.beans.ProductStockBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-stock-service", url = "localhost:8800")
public interface ProductStockClient {

    @PostMapping("/apis/v1/products")
    public ResponseEntity<ProductStockBean> saveProductStock(@RequestBody ProductStockBean productStockBean);

    @GetMapping("/apis/v1/products")
    public ResponseEntity<List<ProductStockBean>> getAllProducts();

    @PutMapping("/apis/v1/products/{id}")
    public ResponseEntity<ProductStockBean> updateProduct(@PathVariable Long id, ProductStockBean productStockBean);

    @DeleteMapping("/apis/v1/products/{id}")
    public void deleteProduct(@PathVariable Long id);

    @GetMapping("/apis/v1/products/search")
    public ResponseEntity<ProductInquiryBean> searchForProductInStock(@RequestParam String name, @RequestParam String availability);
}
