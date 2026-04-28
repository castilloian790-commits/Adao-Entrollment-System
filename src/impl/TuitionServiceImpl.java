package impl;

import entities.TuitionFeePayment;
import services.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {

    @Override
    public double calculateFee(TuitionFeePayment payment, int units, double discountRate) {
        double total = units * payment.getPricePerUnit() * (1.0 - discountRate);
        payment.setTotalTuition(total);
        payment.setBalance(total);
        return total;
    }

    @Override
    public void makePayment(TuitionFeePayment payment, double amount) {
        payment.setBalance(payment.getBalance() - amount);
    }

    @Override
    public double getRemainingBalance(TuitionFeePayment payment) {
        return payment.getBalance();
    }

    @Override
    public boolean isFullyPaid(TuitionFeePayment payment) {
        return payment.getBalance() <= 0;
    }
}