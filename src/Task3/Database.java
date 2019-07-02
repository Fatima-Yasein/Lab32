package Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
    private static String dataBaseDriver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/msg_app";
    private static String userName = "root";
    private static String password = "toor";



    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName(dataBaseDriver);
        //System.out.println("Driver loaded\n");

        Connection connection= DriverManager.getConnection(url,userName,password);
        //System.out.println("Database connected\n");

        return connection;
    }
}
