package model;

public class MortgageLoan extends CreditOffer {
    private String propertyType;

    public MortgageLoan(String id, double interestRate, double minAmount, double maxAmount, int minTermMonths, int maxTermMonths, boolean allowsEarlyRepayment, boolean allowsLineIncrease, String propertyType) {
        super(id, interestRate, minAmount, maxAmount, minTermMonths, maxTermMonths, allowsEarlyRepayment, allowsLineIncrease);
        this.propertyType = propertyType;
    }

    @Override
    public double calculatePayment(double amount, int term) {
        // місячна ставка
        double monthlyRate = getInterestRate() / 12 / 100;
        // складний відсоток
        double ratio = Math.pow(1 + monthlyRate, term);
        return amount * (monthlyRate * ratio) / (ratio - 1);
    }

    public String getPropertyType() { return propertyType; }

    @Override
    public String toString() {
        return String.format("MortgageLoan [ID=%s, Rate=%.2f%%, Type=%s]", getId(), getInterestRate(), propertyType);
    }
}