package com.aseef.model;

public class Stock {
    private String companyName;
    private int noOfShares;

    public Stock(String companyName, int noOfShares) {
        this.companyName = companyName;
        this.noOfShares = noOfShares;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNoOfShares() {
        return noOfShares;
    }

    public void setNoOfShares(int noOfShares) {
        this.noOfShares = noOfShares;
    }


}
