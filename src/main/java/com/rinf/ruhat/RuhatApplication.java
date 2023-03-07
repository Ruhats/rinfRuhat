package com.rinf.ruhat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RuhatApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuhatApplication.class, args);

        GiveBackChange change = new GiveBackChange();

        System.out.println(change.returnChange(122));
        System.out.println(change.returnChange(100));
        System.out.println(change.returnChange(-5));
    }

}
