package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents a capital city and the information required
 * for the capital city population reports.
 */
public class CapitalCity {

    // Name of the city
    public String name;

    // Name of the country it resides in
    public String country;

    // Total population of the city
    public int population;

    // Database connection used for capital city reports.
    private Connection con;

    /**
     * Constructor used when creating individual
     * capital city objects from database results.
     */
    public CapitalCity() {
    }

    /**
     * Constructor used for retrieving capital city reports.
     *
     * @param connection Active database connection.
     */
    public CapitalCity(Connection connection) {
        this.con = connection;
    }

    public ArrayList<CapitalCity> getCapitalCities() {
        // SQL for Use Case 17:
        // Retrieve all cities in the world, ordered from largest population to smallest.
        String sql = "SELECT city.Name, country.Name as 'Country', city.District, city.Population " +
                "FROM city " +
                "LEFT JOIN country ON city.CountryCode = country.Code " +
                "ORDER BY city.Population DESC";

        return getCapitalCities(sql);
    }


    /**
     * Retrieves capital cities using a given SQL query.
     * This method is shared by UC1 to UC6 to avoid
     * repeating the same database processing code.
     *
     * @param sql SQL query to execute.
     * @return List of capital cities, or null if retrieval fails.
     */
    private ArrayList<CapitalCity> getCapitalCities(String sql) {
        if (con == null) {
            System.out.println("Database connection unavailable.");
            return null;
        }

        try {
            // Create a statement to execute the SQL query.
            Statement stmt = con.createStatement();

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery(sql);

            // Create a list to store all capital cities retrieved from the database.
            ArrayList<CapitalCity> capitalCities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next()) {
                // Create a new CapitalCity object for the current row.
                CapitalCity capitalCity = new CapitalCity();

                // Store the database values in the CapitalCity object.
                capitalCity.name = rset.getString("Name");
                capitalCity.country = rset.getString("Country");
                capitalCity.population = rset.getInt("Population");

                // Add the capital city to the list.
                capitalCities.add(capitalCity);
            }

            // Return the completed list of city.
            return capitalCities;
        } catch (Exception e) {
            // Display an error if the city information cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details.");

            return null;
        }
    }


    // --------------------------------------------------
    // USE CASE 18
    // Get Capital Cities in a Specified Continent
    // --------------------------------------------------
    /**
     * Gets all capital cities in a specified continent,
     * ordered by population from largest to smallest.
     *
     * @param continent The continent to search for.
     * @return An ArrayList containing capital cities in the
     *         specified continent, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<CapitalCity> getCapitalCitiesByContinent(String continent)
    {
        // SQL for Use Case 18:
        // Retrieve all capital cities in a specified continent,
        // ordered from largest population to smallest.
        String sql =
                "SELECT city.Name, country.Name AS Country, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Capital = city.ID " +
                        "AND country.Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC";

        return getCapitalCities(sql);
    }

    // --------------------------------------------------
    // USE CASE 19
    // Get Capital Cities in a Specified Region
    // --------------------------------------------------
    /**
     * Gets all capital cities in a specified region,
     * ordered by population from largest to smallest.
     *
     * @param region The region to search for.
     * @return An ArrayList containing capital cities in the
     *         specified region, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<CapitalCity> getCapitalCitiesByRegion(String region) {
        // SQL for Use Case 19:
        // Retrieve all capital cities in a specified region,
        // ordered from largest population to smallest.
        String sql =
                "SELECT city.Name, country.Name AS Country, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Capital = city.ID " +
                        "AND country.Region = '" + region + "' " +
                        "ORDER BY city.Population DESC";

        return getCapitalCities(sql);
    }


    // --------------------------------------------------
    // USE CASE 20
    // Get Top N Populated Cities in the World
    // --------------------------------------------------
    /**
     * Gets the top N populated capital cities in the world,
     * ordered by population from largest to smallest.
     *
     * @param n The number of capital cities to retrieve.
     * @return An ArrayList containing the top N populated
     *         capital cities, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<CapitalCity> getTopNCapitalCities(int n)
    {
        // Check that N is a positive number.
        if (n <= 0)
        {
            System.out.println("N must be a positive number.");
            return null;
        }


        // SQL for Use Case 20:
        // Retrieve the top N most populated capital cities
        // in the world, ordered from largest to smallest.
        String sql =
                "SELECT city.Name, country.Name AS Country, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Capital = city.ID " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n;

        return getCapitalCities(sql);
    }


    // ---------------------------------------------------
    // USE CASE 21
    // Get Top N Populated Cities in a Specified Continent
    // ---------------------------------------------------
    /**
     * Gets the top N populated capital cities in a continent,
     * ordered from largest population to smallest.
     */
    public ArrayList<CapitalCity> getTopNCapitalCitiesByContinent(String continent, int n)
    {
        if (n <= 0)
        {
            System.out.println("N must be a positive number.");
            return null;
        }

        // Retrieve the top N capital cities in the selected continent.
        String sql =
                "SELECT city.Name, country.Name AS Country, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Capital = city.ID " +
                        "AND country.Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n;

        return getCapitalCities(sql);
    }


    // ---------------------------------------------------
    // USE CASE 22
    // Get Top N Populated Cities in a Specified Region
    // ---------------------------------------------------
    /**
     * Gets the top N populated capital cities in a region,
     * ordered from largest population to smallest.
     */
    public ArrayList<CapitalCity> getTopNCapitalCitiesByRegion(String region, int n)
    {
        if (n <= 0)
        {
            System.out.println("N must be a positive number.");
            return null;
        }

        // Retrieve the top N capital cities in the selected region.
        String sql =
                "SELECT city.Name, country.Name AS Country, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Capital = city.ID " +
                        "AND country.Region = '" + region + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n;

        return getCapitalCities(sql);
    }


    /**
     * Displays a report of cities including their name, country, district and population.
     *
     * @param capitalCities List of capital cities to be displayed.
     */
    public void displayCapitalCities(ArrayList<CapitalCity> capitalCities)
    {
        // Check if the list is null.
        if (capitalCities == null)
        {
            System.out.println("No city information available.");
            return;
        }

        // Check if the list contains no cities.
        if (capitalCities.isEmpty())
        {
            System.out.println("No cities found.");
            return;
        }

        // Display the column headings for the capital city report.
        System.out.printf(
                "%-35s %-35s %-15s%n",
                "Name",
                "Country",
                "Population"
        );

        // Display each Capital City in the report.
        for (CapitalCity capitalCity : capitalCities)
        {
            System.out.printf(
                    "%-35s %-35s %-15d%n",
                    capitalCity.name,
                    capitalCity.country,
                    capitalCity.population
            );
        }
    }
}