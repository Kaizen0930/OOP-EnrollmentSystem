package org.example.interfaces;

public interface ITuitionService {

    double calculateFee(int units, double ratePerUnit);

    double makePayment(double totalBalance, double payment);

    double getRemainingBalance(double totalFee, double payment);
}
