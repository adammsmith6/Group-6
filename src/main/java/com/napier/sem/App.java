package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class App {
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
     * Gets all countries in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all countries,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountries()
    {
        try
        {
            // SQL for Use Case 1:
            // Retrieve all countries and their capital city names,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT country.Code, country.Name, country.Continent, " +
                            "country.Region, country.Population, city.Name AS Capital " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "ORDER BY country.Population DESC";

            // Create a statement to execute the SQL query.
            Statement stmt = con.createStatement();

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery(sql);

            // Create a list to store all countries retrieved from the database.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a new Country object for the current row.
                Country country = new Country();

                // Store the database values in the Country object.
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");

                // Add the country to the list.
                countries.add(country);
            }

            // Return the completed list of countries.
            return countries;
        }
        catch (Exception e)
        {
            // Display an error if the country information cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");

            return null;
        }
    }

    /**
     * Displays a report of countries including their code, name,
     * continent, region, population and capital.
     *
     * @param countries List of countries to be displayed.
     */
    public void displayCountries(ArrayList<Country> countries)
    {
        // Check if the list is null.
        if (countries == null)
        {
            System.out.println("No country information available.");
            return;
        }

        // Check if the list contains no countries.
        if (countries.isEmpty())
        {
            System.out.println("No countries found.");
            return;
        }

        // Display the column headings for the country report.
        System.out.printf(
                "%-5s %-35s %-20s %-30s %-15s %-30s%n",
                "Code",
                "Name",
                "Continent",
                "Region",
                "Population",
                "Capital"
        );

        // Display each country in the report.
        for (Country country : countries)
        {
            System.out.printf(
                    "%-5s %-35s %-20s %-30s %-15d %-30s%n",
                    country.code,
                    country.name,
                    country.continent,
                    country.region,
                    country.population,
                    country.capital
            );
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
