package desginpattern.singleton;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static volatile Database database;
    public static volatile Connection connection;

    public Database() {

        if (database != null){
            throw new RuntimeException("Use the getDatabase method!");
        }
    }

    public static Database getDatabase() {

        if (database == null){
            synchronized (Data.class){
                if (database == null){
                    database = new Database();
                }
            }
        }

        return database;
    }

    public Connection getConnection(){

        if (connection == null){
            synchronized (Data.class){
                if (connection == null){
                    String url = "jdbc:derby:memory:sample;create=true";
                    try {
                        connection = DriverManager.getConnection(url);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return connection;
    }

}
