package com.aseef.model;

import java.util.HashMap;
import java.util.List;

public class StockExchange {

    private HashMap<String,Investor> investors;
    private HashMap<String,Company> companies;
    private double transactionProfit;

    public StockExchange(HashMap<String, Investor> investors, HashMap<String, Company> companies, double transactionProfit) {
        this.investors = investors;
        this.companies = companies;
        this.transactionProfit = transactionProfit;
    }

    public HashMap<String, Investor> getInvestors() {
        return investors;
    }

    public void setInvestors(HashMap<String, Investor> investors) {
        this.investors = investors;
    }

    public HashMap<String, Company> getCompanies() {
        return companies;
    }

    public void setCompanies(HashMap<String, Company> companies) {
        this.companies = companies;
    }

    public double getTransactionProfit() {
        return transactionProfit;
    }

    public void setTransactionProfit(double transactionProfit) {
        this.transactionProfit = transactionProfit;
    }
}
