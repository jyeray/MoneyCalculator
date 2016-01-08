package moneycalculator.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class SQLiteCurrencySetReader implements CurrencySetReader {

    @Override
    public CurrencySet read() {
        List<Currency> currencyList = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement state= connection.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM DIVISAS");
            while (rs.next()){
                currencyList.add(new Currency(rs.getString("NOMBRE"), rs.getString("SIMBOLO"), rs.getString("CODIGO")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SQLiteCurrencySetReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new CurrencySet(currencyList);
    }

}
