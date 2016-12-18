package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Xiaowen Li
 */
public class CinemaAccess 
{
    // define a field to model the connection
    private Connection conn;
    private Statement stm;
    private ResultSet res;

    // define the default constructor
    public CinemaAccess()
    {
    }

    // define a method called connect
    public boolean connect() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException
    {
        //define and set the data requied for the connection
        String driverName = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/galaxy";
        String userName = "root";
        String password = "sesame";
        try
        {
            // create instance from the driver(JDBC)
            Class.forName(driverName).newInstance();
            // open the connection to the server
            conn = DriverManager.getConnection(dbUrl, userName, password);
            return true;
        } catch (SQLException e)
        {
            return false;
        }
    }// end of the connect method
    
    public void show() throws SQLException
    {
        // prepare the sql statement
        String queryStm = "SELECT movieTitle, showDate, showTime,"
                + " cinemaName, phone FROM movies m INNER JOIN showTimes st ON "
                + "m.movieId=st.movieId INNER JOIN location l ON st.cinemaId=l.cinemaId;";
        // create the statement object
        stm = conn.createStatement();
        //execute the stm ad getting the Result set object
        res = stm.executeQuery(queryStm);
        // print all data
        while (res.next())
        {
            System.out.print(res.getString("movieTitle"));
            System.out.print(",");
            System.out.print(res.getDate("showDate"));
            System.out.print(",");
            System.out.print(res.getTime("showTime"));
            System.out.print(",");
            System.out.print(res.getString("cinemaName"));
            System.out.print(",");
            System.out.println(res.getString("phone"));
        }
    }   // end of show method

}
