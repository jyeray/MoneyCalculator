package moneycalculator.model;

import java.util.List;

public class CurrencySet {

    private final List<Currency> list;

    public CurrencySet(List<Currency> list) {
        this.list = list;
    }
    
    public Currency get(String string){
        for (Currency currency : list) {
            if ( currency.getCode().equals(string) || currency.getName().equals(string) || currency.getSymbol().equals(string)){
                return currency;
            }
        }
        return null;
    }
}
