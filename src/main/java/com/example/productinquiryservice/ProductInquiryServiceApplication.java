package com.example.productinquiryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients()
@SpringBootApplication
public class ProductInquiryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductInquiryServiceApplication.class, args);
    }

}
