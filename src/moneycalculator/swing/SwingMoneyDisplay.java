package moneycalculator.swing;

import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDisplay;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{

    private final JTextField display = new JTextField(25);

    public SwingMoneyDisplay() {
        display.setEditable(false);
        this.add(display);
    }

    @Override
    public void show(Money money) {
        this.display.setText(money.getAmount()+" "+money.getCurrency().getCode());
    }
}
