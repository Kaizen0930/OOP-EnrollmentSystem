package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TuitionRegistrationTest {

    private TuitionRegistration tuitionService;

    @BeforeEach
    void init() {
        tuitionService = new TuitionRegistration();
    }

    @Test
    void checkTuitionCalculation() {
        // 18 units * 1500 per unit = 27000
        double units = 18;
        double rate = 1500;

        double result = tuitionService.calculateFee((int) units, rate);

        assertEquals(27000, result, "The fee calculation should match units * rate.");
    }

    @Test
    void checkBalanceAfterPayment() {
        double totalTuition = 10000;
        double amountPaid = 3500;

        double balance = tuitionService.getRemainingBalance(totalTuition, amountPaid);

        // 10000 - 3500 = 6500
        assertEquals(6500, balance, "The balance should be the total minus payment.");
    }
}