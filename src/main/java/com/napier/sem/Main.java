package com.napier.sem;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main (String[]args){
            System.out.printf("Hello and welcome!");
        }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;

        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");

            try
            {
                // Wait for database container to start
                Thread.sleep(30000);

                // Connect to World database
                con = DriverManager.getConnection(
                        "jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root",
                        "example"
                );

                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println(
                        "Failed to connect to database attempt " + i
                );
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println(
                        "Thread interrupted? Should not happen."
                );
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                System.out.println(
                        "Error closing connection to database"
                );
            }
        }
    }

}