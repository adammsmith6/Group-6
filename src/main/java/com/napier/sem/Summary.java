
package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Retrieves and displays population totals.
 *
 * Use Cases 26 to 31.
 */
public class Summary
{
    // Connection to the MySQL world database.
    private final Connection con;

    /**
     * Creates a population summary reporting object.
     *
     * @param connection Active database connection.
     */
    public Summary(Connection connection)
    {
        this.con = connection;
    }

    /**
     * Executes a population query and returns its result.
     *
     * @param sql SQL statement.
     * @param parameter Optional filter value.
     * @return Population total, or null if unavailable.
     */
    private Long retrievePopulation(String sql, String parameter)
    {
        if (con == null)
        {
            System.out.println("Database connection unavailable.");
            return null;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql))
        {
            // Set the parameter for filtered queries.
            if (parameter != null)
            {
                stmt.setString(1, parameter);
            }

            try (ResultSet rset = stmt.executeQuery())
            {
                if (rset.next())
                {
                    long population = rset.getLong("Population");

                    // SQL SUM returns NULL when no records match.
                    if (rset.wasNull())
                    {
                        return null;
                    }

                    return population;
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve population.");
        }

        return null;
    }

    /**
     * Displays a population total.
     *
     * @param label Name of the location.
     * @param population Retrieved population.
     */
    private void displayPopulation(String label, Long population)
    {
        if (population == null)
        {
            System.out.println("No population information available.");
            return;
        }

        System.out.printf("%-35s %,d%n", label, population);
    }

    // -------------------------
    // Use Case 26 - World Population
    // -------------------------

    /**
     * Gets the total population of the world.
     *
     * @return World population.
     */
    public Long getWorldPopulation()
    {
        String sql =
                "SELECT SUM(Population) AS Population " +
                        "FROM country";

        return retrievePopulation(sql, null);
    }

    /**
     * Displays the total world population.
     */
    public void displayWorldPopulation(Long population)
    {
        displayPopulation("World", population);
    }

    // -------------------------
    // Use Case 27 - Continent Population
    // -------------------------

    /**
     * Gets the population of a specified continent.
     *
     * @param continent Name of the continent.
     * @return Continent population.
     */
    public Long getContinentPopulation(String continent)
    {
        String sql =
                "SELECT SUM(Population) AS Population " +
                        "FROM country " +
                        "WHERE Continent = ?";

        return retrievePopulation(sql, continent);
    }

    /**
     * Displays a continent's population.
     */
    public void displayContinentPopulation(
            String continent, Long population)
    {
        displayPopulation(continent, population);
    }

    // -------------------------
    // Use Case 28 - Region Population
    // -------------------------

    /**
     * Gets the population of a specified region.
     *
     * @param region Name of the region.
     * @return Region population.
     */
    public Long getRegionPopulation(String region)
    {
        String sql =
                "SELECT SUM(Population) AS Population " +
                        "FROM country " +
                        "WHERE Region = ?";

        return retrievePopulation(sql, region);
    }

    /**
     * Displays a region's population.
     */
    public void displayRegionPopulation(
            String region, Long population)
    {
        displayPopulation(region, population);
    }

    // -------------------------
    // Use Case 29 - Country Population
    // -------------------------

    /**
     * Gets the population of a specified country.
     *
     * @param country Name of the country.
     * @return Country population.
     */
    public Long getCountryPopulation(String country)
    {
        String sql =
                "SELECT SUM(Population) AS Population " +
                        "FROM country " +
                        "WHERE Name = ?";

        return retrievePopulation(sql, country);
    }

    /**
     * Displays a country's population.
     */
    public void displayCountryPopulation(
            String country, Long population)
    {
        displayPopulation(country, population);
    }

    // -------------------------
    // Use Case 30 - District Population
    // -------------------------

    /**
     * Gets the total population of cities
     * recorded in a specified district.
     *
     * @param district Name of the district.
     * @return District population.
     */
    public Long getDistrictPopulation(String district)
    {
        String sql =
                "SELECT SUM(Population) AS Population " +
                        "FROM city " +
                        "WHERE District = ?";

        return retrievePopulation(sql, district);
    }

    /**
     * Displays a district's population.
     */
    public void displayDistrictPopulation(
            String district, Long population)
    {
        displayPopulation(district, population);
    }

    // -------------------------
    // Use Case 31 - City Population
    // -------------------------

    /**
     * Gets the population of a named city.
     *
     * @param city Name of the city.
     * @return City population.
     */
    public Long getCityPopulation(String city)
    {
        String sql =
                "SELECT SUM(Population) AS Population " +
                        "FROM city " +
                        "WHERE Name = ?";

        return retrievePopulation(sql, city);
    }

    /**
     * Displays a city's population.
     */
    public void displayCityPopulation(
            String city, Long population)
    {
        displayPopulation(city, population);
    }
}
