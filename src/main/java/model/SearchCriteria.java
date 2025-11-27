package model;

public class SearchCriteria {
    private String bankName;
    private Double maxRate;
    private Double minAmount;
    private Boolean allowsEarlyRepayment;
    private Boolean allowsLineIncrease;

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public Double getMaxRate() {
        return maxRate;
    }
    public void setMaxRate(Double maxRate) {
        this.maxRate = maxRate;
    }
    public Double getMinAmount() {
        return minAmount;
    }
    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }
    public Boolean getAllowsEarlyRepayment() {
        return allowsEarlyRepayment;
    }
    public void setAllowsEarlyRepayment(Boolean allowsEarlyRepayment) {
        this.allowsEarlyRepayment = allowsEarlyRepayment;
    }
    public Boolean getAllowsLineIncrease() {
        return allowsLineIncrease;
    }
    public void setAllowsLineIncrease(Boolean allowsLineIncrease) {
        this.allowsLineIncrease = allowsLineIncrease;
    }
}