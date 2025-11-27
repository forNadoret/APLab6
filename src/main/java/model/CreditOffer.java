package model;

import java.io.Serializable;

public abstract class CreditOffer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private double interestRate;
    private double minAmount;
    private double maxAmount;
    private int minTermMonths;
    private int maxTermMonths;
    private boolean allowsEarlyRepayment;
    private boolean allowsLineIncrease;

    public CreditOffer(String id, double interestRate, double minAmount, double maxAmount, int minTermMonths, int maxTermMonths, boolean allowsEarlyRepayment, boolean allowsLineIncrease) {
        this.id = id;
        this.interestRate = interestRate;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.minTermMonths = minTermMonths;
        this.maxTermMonths = maxTermMonths;
        this.allowsEarlyRepayment = allowsEarlyRepayment;
        this.allowsLineIncrease = allowsLineIncrease;
    }

    public abstract double calculatePayment(double amount, int term);

    public String getId() { return id; }
    public double getInterestRate() { return interestRate; }
    public double getMinAmount() { return minAmount; }
    public double getMaxAmount() { return maxAmount; }
    public int getMinTermMonths() { return minTermMonths; }
    public int getMaxTermMonths() { return maxTermMonths; }
    public boolean isAllowsEarlyRepayment() { return allowsEarlyRepayment; }
    public boolean isAllowsLineIncrease() { return allowsLineIncrease; }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public void setMinAmount(double minAmount) { this.minAmount = minAmount; }
    public void setMaxAmount(double maxAmount) { this.maxAmount = maxAmount; }
    public void setMinTermMonths(int minTermMonths) { this.minTermMonths = minTermMonths; }
    public void setMaxTermMonths(int maxTermMonths) { this.maxTermMonths = maxTermMonths; }
    public void setAllowsEarlyRepayment(boolean allowsEarlyRepayment) { this.allowsEarlyRepayment = allowsEarlyRepayment; }
    public void setAllowsLineIncrease(boolean allowsLineIncrease) { this.allowsLineIncrease = allowsLineIncrease; }
}