package com.aseef.model;

import java.util.ArrayList;
import java.util.List;

public class Investor {

    private String name;
    private List<Stock> holdingStocks ;

    public Investor(String name) {
        this.name = name;
        holdingStocks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getHoldingStocks() {
        return holdingStocks;
    }

    public void setHoldingStocks(List<Stock> holdingStocks) {
        this.holdingStocks = holdingStocks;
    }
}
