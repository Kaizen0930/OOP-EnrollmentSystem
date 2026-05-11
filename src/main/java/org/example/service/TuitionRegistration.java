package org.example.service;

import org.example.interfaces.ITuitionService;

public class TuitionRegistration implements ITuitionService {

    public TuitionRegistration() {}

    @Override
    public double calculateFee(int units, double ratePerUnit) {
        return units * ratePerUnit;
    }

    @Override
    public double makePayment(double totalBalance, double payment) {
        if (payment > totalBalance) {
            System.out.println("Payment exceeds balance.");
            return totalBalance;
        }
        return totalBalance - payment;
    }

    @Override
    public double getRemainingBalance(double totalFee, double payment) {
        return totalFee - payment;
    }
}