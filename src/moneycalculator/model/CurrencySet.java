package moneycalculator.model;

import java.util.List;

public class CurrencySet {

    private final List<Currency> currencyList;

    public CurrencySet(List<Currency> list) {
        this.currencyList = list;
    }
    
    public Currency get(String string){
        for (Currency currency : currencyList) {
            if ( currency.getCode().equals(string) || currency.getName().equals(string) || currency.getSymbol().equals(string)){
                return currency;
            }
        }
        return null;
    }
    
    public List<Currency> getAllCurrencys(){
        return currencyList;
    }
}
