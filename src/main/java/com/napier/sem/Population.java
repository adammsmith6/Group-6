
package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Represents population information and handles
 * population reports for Use Cases 23 to 25.
 */
public class Population
{
    // Name of the continent, region, or country.
    public String name;

    // Total population.
    public long totalPopulation;

    // Population living in cities.
    public long cityPopulation;

    // Population not living in cities.
    public long nonCityPopulation;

    // Percentage of population living in cities.
    public double cityPercentage;

    // Percentage of population not living in cities.
    public double nonCityPercentage;

    // Database connection used for population reports.
    private Connection con;

    /**
     * Constructor for creating individual population objects.
     */
    public Population()
    {
    }

    /**
     * Constructor for retrieving population reports.
     *
     * @param connection Active MySQL database connection.
     */
    public Population(Connection connection)
    {
        this.con = connection;
    }

    /**
     * Retrieves population information from the database.
     * Shared by UC23, UC24, and UC25.
     *
     * @param sql SQL query to execute.
     * @return List of population records,
     *         or null if retrieval fails.
     */
    private ArrayList<Population> retrievePopulation(String sql)
    {
        if (con == null)
        {
            System.out.println("Database connection unavailable.");
            return null;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rset = stmt.executeQuery())
        {
            // Create a list to store population records.
            ArrayList<Population> populations = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a Population object for each row.
                Population population = new Population();

                // Retrieve the population information.
                population.name = rset.getString("Name");

                population.totalPopulation =
                        rset.getLong("TotalPopulation");

                population.cityPopulation =
                        rset.getLong("CityPopulation");

                // Calculate the non-city population.
                population.nonCityPopulation =
                        population.totalPopulation
                                - population.cityPopulation;

                // Avoid division by zero.
                if (population.totalPopulation > 0)
                {
                    population.cityPercentage =
                            population.cityPopulation * 100.0
                                    / population.totalPopulation;

                    population.nonCityPercentage =
                            population.nonCityPopulation * 100.0
                                    / population.totalPopulation;
                }
                else
                {
                    population.cityPercentage = 0;
                    population.nonCityPercentage = 0;
                }

                // Add the population object to the list.
                populations.add(population);
            }

            // Return the completed list.
            return populations;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Displays population information in a formatted table.
     *
     * @param populations List of population records.
     * @param heading Name of the report's first column.
     */
    private void displayPopulation(
            ArrayList<Population> populations,
            String heading)
    {
        // Check if the list is null.
        if (populations == null)
        {
            System.out.println("No population information available.");
            return;
        }

        // Check if the list is empty.
        if (populations.isEmpty())
        {
            System.out.println("No population records found.");
            return;
        }

        // Display the report column headings.
        System.out.printf(
                "%-40s %-18s %-18s %-18s %-12s %-12s%n",
                heading,
                "Total Population",
                "City Population",
                "Non-City Population",
                "City %",
                "Non-City %"
        );

        // Display each population record.
        for (Population population : populations)
        {
            System.out.printf(
                    "%-40s %-18d %-18d %-18d %-12.2f %-12.2f%n",
                    population.name,
                    population.totalPopulation,
                    population.cityPopulation,
                    population.nonCityPopulation,
                    population.cityPercentage,
                    population.nonCityPercentage
            );
        }
    }

    // --------------------------------------------------
    // USE CASE 23
    // Population by Continent
    // --------------------------------------------------

    /**
     * Retrieves population statistics for each continent.
     *
     * Includes total population, city population,
     * non-city population, and percentages.
     *
     * @return List of continent population records.
     */
    public ArrayList<Population> getPopulationByContinent()
    {
        // Retrieve the population of each continent.
        String sql =
                "SELECT country.Continent AS Name, " +
                        "SUM(country.Population) AS TotalPopulation, " +
                        "SUM(COALESCE(city_pop.CityPopulation, 0)) " +
                        "AS CityPopulation " +
                        "FROM country " +
                        "LEFT JOIN ( " +
                        "SELECT CountryCode, " +
                        "SUM(Population) AS CityPopulation " +
                        "FROM city " +
                        "GROUP BY CountryCode " +
                        ") city_pop " +
                        "ON country.Code = city_pop.CountryCode " +
                        "GROUP BY country.Continent " +
                        "ORDER BY country.Continent";

        return retrievePopulation(sql);
    }

    /**
     * Displays population statistics for each continent.
     *
     * @param populations List of continent populations.
     */
    public void displayPopulationByContinent(
            ArrayList<Population> populations)
    {
        displayPopulation(populations, "Continent");
    }

    // --------------------------------------------------
    // USE CASE 24
    // Population by Region
    // --------------------------------------------------

    /**
     * Retrieves population statistics for each region.
     *
     * Includes total population, city population,
     * non-city population, and percentages.
     *
     * @return List of region population records.
     */
    public ArrayList<Population> getPopulationByRegion()
    {
        // Retrieve the population of each region.
        String sql =
                "SELECT country.Region AS Name, " +
                        "SUM(country.Population) AS TotalPopulation, " +
                        "SUM(COALESCE(city_pop.CityPopulation, 0)) " +
                        "AS CityPopulation " +
                        "FROM country " +
                        "LEFT JOIN ( " +
                        "SELECT CountryCode, " +
                        "SUM(Population) AS CityPopulation " +
                        "FROM city " +
                        "GROUP BY CountryCode " +
                        ") city_pop " +
                        "ON country.Code = city_pop.CountryCode " +
                        "GROUP BY country.Region " +
                        "ORDER BY country.Region";

        return retrievePopulation(sql);
    }

    /**
     * Displays population statistics for each region.
     *
     * @param populations List of region populations.
     */
    public void displayPopulationByRegion(
            ArrayList<Population> populations)
    {
        displayPopulation(populations, "Region");
    }

    // --------------------------------------------------
    // USE CASE 25
    // Population by Country
    // --------------------------------------------------

    /**
     * Retrieves population statistics for each country.
     *
     * Includes total population, city population,
     * non-city population, and percentages.
     *
     * @return List of country population records.
     */
    public ArrayList<Population> getPopulationByCountry()
    {
        // Retrieve population information for each country.
        String sql =
                "SELECT country.Name AS Name, " +
                        "country.Population AS TotalPopulation, " +
                        "COALESCE(city_pop.CityPopulation, 0) " +
                        "AS CityPopulation " +
                        "FROM country " +
                        "LEFT JOIN ( " +
                        "SELECT CountryCode, " +
                        "SUM(Population) AS CityPopulation " +
                        "FROM city " +
                        "GROUP BY CountryCode " +
                        ") city_pop " +
                        "ON country.Code = city_pop.CountryCode " +
                        "ORDER BY country.Name";

        return retrievePopulation(sql);
    }

    /**
     * Displays population statistics for each country.
     *
     * @param populations List of country populations.
     */
    public void displayPopulationByCountry(
            ArrayList<Population> populations)
    {
        displayPopulation(populations, "Country");
    }
}
