package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.control.Command;
import moneycalculator.control.ExchangeCommand;
import moneycalculator.model.CurrencySet;
import moneycalculator.persistence.SQLiteCurrencySetReader;
import moneycalculator.persistence.SQLiteExachangeRateReader;
import moneycalculator.swing.SwingCurrencyDialog;
import moneycalculator.swing.SwingMoneyDialog;
import moneycalculator.swing.SwingMoneyDisplay;

public class MoneyCalculator extends JFrame {

    public static void main(String[] args) {
        new MoneyCalculator();
    }
    
    private final CurrencySet currencySet = new SQLiteCurrencySetReader().read();
    private final SwingCurrencyDialog currencyDialogFrom = new SwingCurrencyDialog(currencySet);
    private final SwingCurrencyDialog currencyDialogTo = new SwingCurrencyDialog(currencySet);
    private final SwingMoneyDialog moneyDialog = new SwingMoneyDialog(currencyDialogFrom);
    private final SwingMoneyDisplay moneyDisplay = new SwingMoneyDisplay();
    private final Map<String,Command> commands = new HashMap<>();
    
    public MoneyCalculator() {
        setCommands();
        deployUI();
    }
    
    private void deployUI() {
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(650, 200));
        this.pack();
        this.setLayout(new BorderLayout());
        this.add(dialogPanel(), BorderLayout.NORTH);
        this.add(moneyDisplay, BorderLayout.CENTER);
        this.add(exchangeButton(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private void setCommands() {
        commands.put("exchange", new ExchangeCommand(moneyDialog, currencyDialogTo, new SQLiteExachangeRateReader(), moneyDisplay));
    }

    private JButton exchangeButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(execute("exchange"));
        return button;
    }

    private ActionListener execute(String command) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
            }
        };
    }

    private JPanel dialogPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Exchange"));
        panel.add(moneyDialog);
        panel.add(currencyDialogFrom);
        panel.add(new JLabel("to"));
        panel.add(currencyDialogTo);
        return panel;
    }
}
