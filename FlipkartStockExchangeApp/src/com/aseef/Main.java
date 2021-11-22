package com.aseef;

import com.aseef.model.Buy_Sell;
import com.aseef.model.Company;
import com.aseef.model.Investor;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap<String, Investor> investors = new HashMap<>();
        HashMap<String, Company> companies = new HashMap<>();
        StockExchangeService stockExchangeService = new StockExchangeService(investors,companies);

        Company c1 = new Company("Reliance",100,1000);
        stockExchangeService.registerCompany(c1);
        System.out.println();
        Company c2 = new Company("Adani",90,900);
        stockExchangeService.registerCompany(c2);
        System.out.println();


        Investor i1 = new Investor("Aseef");
        stockExchangeService.registerInvestor(i1);
        System.out.println();
        Investor i2 = new Investor("Rahul");
        stockExchangeService.registerInvestor(i2);
        System.out.println();

        Buy_Sell buy1  = new Buy_Sell("Reliance","Rahul",2);
        stockExchangeService.buyingStock(buy1);
        System.out.println();

//        Buy_Sell buy2  = new Buy_Sell("Reliance","Aseef",2);
//        stockExchangeService.buyingStock(buy2);
//        System.out.println();
//
//        stockExchangeService.showCompanyShares("Reliance");
//        System.out.println();
//
//        Buy_Sell sell  = new Buy_Sell("Reliance","Aseef",2);
//        stockExchangeService.sellingStock(sell);
//        System.out.println();
//
//        Investor i3 = new Investor("Sameer");
//        stockExchangeService.registerInvestor(i3);
//        System.out.println();
//
////        Buy_Sell buy3  = new Buy_Sell("Reliance","Sameer",98);
////        stockExchangeService.buyingStock(buy3);
////        System.out.println();
//
//        stockExchangeService.showStockExchangeDetails();
//
//        System.out.println();
//
        stockExchangeService.showProfit();

//        Buy_Sell sell  = new Buy_Sell("Reliance","Aseef",2);
//        stockExchangeService.sellingStock(sell);
//        System.out.println();
//        stockExchangeService.showInvetorShares("Aseef");
//        System.out.println();
//        stockExchangeService.showCompanyShares("Reliance");
//        System.out.println();
//        stockExchangeService.setStockExchangeDetails();
//        System.out.println();
//        stockExchangeService.showProfit();
//        System.out.println();



    }


}
