package entities;

public class TuitionFeePayment {
    private String studentId;
    private double pricePerUnit;
    private double totalTuition;
    private double balance;

    public TuitionFeePayment(String studentId) {
        this.studentId = studentId;
        this.pricePerUnit = 1000.00;
        this.totalTuition = 0.0;
        this.balance = 0.0;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalTuition() {
        return totalTuition;
    }

    public void setTotalTuition(double totalTuition) {
        this.totalTuition = totalTuition;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}