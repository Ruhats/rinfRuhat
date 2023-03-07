package com.rinf.ruhat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@SpringBootTest
public class GiveBackChangeTest {

    private GiveBackChange giveBackChange;

    @BeforeEach
    void setUp() {
        giveBackChange = new GiveBackChange();
    }
    @Test
    void giveBackChangeTestForPositiveAmount() {
        Map<Integer, Integer> result = giveBackChange.returnChange(159);
        Map<Integer, Integer> expected = new TreeMap<>(Comparator.reverseOrder());
        expected.put(100, 1);
        expected.put(50, 1);
        expected.put(5, 1);
        expected.put(1, 4);
        Assertions.assertEquals(expected, result);
    }
    @Test
    void giveBackChangeTestForNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> giveBackChange.returnChange(-12));
    }
}
