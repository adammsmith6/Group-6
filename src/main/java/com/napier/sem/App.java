package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;


public class App {

    /**
     * Main method, all use case reports are generated within
     * @param args possible location for the connect method
     */
    public static void main(String[] args)
    {
        // Create the application.
        App a = new App();

        // Connect to the World database.
        if(args.length < 1){
            a.connect("localhost:33060", 0);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }


        // ---------------
        // Use Case 1
        // ---------------
        System.out.println(
                "\n========== USE CASE 1: Countries in the World ==========\n"
        );
        // Retrieve all countries ordered from largest
        // population to smallest.
        ArrayList<Country> countries = a.getCountries("SELECT country.Code, country.Name, country.Continent, " +
                "country.Region, country.Population, city.Name AS Capital " +
                "FROM country " +
                "LEFT JOIN city ON country.Capital = city.ID " +
                "ORDER BY country.Population DESC");

        // Display the country population report.
        a.displayCountries(countries);


        // --------------
        // Use Case 2
        // --------------
        System.out.println(
                "\n========== USE CASE 2: Countries in EUROPE ==========\n"
        );
        // Use Case 2
        // Retrieve all countries in Europe ordered by population.
        ArrayList<Country> countriesByContinent =
                a.getCountriesByContinent("Europe");

        // Display the countries in Europe.
        a.displayCountries(countriesByContinent);


        // ---------------
        // Use Case 3
        // ---------------
        System.out.println(
                "\n========== USE CASE 3: WESTERN EUROPE ==========\n"
        );

        // Retrieve all countries in Western Europe,
        // ordered from largest population to smallest.
        ArrayList<Country> countriesByRegion =
                a.getCountriesByRegion("Western Europe");

        // Display the countries in Western Europe.
        a.displayCountries(countriesByRegion);


        // -------------------
        // Use Case 4
        // -------------------

        System.out.println(
                "\n========== USE CASE 4: TOP 5 COUNTRIES ==========\n"
        );

        // Retrieve the top 5 populated countries
        // in the world.
        ArrayList<Country> topCountries =
                a.getTopNCountries(5);

        // Display the top 5 countries.
        a.displayCountries(topCountries);


        // -------------------
        // Use Case 5
        // -------------------

        System.out.println(
                "\n========== USE CASE 5: TOP 5 COUNTRIES IN EUROPE ==========\n"
        );

        // Retrieve the top 5 populated countries in Europe.
        ArrayList<Country> topCountriesByContinent =
                a.getTopNCountriesByContinent("Europe", 5);

        // Display the top 5 countries in Europe.
        a.displayCountries(topCountriesByContinent);


        // -------------------------
        // Use Case 6
        // -------------------------

        System.out.println(
                "\n========== USE CASE 6: TOP 5 COUNTRIES IN WESTERN EUROPE ==========\n"
        );

        // Retrieve the top 5 populated countries
        // in Western Europe.
        ArrayList<Country> topCountriesByRegion =
                a.getTopNCountriesByRegion("Western Europe", 5);

        // Display the top 5 countries in Western Europe.
        a.displayCountries(topCountriesByRegion);


        // -------------------------
        // Use Case 7
        // -------------------------

        System.out.println(
                "\n========== USE CASE 7: ALL CITIES IN THE WORLD ==========\n"
        );

        // Retrieve all cities in the world,
        // ordered from largest population to smallest.
        ArrayList<City> allCities = a.getCities(
                            "SELECT city.Name, country.Name as 'Country', city.District, city.Population " +
                                "FROM city " +
                                "LEFT JOIN country ON city.CountryCode = country.Code " +
                                "ORDER BY city.Population DESC");

        // Display all cities in the world.
        a.displayCities(allCities);


        // -------------------------
        // Use Case 8
        // -------------------------

        System.out.println(
                "\n========== USE CASE 8: ALL CITIES IN ASIA ==========\n"
        );

        // Retrieve all cities in Asia,
        // ordered from largest population to smallest.
        ArrayList<City> citiesByContinent =
                a.getCitiesByContinent("Asia");

        // Display all cities in Asia.
        a.displayCities(citiesByContinent);


        // -------------------------
        // Use Case 9
        // -------------------------

        // all the cities in a region organised by largest population to smallest.

        System.out.println(
                "\n========== USE CASE 9: ALL CITIES IN WESTERN EUROPE ==========\n"
        );

        // Retrieve all cities in the specified region ordered from largest population to smallest.
        ArrayList<City> citiesInRegion = a.getCitiesInRegion("Western Europe");

        // Display the cities in a region report ordered by population.
        a.displayCities(citiesInRegion);


        // -------------------------
        // Use Case 10
        // -------------------------

        // all the cities in a country organised by largest population to smallest.

        System.out.println(
                "\n========== USE CASE 10: ALL CITIES IN THE UNITED KINGDOM ==========\n"
        );

        // Retrieve all cities in the specified country ordered from largest population to smallest.
        ArrayList<City> citiesInCountry = a.getCitiesInCountry("United Kingdom");

        // Display the cities in a country report ordered by population.
        a.displayCities(citiesInCountry);


        // -------------------------
        // Use Case 11
        // -------------------------

        // all the cities in a district organised by largest population to smallest.

        System.out.println(
                "\n========== USE CASE 11: ALL CITIES IN SCOTLAND ==========\n"
        );

        // Retrieve all cities in the specified district ordered from largest population to smallest.
        ArrayList<City> citiesInDistrict = a.getCitiesInDistrict("Scotland");

        // Display the cities in a district report ordered by population.
        a.displayCities(citiesInDistrict);


        // -------------------------
        // Use Case 12
        // -------------------------

        // the top n populated cities in the world where n is defined by the user

        System.out.println(
                "\n========== USE CASE 12: TOP 10 POPULATED CITIES IN THE WORLD ==========\n"
        );

        // Retrieve the top 10 populated cities in the world
        ArrayList<City> topNCities =
                a.getTopNCities(10);

        // Display the top 10 populated cities in the world.
        a.displayCities(topNCities);


        // -------------------------
        // Use Case 13
        // -------------------------

        // the top n populated cities in a specified continent where n is defined by the user.

        System.out.println(
                "\n========== USE CASE 13: TOP 15 POPULATED CITIES IN EUROPE ==========\n"
        );

        // Retrieve the top 15 populated cities in Europe.
        ArrayList<City> topNCitiesByContinent =
                a.getTopNCitiesByContinent("Europe", 15);

        // Display the top 10 populated cities in the specified continent.
        a.displayCities(topNCitiesByContinent);


        // -------------------------
        // Use Case 14
        // -------------------------

        // the top n populated cities in a specified region where n is defined by the user.

        System.out.println(
                "\n========== USE CASE 14: TOP 8 POPULATED CITIES IN EASTERN AFRICA ==========\n"
        );

        // Retrieve the top 8 populated cities in Eastern Africa.
        ArrayList<City> topNCitiesByRegion =
                a.getTopNCitiesByRegion("Eastern Africa", 8);

        // Display the top 8 populated cities in the specified region.
        a.displayCities(topNCitiesByRegion);


        // -------------------------
        // Use Case 15
        // -------------------------

        // the top n populated cities in a specified country where n is defined by the user.

        System.out.println(
                "\n========== USE CASE 15: TOP 6 POPULATED CITIES IN ITALY ==========\n"
        );

        // Retrieve the top 6 populated cities in Italy.
        ArrayList<City> topNCitiesByCountry =
                a.getTopNCitiesByCountry("Italy", 6);

        // Display the top 6 populated cities in the specified country.
        a.displayCities(topNCitiesByCountry);


        // -------------------------
        // Use Case 16
        // -------------------------

        // Get the top 5 populated cities in California.
        System.out.println(
                "\n========== USE CASE 16: Top 5 populated city in California ==========\n"
        );
        // Use Case 16:
        // Get the top 5 populated cities in California.
        ArrayList<City> topNCitiesByDistrict =
                a.getTopNCitiesByDistrict("California", 5);

        // Display the top 5 cities.
        a.displayCities(topNCitiesByDistrict);


        // -------------------------
        // Use Case 17
        // -------------------------

        System.out.println(
                "\n========== USE CASE 17: CAPITAL CITY REPORT IN WORLD ==========\n"
        );

        // SQL for Use Case 17:
        // Retrieve all capital cities,
        // ordered from largest population to smallest.
        String sql =
                "SELECT city.Name, country.Name as 'Country', city.Population " +
                        "FROM city " +
                        "LEFT JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Capital = city.Id " +
                        "ORDER BY city.Population DESC";


        // Retrieve all capital cities ordered from largest
        // population to smallest.
        ArrayList<CapitalCity> capitalCities = a.getCapitalCities(sql);

        // Display the capital city population report.
        a.displayCapitalCities(capitalCities);


        // -------------------------
        // Use Case 18
        // -------------------------

        System.out.println(
                "\n========== USE CASE 18: CAPITAL CITIES IN SOUTH AMERICA ==========\n"
        );

        // Retrieve all capital cities in South America,
        // ordered from largest population to smallest.
        ArrayList<CapitalCity> capitalCitiesByContinent =
                a.getCapitalCitiesByContinent("South America");

        // Display the capital cities in South America.
        a.displayCapitalCities(capitalCitiesByContinent);



        // -------------------------
        // Use Case 19
        // -------------------------

        System.out.println(
                "\n========== USE CASE 19: CAPITAL CITIES IN CARIBBEAN ==========\n"
        );

        // Retrieve all capital cities in the Caribbean region,
        // ordered from largest population to smallest.
        ArrayList<CapitalCity> capitalCitiesByRegion =
                a.getCapitalCitiesByRegion("Caribbean");

        // Display the capital cities in the Caribbean region.
        a.displayCapitalCities(capitalCitiesByRegion);


        // -------------------------
        // Use Case 20
        // -------------------------

        System.out.println(
                "\n========== USE CASE 20: TOP 5 CAPITAL CITIES IN THE WORLD ==========\n"
        );

        // Retrieve the top 5 most populated capital cities
        // in the world, ordered from largest to smallest.
        ArrayList<CapitalCity> topCapitalCities =
                a.getTopNCapitalCities(5);

        // Display the top 5 capital cities in the world.
        a.displayCapitalCities(topCapitalCities);


        // -------------------------
        // Use Case 21 - Top 6 capital cities in Asia
        // -------------------------

        System.out.println("\n========== USE CASE 21: TOP 6 CAPITAL CITIES IN ASIA ==========\n");

        ArrayList<CapitalCity> topCapitalsByContinent =
                a.getTopNCapitalCitiesByContinent("Asia", 6);

        a.displayCapitalCities(topCapitalsByContinent);

        // -------------------------
        // Use Case 22 - Top 6 capital cities in Eastern Asia
        // -------------------------

        System.out.println("\n========== USE CASE 22: TOP 6 CAPITAL CITIES IN EASTERN ASIA ==========\n");

        ArrayList<CapitalCity> topCapitalsByRegion =
                a.getTopNCapitalCitiesByRegion("Eastern Asia", 6);

        a.displayCapitalCities(topCapitalsByRegion);


        // -------------------------
        // Use Case 23
        // -------------------------
        /**
         * Use Case 23:
         * Displays the total population, city population,
         * and non-city population for each continent.
         */
        System.out.println(
                "\n========== USE CASE 23: POPULATION BY CONTINENT ==========\n"
        );

        // Calculate city population for each country first.
        // Then combine countries by continent.
        String popForContinent =
                "SELECT country.Continent AS Name, " +
                        "SUM(country.Population) AS TotalPopulation, " +
                        "SUM(COALESCE(city_pop.CityPopulation, 0)) AS CityPopulation " +
                        "FROM country " +
                        "LEFT JOIN ( " +
                        "    SELECT CountryCode, SUM(Population) AS CityPopulation " +
                        "    FROM city " +
                        "    GROUP BY CountryCode " +
                        ") city_pop ON country.Code = city_pop.CountryCode " +
                        "GROUP BY country.Continent " +
                        "ORDER BY country.Continent";
        a.displayPopulation(popForContinent);


        // -------------------------
        // Use Case 24
        // -------------------------
        System.out.println(
                "\n========== USE CASE 24: POPULATION BY REGION ==========\n"
        );
/**
 * Use Case 24:
 * Displays the total population, city population,
 * and non-city population for each region.
 */
        // Calculate city population for each country first.
        // Then combine countries by region.
        String popForRegion =
                "SELECT country.Region AS Name, " +
                        "SUM(country.Population) AS TotalPopulation, " +
                        "SUM(COALESCE(city_pop.CityPopulation, 0)) AS CityPopulation " +
                        "FROM country " +
                        "LEFT JOIN ( " +
                        "    SELECT CountryCode, SUM(Population) AS CityPopulation " +
                        "    FROM city " +
                        "    GROUP BY CountryCode " +
                        ") city_pop ON country.Code = city_pop.CountryCode " +
                        "GROUP BY country.Region " +
                        "ORDER BY country.Region";
        a.displayPopulation(popForRegion);


        // -------------------------
        // Use Case 25
        // -------------------------
        System.out.println(
                "\n========== USE CASE 25: POPULATION BY COUNTRY ==========\n"
        );

        // Get the total population and the population
        // living in listed cities for each country.
        String popForCountry =
                "SELECT country.Name AS Name, " +
                        "country.Population AS TotalPopulation, " +
                        "COALESCE(city_pop.CityPopulation, 0) AS CityPopulation " +
                        "FROM country " +
                        "LEFT JOIN ( " +
                        "    SELECT CountryCode, SUM(Population) AS CityPopulation " +
                        "    FROM city " +
                        "    GROUP BY CountryCode " +
                        ") city_pop ON country.Code = city_pop.CountryCode " +
                        "ORDER BY country.Name";

        a.displayPopulation(popForCountry);


        // Disconnect from the database.
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay)
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
                Thread.sleep(delay);

