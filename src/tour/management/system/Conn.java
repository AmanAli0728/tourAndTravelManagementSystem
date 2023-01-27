package tour.management.system;

import java.sql.*;
import java.sql.DriverManager;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        /*
        5 steps of database connectivity:-
        1.Register the driver
        2.Creating the connection string
        3.Creating the statement
        4.Executing mysql queries
        5.Closing the connections  // it is optional
        */

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "anurag@123");
            s = c.createStatement(); //It is a function in which we have to create  statement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
