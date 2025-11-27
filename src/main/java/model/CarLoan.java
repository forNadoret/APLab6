package model;

public class CarLoan extends CreditOffer {
    private boolean requiresKASKO;

    public CarLoan(String id, double interestRate, double minAmount, double maxAmount, int minTermMonths, int maxTermMonths, boolean allowsEarlyRepayment, boolean allowsLineIncrease, boolean requiresKASKO) {
        super(id, interestRate, minAmount, maxAmount, minTermMonths, maxTermMonths, allowsEarlyRepayment, allowsLineIncrease);
        this.requiresKASKO = requiresKASKO;
    }

    @Override
    public double calculatePayment(double amount, int term) {
        // місячна ставка
        double monthlyRate = getInterestRate() / 12 / 100;
        // складний відсоток
        double ratio = Math.pow(1 + monthlyRate, term);
        return amount * (monthlyRate * ratio) / (ratio - 1);
    }

    public boolean isRequiresKASKO() { return requiresKASKO; }

    @Override
    public String toString() {
        return String.format("CarLoan [ID=%s, Rate=%.2f%%, KASKO=%s]", getId(), getInterestRate(), requiresKASKO);
    }
}