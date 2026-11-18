package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    // Application used to manage the database connection.
    private static App app;

    // Country object used to retrieve database reports.
    private static Country coun;

    /**
     * Connect to MySQL before running the tests.
     */
    @BeforeAll
    static void init()
    {
        app = new App();

        // Use the existing database connection method.
        app.connect("localhost:33060", 0);

        // Pass the active connection to Country.
        coun = new Country(app.getConnection());

        assertNotNull(app.getConnection(),
                "Database connection should be available.");
    }

    /**
     * Tests that getCountries retrieves the
     * United Kingdom correctly from the database.
     */
    @Test
    void getCountriesTest()
    {
        // Create the expected country information.
        Country country = new Country();

        country.code = "GBR";
        country.name = "United Kingdom";
        country.continent = "Europe";
        country.region = "British Islands";
        country.population = 59623400;
        country.capital = "London";

        // Retrieve all countries from the database.
        ArrayList<Country> countries = coun.getCountries();

        // Ensure the query returned a list.
        assertNotNull(countries,
                "Country query should return a non-null list.");

        // Check whether the expected country exists.
        boolean found = false;

        for (Country c : countries)
        {
            if (Objects.equals(c.code, country.code))
            {
                assertEquals(country.code, c.code);
                assertEquals(country.name, c.name);
                assertEquals(country.continent, c.continent);
                assertEquals(country.region, c.region);
                assertEquals(country.population, c.population);
                assertEquals(country.capital, c.capital);

                found = true;
                break;
            }
        }

        assertTrue(found,
                "United Kingdom should exist in the report.");
    }


    // ----------------
    // TESTS FOR CITIES
    // ----------------

    /**
     * Tests getCities by seeing if it contains an example city
     */
    @Test
    void getCitiesTest() {
        // Create city for testing
        City city = new City();
        city.name = "Seoul";
        city.country = "South Korea";
        city.district = "Seoul";
        city.population = 9981619;

        // Calling getCities method and asserting it contains our city
        ArrayList<City> cities = app.getCities();

        // Checking if there is an item within the list matching our created city
        boolean found = false;
        for (City c : cities) {
            if (Objects.equals(c.name, city.name)) {
                assertEquals(city.name, c.name);
                assertEquals(city.country, c.country);
                assertEquals(city.district, c.district);
                assertEquals(city.population, c.population);
                found = true;
            }
        }

        assertTrue(found);
    }

    // ------------------------
    // TESTS FOR CAPITAL CITIES
    // ------------------------

    /**
     * Tests getCapitalCities by seeing if it contains an example city
     */
    @Test
    void getCapitalCitiesTest() {
        // Create city for testing
        CapitalCity city = new CapitalCity();
        city.name = "Seoul";
        city.country = "South Korea";
        city.population = 9981619;

        // Calling getCapitalCities method and asserting it contains our city
        ArrayList<CapitalCity> cities = app.getCapitalCities();

        // Checking if there is an item within the list matching our created city
        boolean found = false;
        for (CapitalCity c : cities) {
            if (Objects.equals(c.name, city.name)) {
                assertEquals(city.name, c.name);
                assertEquals(city.country, c.country);
                assertEquals(city.population, c.population);
                found = true;
            }
        }

        assertTrue(found);
    }
}