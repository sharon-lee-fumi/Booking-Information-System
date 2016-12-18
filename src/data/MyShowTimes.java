package data;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xiaowen Li
 */
public class MyShowTimes
{

    public static void main(String[] args)
    {
        // create a dataAccess object
        CinemaAccess myConn = new CinemaAccess();

        try
        {
            if (myConn.connect())
            {
                System.out.println("Available movie shows:");
            } else
            {
                System.out.println("Error");
            }
            myConn.show();
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(MyShowTimes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            Logger.getLogger(MyShowTimes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(MyShowTimes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            System.out.println("Database operation faild");
            Logger.getLogger(MyShowTimes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
