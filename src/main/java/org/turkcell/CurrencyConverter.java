package org.turkcell;

import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    static String fromCurrency;
    static String toCurrency;
    static Double amount;
    static Double convertedAmount;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the currency you want to convert from (USD or EUR): ");
        fromCurrency = sc.nextLine();

        System.out.print("Enter the currency you want to convert to (USD or EUR): ");
        toCurrency = sc.nextLine();

        System.out.print("Please enter the amount which you would like to convert: ");
        amount = sc.nextDouble();
        convertedAmount = convert(amount);


        if((toCurrency.equals("USD") || toCurrency.equals("EUR")) && (fromCurrency.equals("USD") || fromCurrency.equals("EUR"))){
            System.out.print(amount + " " +  fromCurrency + " is the equivalent of " + convertedAmount + " " + toCurrency);
        }
        else
            System.out.print("Sorry, I am only able to convert USD and EUR at the moment. Please try again.");

    }

    public static double convert(Double amount) {

        HashMap<String, Double> currencyHashmap = new HashMap<String, Double>();
        currencyHashmap.put("usdRate",1.00);
        currencyHashmap.put("eurRate",1.20);

        if(fromCurrency.equals("EUR")){

            if(toCurrency.equals("USD")){
                amount = amount * (currencyHashmap.get("eurRate") / currencyHashmap.get("usdRate"));
                return amount;
            }

            else if(toCurrency.equals("EUR")){
                amount = amount * (currencyHashmap.get("eurRate") / currencyHashmap.get("eurRate"));
                return amount;
            }

        } else if (fromCurrency.equals("USD")) {

            if(toCurrency.equals("EUR")){
                amount = amount * (currencyHashmap.get("usdRate") / currencyHashmap.get("eurRate"));
                return amount;
            }

            else if(toCurrency.equals("USD")){
                amount = amount * (currencyHashmap.get("usdRate") / currencyHashmap.get("usdRate"));
                return amount;
            }

        }

        return amount;

    }
}
