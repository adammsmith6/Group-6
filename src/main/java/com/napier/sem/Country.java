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
     * Displays a country population report.
     *
     * @param countries List of countries to display.
     */
    public void displayCountries(ArrayList<Country> countries)
    {
        if (countries == null)
        {
            System.out.println("No country information available.");
            return;
        }

        if (countries.isEmpty())
        {
            System.out.println("No countries found.");
            return;
        }

        // Display report column headings.
        System.out.printf(
                "%-5s %-35s %-20s %-30s %-15s %-30s%n",
                "Code",
                "Name",
                "Continent",
                "Region",
                "Population",
                "Capital"
        );

        // Display each country's information.
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

    // --------------------------------------------------
    // USE CASE 1
    // All countries in the world by population.
    // --------------------------------------------------

    /**
     * Retrieves all countries in the world ordered
     * by population from largest to smallest.
     *
     * @return List of all countries.
     */
    public ArrayList<Country> getCountries()
    {
        String sql =
                "SELECT country.Code, country.Name, " +
                        "country.Continent, country.Region, " +
                        "country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "ORDER BY country.Population DESC";

        return retrieveCountries(sql);
    }

    // --------------------------------------------------
    // USE CASE 2
    // All countries in a specified continent.
    // --------------------------------------------------

    /**
     * Retrieves countries in the specified continent,
     * ordered by population.
     *
     * @param continent Continent to search.
     * @return List of countries in the continent.
     */
    public ArrayList<Country> getCountriesByContinent(
            String continent)
    {
        String sql =
                "SELECT country.Code, country.Name, " +
                        "country.Continent, country.Region, " +
                        "country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Continent = ? " +
                        "ORDER BY country.Population DESC";

        return retrieveCountries(sql, continent);
    }

    /**
     * Displays countries in a specified continent.
     */
    public void displayCountriesByContinent(
            ArrayList<Country> countries)
    {
        displayCountries(countries);
    }

    // --------------------------------------------------
    // USE CASE 3
    // All countries in a specified region.
    // --------------------------------------------------

    /**
     * Retrieves countries in a specified region,
     * ordered by population.
     *
     * @param region Region to search.
     * @return List of countries in the region.
     */
    public ArrayList<Country> getCountriesByRegion(String region)
    {
        String sql =
                "SELECT country.Code, country.Name, " +
                        "country.Continent, country.Region, " +
                        "country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Region = ? " +
                        "ORDER BY country.Population DESC";

        return retrieveCountries(sql, region);
    }

    /**
     * Displays countries in a specified region.
     */
    public void displayCountriesByRegion(
            ArrayList<Country> countries)
    {
        displayCountries(countries);
    }

    // --------------------------------------------------
    // USE CASE 4
    // Top N populated countries in the world.
    // --------------------------------------------------

    /**
     * Retrieves the top N populated countries
     * in the world.
     *
     * @param n Number of countries to retrieve.
     * @return List of top N countries.
     */
    public ArrayList<Country> getTopNCountries(int n)
    {
        if (n <= 0)
        {
            System.out.println("N must be greater than zero.");
            return new ArrayList<>();
        }

        String sql =
                "SELECT country.Code, country.Name, " +
                        "country.Continent, country.Region, " +
                        "country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "ORDER BY country.Population DESC " +
                        "LIMIT ?";

        return retrieveCountries(sql, n);
    }

    /**
     * Displays the top N populated countries.
     */
    public void displayTopNCountries(
            ArrayList<Country> countries)
    {
        displayCountries(countries);
    }

    // --------------------------------------------------
    // USE CASE 5
    // Top N countries in a specified continent.
    // --------------------------------------------------

    /**
     * Retrieves the top N populated countries
     * in a specified continent.
     *
     * @param continent Continent to search.
     * @param n Number of countries to retrieve.
     * @return List of countries.
     */
    public ArrayList<Country> getTopNCountriesByContinent(
            String continent, int n)
    {
        if (n <= 0)
        {
            System.out.println("N must be greater than zero.");
            return new ArrayList<>();
        }

        String sql =
                "SELECT country.Code, country.Name, " +
                        "country.Continent, country.Region, " +
                        "country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Continent = ? " +
                        "ORDER BY country.Population DESC " +
                        "LIMIT ?";

        return retrieveCountries(sql, continent, n);
    }

    /**
     * Displays the top N countries in a continent.
     */
    public void displayTopNCountriesByContinent(
            ArrayList<Country> countries)
    {
        displayCountries(countries);
    }

    // --------------------------------------------------
    // USE CASE 6
    // Top N countries in a specified region.
    // --------------------------------------------------

    /**
     * Retrieves the top N populated countries
     * in a specified region.
     *
     * @param region Region to search.
     * @param n Number of countries to retrieve.
     * @return List of countries.
     */
    public ArrayList<Country> getTopNCountriesByRegion(
            String region, int n)
    {
        if (n <= 0)
        {
            System.out.println("N must be greater than zero.");
            return new ArrayList<>();
        }

        String sql =
                "SELECT country.Code, country.Name, " +
                        "country.Continent, country.Region, " +
                        "country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Region = ? " +
                        "ORDER BY country.Population DESC " +
                        "LIMIT ?";

        return retrieveCountries(sql, region, n);
    }

    /**
     * Displays the top N countries in a region.
     */
    public void displayTopNCountriesByRegion(
            ArrayList<Country> countries)
    {
        displayCountries(countries);
    }
}