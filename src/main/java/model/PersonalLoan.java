package model;

public class PersonalLoan extends CreditOffer {
    private String purpose;

    public PersonalLoan(String id, double interestRate, double minAmount, double maxAmount, int minTermMonths, int maxTermMonths, boolean allowsEarlyRepayment, boolean allowsLineIncrease, String purpose) {
        super(id, interestRate, minAmount, maxAmount, minTermMonths, maxTermMonths, allowsEarlyRepayment, allowsLineIncrease);
        this.purpose = purpose;
    }

    @Override
    public double calculatePayment(double amount, int term) {
        // місячна ставка
        double monthlyRate = getInterestRate() / 12 / 100;
        // складний відсоток
        double ratio = Math.pow(1 + monthlyRate, term);
        return amount * (monthlyRate * ratio) / (ratio - 1);
    }

    public String getPurpose() { return purpose; }

    @Override
    public String toString() {
        return String.format("PersonalLoan [ID=%s, Rate=%.2f%%, Purpose=%s]", getId(), getInterestRate(), purpose);
    }
}