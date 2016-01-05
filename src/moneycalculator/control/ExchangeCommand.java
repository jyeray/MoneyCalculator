package moneycalculator.control;

import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.process.MoneyExchanger;
import moneycalculator.persistence.ExchangeRateReader;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;

public class ExchangeCommand implements Command{

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateReader exchangeRateReader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateReader exchangeRateReader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateReader = exchangeRateReader;
        this.moneyDisplay = moneyDisplay;
    }
    
    @Override
    public void execute() {
        Money moneyFrom = moneyDialog.get();
        ExchangeRate exchangeRate = exchangeRateReader.get(moneyFrom.getCurrency(), currencyDialog.get());
        Money moneyTo = MoneyExchanger.exchange(moneyFrom, exchangeRate);
        moneyDisplay.show(moneyTo);
    }
    
}
