package moneycalculator.model;

public class ExchangeRate {
    private final Currency currencyFrom;
    private final Currency currencyTo;
    private final double exxhangeRate;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo, double exxhangeRate) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.exxhangeRate = exxhangeRate;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public double getExxhangeRate() {
        return exxhangeRate;
    }
    
    
}
