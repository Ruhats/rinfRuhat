package com.rinf.ruhat;

import java.util.*;

public class GiveBackChange {

    public Map<Integer, Integer> returnChange (int amount) {

        // In order to prevent unnecessary work
        if (amount <= 0) {
            throw new IllegalArgumentException("You need to give money to get the change");
        }

        // I have changed HashMap to TreeMap and the key to Integer
        // so that I could order by key without implementing a custom comparator
        Map<Integer, Integer> change = new TreeMap<>(Comparator.reverseOrder());
        int[] banknoteTypes = {100, 50, 20, 10, 5, 1};

        for (int banknoteType :
                banknoteTypes) {
            int result = amount / banknoteType;// Instead of modulo, divide is the way to go
            if(result > 0) {// Only adding if there is a banknote present to produce a cleaner map
                change.put(banknoteType, result);
                amount %= banknoteType;
            }
            // Since we talked about performance I wanted to break out of unnecessary looping
            if (amount == 0)
                break;
        }
        return change;
    }
}
