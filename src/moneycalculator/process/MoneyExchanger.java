package moneycalculator.process;

import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;

public class MoneyExchanger {
    
    public static Money exchange(Money moneyFrom, ExchangeRate exchangeRate){
        return new Money(exchangeRate.getCurrencyTo(),moneyFrom.getAmount()*exchangeRate.getExchangeRate());
    }
}
