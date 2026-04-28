package tests;

import entities.TuitionFeePayment;
import impl.TuitionServiceImpl;
import services.ITuitionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TuitionServiceTest {

    @Test
    public void testCalculateFee_NoDiscount() {
        // Arrange
        TuitionFeePayment payment = new TuitionFeePayment("S001");
        ITuitionService service = new TuitionServiceImpl();

        // Act — 5 units * 1000.00 * (1 - 0.0) = 5000.00
        double total = service.calculateFee(payment, 5, 0.0);

        // Assert
        assertEquals(5000.0, total);
        assertEquals(5000.0, payment.getTotalTuition());
        assertEquals(5000.0, payment.getBalance());
    }

    @Test
    public void testCalculateFee_WithDiscount() {
        // Arrange
        TuitionFeePayment payment = new TuitionFeePayment("S001");
        ITuitionService service = new TuitionServiceImpl();

        // Act — 5 units * 1000.00 * (1 - 0.20) = 4000.00
        double total = service.calculateFee(payment, 5, 0.20);

        // Assert
        assertEquals(4000.0, total, "20% discount on 5000 should yield 4000.");
    }

    @Test
    public void testMakePayment_Overpayment_IsFullyPaid() {
        // Arrange — student owes 3000
        TuitionFeePayment payment = new TuitionFeePayment("S001");
        ITuitionService service = new TuitionServiceImpl();
        service.calculateFee(payment, 3, 0.0);

        // Act — pay 5000 (more than owed)
        service.makePayment(payment, 5000.0);

        // Assert — student is fully paid (isFullyPaid handles negative balance)
        assertTrue(service.isFullyPaid(payment),
                "Student should be fully paid after overpaying the balance.");
    }
}