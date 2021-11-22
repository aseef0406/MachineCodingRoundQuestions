package com.aseef.model;

public class Buy_Sell {
    private String companyName;
    private String investorName;
    private int noOfShares;

    public Buy_Sell(String companyName, String investorName, int noOfShares) {
        this.companyName = companyName;
        this.investorName = investorName;
        this.noOfShares = noOfShares;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public int getNoOfShares() {
        return noOfShares;
    }

    public void setNoOfShares(int noOfShares) {
        this.noOfShares = noOfShares;
    }
}
