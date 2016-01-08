package moneycalculator.swing;

import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{

    private final JFormattedTextField moneyDialogField;
    private final SwingCurrencyDialog swingCurrencyDialog;

    public SwingMoneyDialog(SwingCurrencyDialog swingCurrencyDialog) {
        this.swingCurrencyDialog = swingCurrencyDialog;
        NumberFormat numberFormat = NumberFormat.getNumberInstance(); 
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        moneyDialogField = new JFormattedTextField(numberFormatter);
        moneyDialogField.setValue(0.0);
        moneyDialogField.setColumns(10);
        this.add(moneyDialogField);
    }
        
    @Override
    public Money get() {
        return new Money(swingCurrencyDialog.get(), Double.parseDouble(moneyDialogField.getValue().toString()));
    }
}
