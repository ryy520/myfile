package com.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TestApplicationProvider {
        public static void main(String[] args) {
            SpringApplication.run(TestApplicationProvider.class,args);
        }
    }