                // Connect to World database
                con = DriverManager.getConnection(
                        "jdbc:mysql://" + location +
                                "/world?allowPublicKeyRetrieval=true&useSSL=false",
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
    public ArrayList<Country> getCountries(String sql)
    {
        try
        {   // Create a statement to execute the SQL query.
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
     * Gets all countries in a specified continent from the database,
     * ordered by population from largest to smallest.
     *
     * @param continent The continent to search for.
     * @return An ArrayList containing all countries in the specified continent,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountriesByContinent(String continent)
    {
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


    /**
     * Gets all countries in a specified region from the database,
     * ordered by population from largest to smallest.
     *
     * @param region The region to search for.
     * @return An ArrayList containing all countries in the specified region,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountriesByRegion(String region)
    {
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


    /**
     * Gets the top N populated countries in the world,
     * ordered by population from largest to smallest.
     *
     * @param n The number of countries to retrieve.
     * @return An ArrayList containing the top N populated countries,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getTopNCountries(int n)
    {
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


    /**
     * Gets the top N populated countries in a specified continent,
     * ordered by population from largest to smallest.
     *
     * @param continent The continent to search for.
     * @param n The number of countries to retrieve.
     * @return An ArrayList containing the top N populated countries
     *         in the specified continent, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<Country> getTopNCountriesByContinent(String continent, int n)
    {
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


    /**
     * Gets all cities in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all cities,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<City> getCities(String sql)
    {
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
                    "SELECT city.Name, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Name = '" + country + "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            return getCities(sql);
    }


    /**
     * Gets all capital cities in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all capital cities,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<CapitalCity> getCapitalCities(String sql)
    {
        try
        {
            // Create a statement to execute the SQL query.
            Statement stmt = con.createStatement();

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery(sql);

            // Create a list to store all capital cities retrieved from the database.
            ArrayList<CapitalCity> capitalCities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
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
        }
        catch (Exception e)
        {
            // Display an error if the city information cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details.");

            return null;
        }
    }


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


    /**
     * Use Case 21:
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

    /**
     * Use Case 22:
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



    /*
     -------------------------------
     All Display Functions are Below
     -------------------------------
     */

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


    /**
     * Displays the total population, city population,
     * and non-city population.
     */
    public void displayPopulation(String sql)
    {
        try
        {

            try (Statement stmt = con.createStatement();
                 ResultSet rset = stmt.executeQuery(sql))
            {
                System.out.printf(
                        "%-25s %-18s %-18s %-18s %-12s %-12s%n",
                        "Continent", "Total Population", "City Population",
                        "Non-City Population", "City %", "Non-City %"
                );

                while (rset.next())
                {
                    String name = rset.getString("Name");
                    long total = rset.getLong("TotalPopulation");
                    long city = rset.getLong("CityPopulation");
                    long nonCity = total - city;

                    double cityPercent = 0;
                    double nonCityPercent = 0;

                    if (total > 0)
                    {
                        cityPercent = city * 100.0 / total;
                        nonCityPercent = nonCity * 100.0 / total;
                    }

                    System.out.printf(
                            "%-25s %-18d %-18d %-18d %-12.2f %-12.2f%n",
                            name, total, city, nonCity,
                            cityPercent, nonCityPercent
                    );
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to display population by continent.");
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