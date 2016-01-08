package moneycalculator.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public class SQLiteExachangeRateReader implements ExchangeRateReader{

    public SQLiteExachangeRateReader() {}
    
    @Override
    public ExchangeRate get(Currency currencyFrom, Currency currencyTo) {
        return new ExchangeRate(currencyFrom, currencyTo, (readEurTo(currencyTo)/readEurTo(currencyFrom)));
    }
    
    private double readEurTo(Currency currency){
        if ( currency.getCode().equals("EUR"))
            return 1.0;
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement state= connection.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM CAMBIO_EUR_A WHERE DIVISA='"+ currency.getCode() +"';");
            return rs.getDouble("CAMBIO");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return 0.0;
        }
    }

}
