package com.aseef;

import com.aseef.model.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class StockExchangeService {

    StockExchange stockExchange;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public StockExchangeService(HashMap<String,Investor> investors, HashMap<String,Company> companies) {
        this.stockExchange = new StockExchange(investors,companies,0);
    }

    public void registerCompany(Company company){
        //search company present or not
        if(stockExchange.getCompanies().containsKey(company.getCompanyName())){
            System.out.println("Company is "+Status.NOT_REGISTERED+" because of duplicacy");
        }
        else {
            stockExchange.getCompanies().put(company.getCompanyName(), company);
            System.out.println("Company "+company.getCompanyName()+" is "+Status.REGISTERED);
        }
    }

    public void registerInvestor(Investor investor){
        if(stockExchange.getInvestors().containsKey(investor.getName())){
            System.out.println(Status.NOT_REGISTERED);
        }
        else{
            stockExchange.getInvestors().put(investor.getName(), investor);
            System.out.println("Investor "+investor.getName()+" is "+Status.REGISTERED);
        }
    }
    public void buyingStock(Buy_Sell buy){
        //checkif stock present for company
        Company company = stockExchange.getCompanies().get(buy.getCompanyName());
        Investor investor = stockExchange.getInvestors().get(buy.getInvestorName());
        if(company.getNoOfShares()>=buy.getNoOfShares()){
            double buyPrice = 0;
            for(int i=0;i<buy.getNoOfShares();i++){
                double mspCompany = company.getCurrentCompanyWorth()/company.getIntialNoOfShares();
                buyPrice+=mspCompany;
                company.setCurrentCompanyWorth(company.getCurrentCompanyWorth()+mspCompany);
                company.setNoOfShares(company.getNoOfShares()-1);
                company.setSellingPrice(mspCompany);
            }
            Stock stock = new Stock(buy.getCompanyName(),buy.getNoOfShares());
            investor.getHoldingStocks().add(stock);
            double avgPrice = buyPrice/buy.getNoOfShares();

            stockExchange.setTransactionProfit(stockExchange.getTransactionProfit()+.01*buyPrice);

            System.out.println("Success, Avg Price: "+df.format(avgPrice) + " Total Price: "+df.format(buyPrice));


        }
        else{
            System.out.println("Shares are not avavilable");
        }



    }
    public void sellingStock(Buy_Sell sell){
        //checkif stock present for company
        Company company = stockExchange.getCompanies().get(sell.getCompanyName());
        Investor investor = stockExchange.getInvestors().get(sell.getInvestorName());
        List<Stock> stocks = investor.getHoldingStocks();
        Stock stock = null;
        for(Stock st:stocks){
            if(st.getCompanyName().equals(sell.getCompanyName())){
                stock = st;
                break;
            }
        }
        if(stock==null) {
            System.out.println("Required Stocks are not available in Investors List");
            return;
        }


        if(stock.getNoOfShares()>=sell.getNoOfShares()){
            double sellPrice = 0;
            for(int i=0;i<sell.getNoOfShares();i++){
                double mspCompany = company.getCurrentCompanyWorth()/company.getIntialNoOfShares();
                sellPrice+=mspCompany;
                company.setCurrentCompanyWorth(company.getCurrentCompanyWorth()-mspCompany);
                company.setNoOfShares(company.getNoOfShares()+1);
                company.setSellingPrice(mspCompany);
                stock.setNoOfShares(stock.getNoOfShares()-1);
            }
            double avgPrice = sellPrice/sell.getNoOfShares();
            stockExchange.setTransactionProfit(stockExchange.getTransactionProfit()+.01*sellPrice);

            System.out.println("Success, Avg Price: "+df.format(avgPrice) + " Total Price: "+df.format(sellPrice));


        }
        else{
            System.out.println("Shares are not avavilable");
        }
    }

    public void showInvetorShares(String investorName){
        Investor investor = stockExchange.getInvestors().get(investorName);
        System.out.println("Showing Investor "+investorName+" Stocks");
        for(Stock st: investor.getHoldingStocks()){
            System.out.println(st.getCompanyName()+": "+st.getNoOfShares());
        }
    }
    public void showCompanyShares(String companyName){
        Company company = stockExchange.getCompanies().get(companyName);
        System.out.println("Showing Company "+companyName+" Details");
        System.out.println("Company Worth: "+df.format(company.getCurrentCompanyWorth()));
        System.out.println("Stocks Remaning: "+company.getNoOfShares());
        System.out.println("Selling Price: "+df.format(company.getSellingPrice()));

    }

    public void showStockExchangeDetails(){
        HashMap<String,Company> companies = stockExchange.getCompanies();
        System.out.println("StockExchanage Details");
        for(String s : companies.keySet()){
            Company company = companies.get(s);
            double percentageChange = (company.getSellingPrice()-company.getInitialStockPrice())/ company.getInitialStockPrice()*100;
            System.out.println(s+" "+df.format(company.getSellingPrice())+" "+df.format(percentageChange)+"%");
        }
    }
    public void showProfit(){
        System.out.println("StockExchanage Profit: "+df.format(stockExchange.getTransactionProfit()));
    }




}
