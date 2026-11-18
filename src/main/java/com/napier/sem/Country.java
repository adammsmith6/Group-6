package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Represents a country and the information required
 * for the country population reports.
 */
public class Country
{
    // Unique country code, e.g. GBR
    public String code;

    // Name of the country
    public String name;

    // Continent where the country is located
    public String continent;

    // Region where the country is located
    public String region;

    // Total population of the country
    public int population;

    // Name of the country's capital city
    public String capital;

    // Database connection used for country reports.
    private Connection con;

    /**
     * Constructor used when creating individual
     * country objects from database results.
     */
    public Country()
    {
    }

    /**
     * Constructor used for retrieving country reports.
     *
     * @param connection Active database connection.
     */
    public Country(Connection connection)
    {
        this.con = connection;
    }

    /**
     * Retrieves countries using a given SQL query.
     * This method is shared by UC1 to UC6 to avoid
     * repeating the same database processing code.
     *
     * @param sql SQL query to execute.
     * @param parameters Values for SQL placeholders.
     * @return List of countries, or null if retrieval fails.
     */
    private ArrayList<Country> retrieveCountries(
            String sql, Object... parameters)
    {
        ArrayList<Country> countries = new ArrayList<>();

        if (con == null)
        {
            System.out.println("Database connection unavailable.");
            return null;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql))
        {
            // Set the parameters for the SQL query.
            for (int i = 0; i < parameters.length; i++)
            {
                stmt.setObject(i + 1, parameters[i]);
            }

            // Execute the query and process the results.
            try (ResultSet rset = stmt.executeQuery())
            {
                while (rset.next())
                {
                    // Create a Country object for each row.
                    Country country = new Country();

                    country.code = rset.getString("Code");
                    country.name = rset.getString("Name");
                    country.continent = rset.getString("Continent");
                    country.region = rset.getString("Region");
                    country.population = rset.getInt("Population");
                    country.capital = rset.getString("Capital");

                    countries.add(country);
                }
            }

            return countries;
        }
        catch (SQLException e)
        {
            System.out.println("Failed to retrieve countries.");
            System.out.println(e.getMessage());
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
}