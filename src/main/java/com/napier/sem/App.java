package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

        Country countryReports = new Country(a.con);
        City cityReports = new City(a.con);
        CapitalCity capitalCityReports = new CapitalCity(a.con);
        Population populationReports = new Population(a.con);
        Summary populationSummary = new Summary(a.con);


        // ---------------
        // Use Case 1
        // ---------------
        System.out.println(
                "\n========== USE CASE 1: Countries in the World ==========\n"
        );
        // Retrieve all countries ordered from largest
        // population to smallest.
        ArrayList<Country> countries = countryReports.getCountries();

        // Display the country population report.
        countryReports.displayCountries(countries);


        // --------------
        // Use Case 2
        // --------------
        System.out.println(
                "\n========== USE CASE 2: Countries in EUROPE ==========\n"
        );
        // Use Case 2
        // Retrieve all countries in Europe ordered by population.
        ArrayList<Country> countriesByContinent =
                countryReports.getCountriesByContinent("Europe");

        // Display the countries in Europe.
        countryReports.displayCountries(countriesByContinent);

        countryReports.displayCountries(countriesByContinent);

        // --------------------------------------------------
        // USE CASE 3: Countries in Western Europe.
        // --------------------------------------------------
        System.out.println(
                "\n========== USE CASE 3: WESTERN EUROPE ==========\n"
        );

        ArrayList<Country> countriesByRegion =
                countryReports.getCountriesByRegion("Western Europe");

        // Display the countries in Western Europe.
        countryReports.displayCountries(countriesByRegion);


        // -------------------
        // Use Case 4
        // -------------------

        // --------------------------------------------------
        // USE CASE 4: Top 5 countries in the world.
        // --------------------------------------------------
        System.out.println(
                "\n========== USE CASE 4: TOP 5 COUNTRIES ==========\n"
        );

        ArrayList<Country> topCountries =
                countryReports.getTopNCountries(5);

        // Display the top 5 countries.
        countryReports.displayCountries(topCountries);


        // -------------------
        // Use Case 5
        // -------------------

        // --------------------------------------------------
        // USE CASE 5: Top 5 countries in Europe.
        // --------------------------------------------------
        System.out.println(
                "\n========== USE CASE 5: TOP 5 COUNTRIES IN EUROPE ==========\n"
        );

        ArrayList<Country> topCountriesByContinent =
                countryReports.getTopNCountriesByContinent("Europe", 5);

        // Display the top 5 countries in Europe.
        countryReports.displayCountries(topCountriesByContinent);


        countryReports.displayCountries(
                topCountriesByContinent);

        // --------------------------------------------------
        // USE CASE 6: Top 5 countries in Western Europe.
        // --------------------------------------------------
        System.out.println(
                "\n========== USE CASE 6: TOP 5 COUNTRIES IN WESTERN EUROPE ==========\n"
        );

        ArrayList<Country> topCountriesByRegion =
                countryReports.getTopNCountriesByRegion("Western Europe", 5);

        // Display the top 5 countries in Western Europe.
        countryReports.displayCountries(topCountriesByRegion);


        // -------------------------
        // Use Case 7
        // -------------------------

        System.out.println(
                "\n========== USE CASE 7: ALL CITIES IN THE WORLD ==========\n"
        );

        // Retrieve all cities in the world,
        // ordered from largest population to smallest.
        ArrayList<City> allCities = cityReports.getCities();

        // Display all cities in the world.
        cityReports.displayCities(allCities);


        // -------------------------
        // Use Case 8
        // -------------------------

        System.out.println(
                "\n========== USE CASE 8: ALL CITIES IN ASIA ==========\n"
        );

        // Retrieve all cities in Asia,
        // ordered from largest population to smallest.
        ArrayList<City> citiesByContinent =
                cityReports.getCitiesByContinent("Asia");

        // Display all cities in Asia.
        cityReports.displayCities(citiesByContinent);


        // -------------------------
        // Use Case 9
        // -------------------------

        // all the cities in a region organised by largest population to smallest.

        System.out.println(
                "\n========== USE CASE 9: ALL CITIES IN WESTERN EUROPE ==========\n"
        );

        // Retrieve all cities in the specified region ordered from largest population to smallest.
        ArrayList<City> citiesInRegion = cityReports.getCitiesInRegion("Western Europe");

        // Display the cities in a region report ordered by population.
        cityReports.displayCities(citiesInRegion);


        // -------------------------
        // Use Case 10
        // -------------------------

        // all the cities in a country organised by largest population to smallest.

        System.out.println(
                "\n========== USE CASE 10: ALL CITIES IN THE UNITED KINGDOM ==========\n"
        );

        // Retrieve all cities in the specified country ordered from largest population to smallest.
        ArrayList<City> citiesInCountry = cityReports.getCitiesInCountry("United Kingdom");

        // Display the cities in a country report ordered by population.
        cityReports.displayCities(citiesInCountry);


        // -------------------------
        // Use Case 11
        // -------------------------

        // all the cities in a district organised by largest population to smallest.

        System.out.println(
                "\n========== USE CASE 11: ALL CITIES IN SCOTLAND ==========\n"
        );

        // Retrieve all cities in the specified district ordered from largest population to smallest.
        ArrayList<City> citiesInDistrict = cityReports.getCitiesInDistrict("Scotland");

        // Display the cities in a district report ordered by population.
        cityReports.displayCities(citiesInDistrict);


        // -------------------------
        // Use Case 12
        // -------------------------

        // the top n populated cities in the world where n is defined by the user

        System.out.println(
                "\n========== USE CASE 12: TOP 10 POPULATED CITIES IN THE WORLD ==========\n"
        );

        // Retrieve the top 10 populated cities in the world
        ArrayList<City> topNCities = cityReports.getTopNCities(10);

        // Display the top 10 populated cities in the world.
        cityReports.displayCities(topNCities);


        // -------------------------
        // Use Case 13
        // -------------------------

        // the top n populated cities in a specified continent where n is defined by the user.

        System.out.println(
                "\n========== USE CASE 13: TOP 15 POPULATED CITIES IN EUROPE ==========\n"
        );

        // Retrieve the top 15 populated cities in Europe.
        ArrayList<City> topNCitiesByContinent = cityReports.getTopNCitiesByContinent("Europe", 15);

        // Display the top 10 populated cities in the specified continent.
        cityReports.displayCities(topNCitiesByContinent);


        // -------------------------
        // Use Case 14
        // -------------------------

        // the top n populated cities in a specified region where n is defined by the user.

        System.out.println(
                "\n========== USE CASE 14: TOP 8 POPULATED CITIES IN EASTERN AFRICA ==========\n"
        );

        // Retrieve the top 8 populated cities in Eastern Africa.
        ArrayList<City> topNCitiesByRegion = cityReports.getTopNCitiesByRegion("Eastern Africa", 8);

        // Display the top 8 populated cities in the specified region.
        cityReports.displayCities(topNCitiesByRegion);


        // -------------------------
        // Use Case 15
        // -------------------------

        // the top n populated cities in a specified country where n is defined by the user.

        System.out.println(
                "\n========== USE CASE 15: TOP 6 POPULATED CITIES IN ITALY ==========\n"
        );

        // Retrieve the top 6 populated cities in Italy.
        ArrayList<City> topNCitiesByCountry = cityReports.getTopNCitiesByCountry("Italy", 6);

        // Display the top 6 populated cities in the specified country.
        cityReports.displayCities(topNCitiesByCountry);


        // -------------------------
        // Use Case 16
        // -------------------------

        // Get the top 5 populated cities in California.
        System.out.println(
                "\n========== USE CASE 16: Top 5 populated city in California ==========\n"
        );
        // Use Case 16:
        // Get the top 5 populated cities in California.
        ArrayList<City> topNCitiesByDistrict = cityReports.getTopNCitiesByDistrict("California", 5);

        // Display the top 5 cities.
        cityReports.displayCities(topNCitiesByDistrict);


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
        ArrayList<CapitalCity> capitalCities = capitalCityReports.getCapitalCities();

        // Display the capital city population report.
        capitalCityReports.displayCapitalCities(capitalCities);


        // -------------------------
        // Use Case 18
        // -------------------------

        System.out.println(
                "\n========== USE CASE 18: CAPITAL CITIES IN SOUTH AMERICA ==========\n"
        );

        // Retrieve all capital cities in South America,
        // ordered from largest population to smallest.
        ArrayList<CapitalCity> capitalCitiesByContinent = capitalCityReports.getCapitalCitiesByContinent("South America");

        // Display the capital cities in South America.
        capitalCityReports.displayCapitalCities(capitalCitiesByContinent);



        // -------------------------
        // Use Case 19
        // -------------------------

        System.out.println(
                "\n========== USE CASE 19: CAPITAL CITIES IN CARIBBEAN ==========\n"
        );

        // Retrieve all capital cities in the Caribbean region,
        // ordered from largest population to smallest.
        ArrayList<CapitalCity> capitalCitiesByRegion = capitalCityReports.getCapitalCitiesByRegion("Caribbean");

        // Display the capital cities in the Caribbean region.
        capitalCityReports.displayCapitalCities(capitalCitiesByRegion);


        // -------------------------
        // Use Case 20
        // -------------------------

        System.out.println(
                "\n========== USE CASE 20: TOP 5 CAPITAL CITIES IN THE WORLD ==========\n"
        );

        // Retrieve the top 5 most populated capital cities
        // in the world, ordered from largest to smallest.
        ArrayList<CapitalCity> topCapitalCities =
                capitalCityReports.getTopNCapitalCities(5);

        // Display the top 5 capital cities in the world.
        capitalCityReports.displayCapitalCities(topCapitalCities);


        // -------------------------
        // Use Case 21 - Top 6 capital cities in Asia
        // -------------------------

        System.out.println("\n========== USE CASE 21: TOP 6 CAPITAL CITIES IN ASIA ==========\n");

        ArrayList<CapitalCity> topCapitalsByContinent =
                capitalCityReports.getTopNCapitalCitiesByContinent("Asia", 6);

        capitalCityReports.displayCapitalCities(topCapitalsByContinent);

        // -------------------------
        // Use Case 22 - Top 6 capital cities in Eastern Asia
        // -------------------------

        System.out.println("\n========== USE CASE 22: TOP 6 CAPITAL CITIES IN EASTERN ASIA ==========\n");

        ArrayList<CapitalCity> topCapitalsByRegion =
                capitalCityReports.getTopNCapitalCitiesByRegion("Eastern Asia", 6);

        capitalCityReports.displayCapitalCities(topCapitalsByRegion);


        // -------------------------
        // Use Case 23 - Population by Continent
        // -------------------------

        System.out.println("\n========== USE CASE 23: POPULATION BY CONTINENT ==========\n");

        ArrayList<Population> populationsByContinent =
                populationReports.getPopulationByContinent();

        populationReports.displayPopulationByContinent(populationsByContinent);


        // -------------------------
        // Use Case 24 - Population by Region
        // -------------------------

        System.out.println("\n========== USE CASE 24: POPULATION BY REGION ==========\n");

        ArrayList<Population> populationsByRegion =
                populationReports.getPopulationByRegion();

        populationReports.displayPopulationByRegion(populationsByRegion);


        // -------------------------
        // Use Case 25 - Population by Country
        // -------------------------

        System.out.println("\n========== USE CASE 25: POPULATION BY COUNTRY ==========\n");

        ArrayList<Population> populationsByCountry =
                populationReports.getPopulationByCountry();

        populationReports.displayPopulationByCountry(populationsByCountry);


                // -------------------------
                // Use Case 26 - World Population
                // -------------------------

        System.out.println("\n========== USE CASE 26: WORLD POPULATION ==========\n");

        Long worldPopulation =
                populationSummary.getWorldPopulation();

                populationSummary.displayWorldPopulation(worldPopulation);


        // -------------------------
        // Use Case 27 - Population of Asia
        // -------------------------

        System.out.println("\n========== USE CASE 27: POPULATION OF ASIA ==========\n");

        Long continentPopulation =
                populationSummary.getContinentPopulation("Asia");

                populationSummary.displayContinentPopulation(
                "Asia", continentPopulation);


        // -------------------------
        // Use Case 28 - Population of Southeast Asia
        // -------------------------

        System.out.println("\n========== USE CASE 28: POPULATION OF SOUTHEAST ASIA ==========\n");

        Long regionPopulation =
                populationSummary.getRegionPopulation("Southeast Asia");

                populationSummary.displayRegionPopulation(
                "Southeast Asia", regionPopulation);


        // -------------------------
        // Use Case 29 - Population of Myanmar
        // -------------------------

        System.out.println("\n========== USE CASE 29: POPULATION OF MYANMAR ==========\n");

        Long countryPopulation =
                populationSummary.getCountryPopulation("Myanmar");

                populationSummary.displayCountryPopulation(
                "Myanmar", countryPopulation);


        // -------------------------
        // Use Case 30 - Population of California
        // -------------------------

        System.out.println("\n========== USE CASE 30: POPULATION OF CALIFORNIA ==========\n");

        Long districtPopulation =
                populationSummary.getDistrictPopulation("California");

                populationSummary.displayDistrictPopulation(
                "California", districtPopulation);


        // -------------------------
        // Use Case 31 - Population of London
        // -------------------------

        System.out.println("\n========== USE CASE 31: POPULATION OF LONDON ==========\n");

        Long cityPopulation =
                populationSummary.getCityPopulation("London");

                populationSummary.displayCityPopulation(
                "London", cityPopulation);

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
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;

        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");

            try {
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
            } catch (SQLException sqle) {
                System.out.println(
                        "Failed to connect to database attempt " + i
                );
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println(
                        "Thread interrupted? Should not happen."
                );
            }
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