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

        // Use Case 1
        // Retrieve all countries ordered from largest
        // population to smallest.
        // ArrayList<Country> countries = a.getCountries();

        // Display the country population report.
        // a.displayCountries(countries);

        // Use Case 2
        // Retrieve all countries in Europe ordered by population.
        ArrayList<Country> countriesByContinent =
                a.getCountriesByContinent("Europe");

        // Display the countries in Europe.
        a.displayCountriesByContinent(countriesByContinent);


        // Use Case 3
        System.out.println(
                "\n========== USE CASE 3: WESTERN EUROPE ==========\n"
        );

        // Retrieve all countries in Western Europe,
        // ordered from largest population to smallest.
        ArrayList<Country> countriesByRegion =
                a.getCountriesByRegion("Western Europe");

        // Display the countries in Western Europe.
        a.displayCountriesByRegion(countriesByRegion);

        // -------------------------
        // Use Case 4
        // -------------------------

        System.out.println(
                "\n========== USE CASE 4: TOP 5 COUNTRIES ==========\n"
        );

        // Retrieve the top 5 populated countries
        // in the world.
        ArrayList<Country> topCountries =
                a.getTopNCountries(5);

        // Display the top 5 countries.
        a.displayTopNCountries(topCountries);

        // -------------------------
        // Use Case 5
        // -------------------------

        System.out.println(
                "\n========== USE CASE 5: TOP 5 COUNTRIES IN EUROPE ==========\n"
        );

        // Retrieve the top 5 populated countries in Europe.
        ArrayList<Country> topCountriesByContinent =
                a.getTopNCountriesByContinent("Europe", 5);

        // Display the top 5 countries in Europe.
        a.displayTopNCountriesByContinent(topCountriesByContinent);

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
        a.displayTopNCountriesByRegion(topCountriesByRegion);


        System.out.println(
                "\n========== USE CASE 16: Top 5 populated city in California ==========\n"
        );

        // Use Case 16:
        // Get the top 5 populated cities in California.
        ArrayList<City> cities =
                a.getTopNCitiesByDistrict("California", 5);

        // Display the top 5 cities.
        a.displayTopNCitiesByDistrict(cities);

        // Retrieve all cities ordered from largest
        // population to smallest.
        // ArrayList<City> cities = a.getCities();

        // Display the city population report.
        // a.displayCities(cities);


        // -------------------------
        // Use Case 17
        // -------------------------

        System.out.println(
                "\n========== USE CASE 17: CAPITAL CITY REPORT IN WORLD ==========\n"
        );

        // Retrieve all capital cities ordered from largest
        // population to smallest.
        ArrayList<CapitalCity> capitalCities = a.getCapitalCities();

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
        a.displayCapitalCitiesByContinent(capitalCitiesByContinent);



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
        a.displayCapitalCitiesByRegion(capitalCitiesByRegion);


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
        a.displayTopNCapitalCities(topCapitalCities);





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
     * Gets all countries in a specified continent from the database,
     * ordered by population from largest to smallest.
     *
     * @param continent The continent to search for.
     * @return An ArrayList containing all countries in the specified continent,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountriesByContinent(String continent)
    {
        try
        {
            // SQL for Use Case 2:
            // Retrieve all countries in a specified continent,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT country.Code, country.Name, country.Continent, " +
                            "country.Region, country.Population, city.Name AS Capital " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Continent = ? " +
                            "ORDER BY country.Population DESC";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the ? in the SQL query with the continent
            // passed into the method.
            stmt.setString(1, continent);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the countries.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a Country object for the current row.
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

            // Return the completed list.
            return countries;
        }
        catch (Exception e)
        {
            // Display an error if the country information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by continent.");

            return null;
        }
    }


    /**
     * Displays a report of countries in a specified continent.
     *
     * @param countries List of countries to be displayed.
     */
    public void displayCountriesByContinent(ArrayList<Country> countries)
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
            System.out.println("No countries found in this continent.");
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

        // Display each country in the continent.
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
     * Gets all countries in a specified region from the database,
     * ordered by population from largest to smallest.
     *
     * @param region The region to search for.
     * @return An ArrayList containing all countries in the specified region,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getCountriesByRegion(String region)
    {
        try
        {
            // SQL for Use Case 3:
            // Retrieve all countries in a specified region,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT country.Code, country.Name, country.Continent, " +
                            "country.Region, country.Population, city.Name AS Capital " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Region = ? " +
                            "ORDER BY country.Population DESC";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the ? in the query with the region
            // passed into the method.
            stmt.setString(1, region);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the countries.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a Country object for the current row.
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

            // Return the completed list.
            return countries;
        }
        catch (Exception e)
        {
            // Display an error if the country information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by region.");

            return null;
        }
    }

    /**
     * Displays a report of countries in a specified region.
     *
     * @param countries List of countries to be displayed.
     */
    public void displayCountriesByRegion(ArrayList<Country> countries)
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
            System.out.println("No countries found in this region.");
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

        // Display each country in the region.
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
     * Gets the top N populated countries in the world,
     * ordered by population from largest to smallest.
     *
     * @param n The number of countries to retrieve.
     * @return An ArrayList containing the top N populated countries,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<Country> getTopNCountries(int n)
    {
        try
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
                            "LIMIT ?";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the ? with the number of countries
            // requested by the user.
            stmt.setInt(1, n);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the countries.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a Country object for the current row.
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

            // Return the completed list.
            return countries;
        }
        catch (Exception e)
        {
            // Display an error if the country information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println("Failed to get top N countries.");

            return null;
        }
    }

    /**
     * Displays a report of the top N populated countries
     * in the world.
     *
     * @param countries List of countries to be displayed.
     */
    public void displayTopNCountries(ArrayList<Country> countries)
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
        try
        {
            // SQL for Use Case 5:
            // Retrieve the top N populated countries in a specified continent,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT country.Code, country.Name, country.Continent, " +
                            "country.Region, country.Population, city.Name AS Capital " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Continent = ? " +
                            "ORDER BY country.Population DESC " +
                            "LIMIT ?";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the first ? with the continent.
            stmt.setString(1, continent);

            // Replace the second ? with the number of countries required.
            stmt.setInt(2, n);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the countries.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a Country object for the current row.
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

            // Return the completed list.
            return countries;
        }
        catch (Exception e)
        {
            // Display an error if the country information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println(
                    "Failed to get top N countries by continent."
            );

            return null;
        }
    }

    /**
     * Displays a report of the top N populated countries
     * in a specified continent.
     *
     * @param countries List of countries to be displayed.
     */
    public void displayTopNCountriesByContinent(ArrayList<Country> countries)
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
            System.out.println("No countries found in this continent.");
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
    {
        try
        {
            // SQL for Use Case 6:
            // Retrieve the top N populated countries in a specified region,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT country.Code, country.Name, country.Continent, " +
                            "country.Region, country.Population, city.Name AS Capital " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Region = ? " +
                            "ORDER BY country.Population DESC " +
                            "LIMIT ?";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the first ? with the region.
            stmt.setString(1, region);

            // Replace the second ? with the number of countries required.
            stmt.setInt(2, n);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the countries.
            ArrayList<Country> countries = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a Country object for the current row.
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

            // Return the completed list.
            return countries;
        }
        catch (Exception e)
        {
            // Display an error if the country information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println(
                    "Failed to get top N countries by region."
            );

            return null;
        }
    }

    /**
     * Displays a report of the top N populated countries
     * in a specified region.
     *
     * @param countries List of countries to be displayed.
     */
    public void displayTopNCountriesByRegion(ArrayList<Country> countries)
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
            System.out.println("No countries found in this region.");
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
     * Gets all cities in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all cities,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<City> getCities()
    {
        try
        {
            // SQL for Use Case 7:
            // Retrieve all cities,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT city.Name, country.Name as 'Country', city.District, city.Population " +
                            "FROM city " +
                            "LEFT JOIN country ON city.CountryCode = country.Code " +
                            "ORDER BY city.Population DESC";

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
     * Gets all capital cities in the world from the database
     * ordered by population from largest to smallest.
     *
     * @return An ArrayList containing all capital cities,
     *         or null if the data cannot be retrieved.
     */
    public ArrayList<CapitalCity> getCapitalCities()
    {
        try
        {
            // SQL for Use Case 17:
            // Retrieve all capital cities,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT city.Name, country.Name as 'Country', city.Population " +
                            "FROM city " +
                            "LEFT JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Capital = city.Id " +
                            "ORDER BY city.Population DESC";

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
        try
        {
            // SQL for Use Case 16:
            // Retrieve the top N populated cities in a specified district,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT city.Name, country.Name AS Country, " +
                            "city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE city.District = ? " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT ?";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the first ? with the district.
            stmt.setString(1, district);

            // Replace the second ? with the number of cities required.
            stmt.setInt(2, n);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the cities.
            ArrayList<City> cities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a City object for the current row.
                City city = new City();

                // Store the database values in the City object.
                city.name = rset.getString("Name");
                city.country = rset.getString("Country");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");

                // Add the city to the list.
                cities.add(city);
            }

            // Return the completed list.
            return cities;
        }
        catch (Exception e)
        {
            // Display an error if the city information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println(
                    "Failed to get top N cities by district."
            );

            return null;
        }
    }

    /**
     * Displays a report of the top N populated cities
     * in a specified district.
     *
     * @param cities List of cities to be displayed.
     */
    public void displayTopNCitiesByDistrict(ArrayList<City> cities)
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
            System.out.println("No cities found in this district.");
            return;
        }

        // Display the column headings for the city report.
        System.out.printf(
                "%-35s %-35s %-30s %-15s%n",
                "Name",
                "Country",
                "District",
                "Population"
        );

        // Display each city in the report.
        for (City city : cities)
        {
            System.out.printf(
                    "%-35s %-35s %-30s %-15d%n",
                    city.name,
                    city.country,
                    city.district,
                    city.population
            );
        }
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
        try
        {
            // SQL for Use Case 18:
            // Retrieve all capital cities in a specified continent,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT city.Name, country.Name AS Country, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Capital = city.ID " +
                            "AND country.Continent = ? " +
                            "ORDER BY city.Population DESC";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the ? with the continent.
            stmt.setString(1, continent);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the capital cities.
            ArrayList<CapitalCity> capitalCities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a CapitalCity object for the current row.
                CapitalCity capitalCity = new CapitalCity();

                // Store the database values in the CapitalCity object.
                capitalCity.name = rset.getString("Name");
                capitalCity.country = rset.getString("Country");
                capitalCity.population = rset.getInt("Population");

                // Add the capital city to the list.
                capitalCities.add(capitalCity);
            }

            // Return the completed list.
            return capitalCities;
        }
        catch (Exception e)
        {
            // Display an error if the capital city information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println(
                    "Failed to get capital cities by continent."
            );

            return null;
        }
    }

    /**
     * Displays a report of capital cities in a specified
     * continent, including name, country and population.
     *
     * @param capitalCities List of capital cities to be displayed.
     */
    public void displayCapitalCitiesByContinent(ArrayList<CapitalCity> capitalCities)
    {
        // Check if the list is null.
        if (capitalCities == null)
        {
            System.out.println("No capital city information available.");
            return;
        }

        // Check if the list contains no capital cities.
        if (capitalCities.isEmpty())
        {
            System.out.println("No capital cities found in this continent.");
            return;
        }

        // Display the column headings for the capital city report.
        System.out.printf(
                "%-35s %-35s %-15s%n",
                "Name",
                "Country",
                "Population"
        );

        // Display each capital city in the continent.
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
     * Gets all capital cities in a specified region,
     * ordered by population from largest to smallest.
     *
     * @param region The region to search for.
     * @return An ArrayList containing capital cities in the
     *         specified region, or null if the data
     *         cannot be retrieved.
     */
    public ArrayList<CapitalCity> getCapitalCitiesByRegion(String region)
    {
        try
        {
            // SQL for Use Case 19:
            // Retrieve all capital cities in a specified region,
            // ordered from largest population to smallest.
            String sql =
                    "SELECT city.Name, country.Name AS Country, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Capital = city.ID " +
                            "AND country.Region = ? " +
                            "ORDER BY city.Population DESC";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the ? with the region.
            stmt.setString(1, region);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the capital cities.
            ArrayList<CapitalCity> capitalCities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a CapitalCity object for the current row.
                CapitalCity capitalCity = new CapitalCity();

                // Store the database values in the CapitalCity object.
                capitalCity.name = rset.getString("Name");
                capitalCity.country = rset.getString("Country");
                capitalCity.population = rset.getInt("Population");

                // Add the capital city to the list.
                capitalCities.add(capitalCity);
            }

            // Return the completed list.
            return capitalCities;
        }
        catch (Exception e)
        {
            // Display an error if the capital city information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println(
                    "Failed to get capital cities by region."
            );

            return null;
        }
    }


    /**
     * Displays a report of capital cities in a specified
     * region, including name, country and population.
     *
     * @param capitalCities List of capital cities to be displayed.
     */
    public void displayCapitalCitiesByRegion(ArrayList<CapitalCity> capitalCities)
    {
        // Check if the list is null.
        if (capitalCities == null)
        {
            System.out.println("No capital city information available.");
            return;
        }

        // Check if the list contains no capital cities.
        if (capitalCities.isEmpty())
        {
            System.out.println("No capital cities found in this region.");
            return;
        }

        // Display the column headings for the capital city report.
        System.out.printf(
                "%-35s %-35s %-15s%n",
                "Name",
                "Country",
                "Population"
        );

        // Display each capital city in the region.
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

        try
        {
            // SQL for Use Case 20:
            // Retrieve the top N most populated capital cities
            // in the world, ordered from largest to smallest.
            String sql =
                    "SELECT city.Name, country.Name AS Country, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Capital = city.ID " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT ?";

            // Create a prepared statement for the SQL query.
            PreparedStatement stmt = con.prepareStatement(sql);

            // Replace the ? with the number of capital cities required.
            stmt.setInt(1, n);

            // Execute the query and store the returned rows.
            ResultSet rset = stmt.executeQuery();

            // Create a list to store the capital cities.
            ArrayList<CapitalCity> capitalCities = new ArrayList<>();

            // Process each row returned by the database.
            while (rset.next())
            {
                // Create a CapitalCity object for the current row.
                CapitalCity capitalCity = new CapitalCity();

                // Store the database values in the CapitalCity object.
                capitalCity.name = rset.getString("Name");
                capitalCity.country = rset.getString("Country");
                capitalCity.population = rset.getInt("Population");

                // Add the capital city to the list.
                capitalCities.add(capitalCity);
            }

            // Return the completed list.
            return capitalCities;
        }
        catch (Exception e)
        {
            // Display an error if the capital city information
            // cannot be retrieved.
            System.out.println(e.getMessage());
            System.out.println(
                    "Failed to get top N capital cities."
            );

            return null;
        }
    }

    /**
     * Displays a report of the top N populated capital cities
     * in the world, including name, country and population.
     *
     * @param capitalCities List of capital cities to be displayed.
     */
    public void displayTopNCapitalCities(ArrayList<CapitalCity> capitalCities)
    {
        // Check if the list is null.
        if (capitalCities == null)
        {
            System.out.println("No capital city information available.");
            return;
        }

        // Check if the list contains no capital cities.
        if (capitalCities.isEmpty())
        {
            System.out.println("No capital cities found.");
            return;
        }

        // Display the column headings for the capital city report.
        System.out.printf(
                "%-35s %-35s %-15s%n",
                "Name",
                "Country",
                "Population"
        );

        // Display each capital city in the report.
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
