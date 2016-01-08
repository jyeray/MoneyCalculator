package moneycalculator.swing;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.ui.CurrencyDialog;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private final CurrencySet currencySet;
    private final JComboBox<Currency> comboBox = new JComboBox<>();

    public SwingCurrencyDialog(CurrencySet currencySet) {
        this.currencySet = currencySet;
        for (Currency currency : currencySet.getAllCurrencys()) {
            comboBox.addItem(currency);
        }
        this.add(comboBox);
    }
    
    @Override
    public Currency get() {
        String selected = comboBox.getSelectedItem().toString();
        String selectedCode = selected.substring(0,selected.indexOf(" -"));
        return currencySet.get(selectedCode);
    }
}
