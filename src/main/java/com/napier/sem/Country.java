package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Represents a country and the information required
 * for the country population reports.
 */
public class Country {
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
    public Country() {
    }

    /**
     * Constructor used for retrieving country reports.
     *
     * @param connection Active database connection.
     */
    public Country(Connection connection) {
        this.con = connection;
    }

    /**
     * Gets all countries in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all countries,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountries() {
        // SQL for Use Case 1:
        // Retrieve all countries within the world.
        String sql = "SELECT country.Code, country.Name, country.Continent, " +
                "country.Region, country.Population, city.Name AS Capital " +
                "FROM country " +
                "LEFT JOIN city ON country.Capital = city.ID " +
                "ORDER BY country.Population DESC";

        return getCountries(sql);
    }


    /**
     * Retrieves countries using a given SQL query.
     * This method is shared by UC1 to UC6 to avoid
     * repeating the same database processing code.
     *
     * @param sql SQL query to execute.
     * @return List of countries, or null if retrieval fails.
     */
    private ArrayList<Country> getCountries(String sql) {
        if (con == null) {
            System.out.println("Database connection unavailable.");
            return null;
        }

        try {   // Create a statement to execute the SQL query.
            Statement stmt = con.createStatement();

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery(sql);

            // Create a list to store all countries retrieved from the database.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next()) {
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
        } catch (Exception e) {
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
    public void displayCountries(ArrayList<Country> countries) {
        // Check if the list is null.
        if (countries == null) {
            System.out.println("No country information available.");
            return;
        }

        // Check if the list contains no countries.
        if (countries.isEmpty()) {
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
        for (Country country : countries) {
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
    // USE CASE 2
    // All countries in a specified continent.
    // --------------------------------------------------

    /**
     * Gets all countries in a specified continent from the database,
     * ordered by population from largest to smallest.
     *
     * @param continent The continent to search for.
     * @return An ArrayList containing all countries in the specified continent,
     * or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountriesByContinent(String continent) {
        // SQL for Use Case 2:
        // Retrieve all countries in a specified continent,
        // ordered from largest population to smallest.
        String sql =
                "SELECT country.Code, country.Name, country.Continent, " +
                        "country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Continent = '" + continent + "' " +
                        "ORDER BY country.Population DESC";

        return getCountries(sql);
    }

    // --------------------------------------------------
    // USE CASE 3
    // All countries in a specified region.
    // --------------------------------------------------

    /**
     * Gets all countries in a specified region from the database,
     * ordered by population from largest to smallest.
     *
     * @param region The region to search for.
     * @return An ArrayList containing all countries in the specified region,
     * or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountriesByRegion(String region) {
        // SQL for Use Case 3:
        // Retrieve all countries in a specified region,
        // ordered from largest population to smallest.
        String sql =
                "SELECT country.Code, country.Name, country.Continent, " +
                        "country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Region = '" + region + "' " +
                        "ORDER BY country.Population DESC";

        return getCountries(sql);
    }


    // --------------------------------------------------
    // USE CASE 4
    // Top N Countries
    // --------------------------------------------------

    /**
     * Gets the top N populated countries in the world,
     * ordered by population from largest to smallest.
     *
     * @param n The number of countries to retrieve.
     * @return An ArrayList containing the top N populated countries,
     * or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getTopNCountries(int n) {
        // SQL for Use Case 4:
        // Retrieve the top N populated countries in the world,
        // ordered from largest population to smallest.
        String sql =
                "SELECT country.Code, country.Name, country.Continent, " +
                        "country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "ORDER BY country.Population DESC " +
                        "LIMIT " + n;

        return getCountries(sql);
    }


    // --------------------------------------------------
    // USE CASE 5
    // Top N Countries in a Specified Continent
    // --------------------------------------------------

    /**
     * Gets the top N populated countries in a specified continent,
     * ordered by population from largest to smallest.
     *
     * @param continent The continent to search for.
     * @param n         The number of countries to retrieve.
     * @return An ArrayList containing the top N populated countries
     * in the specified continent, or null if the data
     * cannot be retrieved.
     */
    public ArrayList<Country> getTopNCountriesByContinent(String continent, int n) {
        // SQL for Use Case 5:
        // Retrieve the top N populated countries in a specified continent,
        // ordered from largest population to smallest.
        String sql =
                "SELECT country.Code, country.Name, country.Continent, " +
                        "country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Continent = '" + continent + "' " +
                        "ORDER BY country.Population DESC " +
                        "LIMIT " + n;

        return getCountries(sql);
    }

    // --------------------------------------------------
    // USE CASE 6
    // Top N Countries in a Specified Region
    // --------------------------------------------------

    /**
     * Gets the top N populated countries in a specified region,
     * ordered by population from largest to smallest.
     *
     * @param region The region to search for.
     * @param n The number of countries to retrieve.
     * @return An ArrayList containing the top N populated countries
     *         in the specified region, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<Country> getTopNCountriesByRegion(String region, int n)
    {       // SQL for Use Case 6:
        // Retrieve the top N populated countries in a specified region,
        // ordered from largest population to smallest.
        String sql =
                "SELECT country.Code, country.Name, country.Continent, " +
                        "country.Region, country.Population, city.Name AS Capital " +
                        "FROM country " +
                        "LEFT JOIN city ON country.Capital = city.ID " +
                        "WHERE country.Region = '" + region + "' " +
                        "ORDER BY country.Population DESC " +
                        "LIMIT " + n;

        return getCountries(sql);
    }
}