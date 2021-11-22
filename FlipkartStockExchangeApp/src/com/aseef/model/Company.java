package com.aseef.model;

public class Company {

    private String companyName;
    private int intialNoOfShares;
    private double initialWorth;
    private int noOfShares;
    private double currentCompanyWorth;
    private double sellingPrice;
    private double initialStockPrice;

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getInitialStockPrice() {
        return initialStockPrice;
    }

    public void setInitialStockPrice(double initialStockPrice) {
        this.initialStockPrice = initialStockPrice;
    }

    public Company(String companyName, int noOfShares, double initialWorth) {
        this.companyName = companyName;
        this.noOfShares = noOfShares;
        intialNoOfShares= noOfShares;
        currentCompanyWorth = initialWorth;
        this.initialWorth = initialWorth;
        this.initialStockPrice = initialWorth/noOfShares;
        this.sellingPrice = initialWorth/noOfShares;

    }

    public int getIntialNoOfShares() {
        return intialNoOfShares;
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

    public double getInitialWorth() {
        return initialWorth;
    }


    public double getCurrentCompanyWorth() {
        return currentCompanyWorth;
    }

    public void setCurrentCompanyWorth(double currentCompanyWorth) {
        this.currentCompanyWorth = currentCompanyWorth;
    }
}
