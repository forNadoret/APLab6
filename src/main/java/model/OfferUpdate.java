package model;

public class OfferUpdate {
    private Double interestRate;
    private Double minAmount;
    private Double maxAmount;
    private Integer minTermMonths;
    private Integer maxTermMonths;
    private Boolean allowsEarlyRepayment;
    private Boolean allowsLineIncrease;

    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }
    public Double getMinAmount() { return minAmount; }
    public void setMinAmount(Double minAmount) { this.minAmount = minAmount; }
    public Double getMaxAmount() { return maxAmount; }
    public void setMaxAmount(Double maxAmount) { this.maxAmount = maxAmount; }
    public Integer getMinTermMonths() { return minTermMonths; }
    public void setMinTermMonths(Integer minTermMonths) { this.minTermMonths = minTermMonths; }
    public Integer getMaxTermMonths() { return maxTermMonths; }
    public void setMaxTermMonths(Integer maxTermMonths) { this.maxTermMonths = maxTermMonths; }
    public Boolean getAllowsEarlyRepayment() { return allowsEarlyRepayment; }
    public void setAllowsEarlyRepayment(Boolean allowsEarlyRepayment) { this.allowsEarlyRepayment = allowsEarlyRepayment; }
    public Boolean getAllowsLineIncrease() { return allowsLineIncrease; }
    public void setAllowsLineIncrease(Boolean allowsLineIncrease) { this.allowsLineIncrease = allowsLineIncrease; }
}