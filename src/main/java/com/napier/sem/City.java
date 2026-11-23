package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents a city and the information required
 * for the city population reports.
 */
public class City {

    // Name of the city
    public String name;

    // Name of the country it resides in
    public String country;

    // Name of the district it resides in
    public String district;

    // Total population of the city
    public int population;

    // Database connection used for city reports.
    private Connection con;

    /**
     * Constructor used when creating individual
     * city objects from database results.
     */
    public City() {
    }

    /**
     * Constructor used for retrieving city reports.
     *
     * @param connection Active database connection.
     */
    public City(Connection connection) {
        this.con = connection;
    }

    /**
     * Gets all cities in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all cities,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<City> getCities() {
        // SQL for Use Case 7:
        // Retrieve all cities in the world, ordered from largest population to smallest.
        String sql = "SELECT city.Name, country.Name as 'Country', city.District, city.Population " +
                "FROM city " +
                "LEFT JOIN country ON city.CountryCode = country.Code " +
                "ORDER BY city.Population DESC";

        return getCities(sql);
    }

    /**
     * Retrieves cities using a given SQL query.
     * This method is shared by UC1 to UC6 to avoid
     * repeating the same database processing code.
     *
     * @param sql SQL query to execute.
     * @return List of cities, or null if retrieval fails.
     */
    private ArrayList<City> getCities(String sql) {
        if (con == null) {
            System.out.println("Database connection unavailable.");
            return null;
        }
        try
        {
            // Create a statement to execute the SQL query.
            Statement stmt = con.createStatement();

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery(sql);

            // Create a list to store all cities retrieved from the database.
            ArrayList<City> cities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a new City object for the current row.
                City city = new City();

                // Store the database values in the City object.
                city.name = rset.getString("Name");
                city.country = rset.getString("Country");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");

                // Add the city to the list.
                cities.add(city);
            }

            // Return the completed list of cities.
            return cities;
        }
        catch (Exception e)
        {
            // Display an error if the city information cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");

            return null;
        }
    }

    // --------------------------------------------------
    // USE CASE 8
    // Get Cities in a Specified Continent
    // --------------------------------------------------

    /**
     * Gets all cities in a specified continent,
     * ordered by population from largest to smallest.
     * @param continent The continent to search for
     * @return An ArrayList containing the cities in
     *      the specified continent, or null if the
     *      data cannot be retrieved.
     */
    public ArrayList<City> getCitiesByContinent(String continent)
    {
        String sql =
                "SELECT city.Name, country.Name AS Country, " +
                        "city.District, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Continent = '" + continent + "' " +
                        "ORDER BY city.Population DESC";

        return getCities(sql);
    }


    // --------------------------------------------------
    // USE CASE 9
    // Get Cities in a Specified Region
    // --------------------------------------------------
    /**
     * Gets all cities in a region from the database
     * ordered by population from largest to smallest
     *
     * @param region The region to search for
     * @return An ArrayList containing all cities in a region,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<City> getCitiesInRegion(String region)
    {
        // SQL for Use Case 9:
        // Retrieve all cities from a region
        // Ordered from largest population to smallest
        String sql =
                "SELECT city.Name, country.Name as 'Country', city.District, city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region = '" + region + "' "
                        + "ORDER BY city.population DESC";

        return getCities(sql);
    }


    // --------------------------------------------------
    // USE CASE 10
    // Get Cities in a Specified Country
    // --------------------------------------------------
    /**
     * Gets all cities in a country from the database
     * ordered by population from largest to smallest
     *
     * @param country The country to search for
     * @return An ArrayList containing all cities in a country,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<City> getCitiesInCountry(String country)
    {
        // SQL for Use Case 10:
        // Retrieve all cities from a country
        // Ordered from largest population to smallest
        String sql =
                "SELECT city.Name, country.Name as 'Country', city.District, city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name =  '" + country + "' "
                        + "ORDER BY city.population DESC";

        return getCities(sql);
    }


    // --------------------------------------------------
    // USE CASE 11
    // Get Cities in a Specified District
    // --------------------------------------------------
    /**
     * Gets all cities in a district from the database
     * ordered by population from largest to smallest
     *
     * @param district The district to search for
     * @return An ArrayList containing all cities in a district,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<City> getCitiesInDistrict(String district)
    {
        // SQL for Use Case 11:
        // Retrieve all cities from a district
        // Ordered from largest population to smallest
        String sql =
                "SELECT city.Name, country.Name as 'Country', city.District, city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "WHERE city.district = '" + district + "' "
                        + "ORDER BY city.population DESC";

        return getCities(sql);
    }


    // --------------------------------------------------
    // USE CASE 12
    // Get Top N Populated Cities in the World
    // --------------------------------------------------
    /**
     * Gets the top n populated cities in the world.
     *
     * @param n The number of cities to retrieve.
     * @return An ArrayList containing the top n populated cities of the world, or null if information cannot be retrieved.
     */
    public ArrayList<City> getTopNCities(int n)
    {
        // SQL for Use Case 12
        // Retrieve the top N cities in the world
        String sql =
                "SELECT city.Name, city.District, country.Name AS 'Country', city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "ORDER BY city.Population DESC "
                        + "LIMIT " + n;

        return getCities(sql);

    }


    // ---------------------------------------------------
    // USE CASE 13
    // Get Top N Populated Cities in a Specified Continent
    // ---------------------------------------------------
    /**
     * Gets the top n populated cities in a continent.
     *
     * @param continent The continent to search for.
     * @param n The number of cities to retrieve.
     * @return An ArrayList containing the top n populated cities of a specified continent, or null if information cannot be retrieved.
     */
    public ArrayList<City> getTopNCitiesByContinent(String continent, int n)
    {
        // SQL for Use Case 13
        // Retrieve the top N cities in a specified continent.
        String sql =
                "SELECT city.Name, city.District, country.Name AS 'Country', city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.continent = '" + continent + "' "
                        + "ORDER BY city.Population DESC "
                        + "LIMIT " + n;

        return getCities(sql);
    }


    // --------------------------------------------------
    // USE CASE 14
    // Get Top N Populated Cities in a Specified Region
    // --------------------------------------------------
    /**
     * Gets the top n populated cities in a region.
     *
     * @param region The region to search for.
     * @param n The number of cities to retrieve.
     * @return An ArrayList containing the top n populated cities of a specified region, or null if information cannot be retrieved.
     */
    public ArrayList<City> getTopNCitiesByRegion(String region, int n)
    {
        // SQL for Use Case 14
        // Retrieve the top N cities in a specified region.
        String sql =
                "SELECT city.Name, city.District, country.Name AS 'Country', city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.region = '"  + region + "' "
                        + "ORDER BY city.Population DESC "
                        + "LIMIT " + n;

        return getCities(sql);
    }



    // --------------------------------------------------
    // USE CASE 15
    // Get Top N Populated Cities in a Specified Country
    // --------------------------------------------------
    /**
     * Gets the top n populated cities in a country.
     *
     * @param country The country to search for.
     * @param n The number of cities to retrieve.
     * @return An ArrayList containing the top n populated cities of a specified country, or null if information cannot be retrieved.
     */
    public ArrayList<City> getTopNCitiesByCountry(String country, int n)
    {
        // SQL for Use Case 15
        // Retrieve the top N cities in a specified country.
        String sql =
                "SELECT city.Name, country.Name as 'Country', city.District, city.Population "
                        + "FROM city "
                        + "JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name = '" + country + "' "
                        + "ORDER BY city.Population DESC "
                        + "LIMIT " + n;

        return getCities(sql);
    }

    // --------------------------------------------------
    // USE CASE 16
    // Top N Cities in a Specified District
    // --------------------------------------------------

    /**
     * Gets the top N populated cities in a specified district,
     * ordered by population from largest to smallest.
     *
     * @param district The district to search for.
     * @param n The number of cities to retrieve.
     * @return An ArrayList containing the top N populated cities
     *         in the specified district, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<City> getTopNCitiesByDistrict(String district, int n)
    {
        // SQL for Use Case 16:
        // Retrieve the top N populated cities in a specified district,
        // ordered from largest population to smallest.
        String sql =
                "SELECT city.Name, country.Name AS Country, " +
                        "city.District, city.Population " +
                        "FROM city " +
                        "JOIN country ON city.CountryCode = country.Code " +
                        "WHERE city.District = '" + district + "' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n;

        return getCities(sql);
    }

    /**
     * Displays a report of cities including their name, country, district and population.
     *
     * @param cities List of cities to be displayed.
     */
    public void displayCities(ArrayList<City> cities)
    {
        // Check if the list is null.
        if (cities == null)
        {
            System.out.println("No city information available.");
            return;
        }

        // Check if the list contains no cities.
        if (cities.isEmpty())
        {
            System.out.println("No cities found.");
            return;
        }

        // Display the column headings for the city report.
        System.out.printf(
                "%-35s %-35s %-20s %-15s%n",
                "Name",
                "Country",
                "District",
                "Population"
        );

        // Display each city in the report.
        for (City city : cities)
        {
            System.out.printf(
                    "%-35s %-35s %-20s %-15d%n",
                    city.name,
                    city.country,
                    city.district,
                    city.population
            );
        }
    }
}
