package moneycalculator.model;

public class Money {
    private final Currency currency;
    private final int amount;

    public Money(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }
    
}
