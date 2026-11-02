package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);

    }

    // -------------------
    // TESTS FOR COUNTRIES
    // -------------------

    /**
     * Tests displayCountries with a null list.
     */
    @Test
    void displayCountriesTestNull()
    {
        // Create application object
        App app = new App();

        // Test null country list
        app.displayCountries(null);
    }

    /**
     * Tests displayCountries with an empty list.
     */
    @Test
    void displayCountriesTestEmpty()
    {
        // Create application object
        App app = new App();

        // Create empty country list
        ArrayList<Country> countries = new ArrayList<>();

        // Test empty country list
        app.displayCountries(countries);
    }

    /**
     * Tests displayCountries with a country in the list.
     */
    @Test
    void displayCountriesTestCountry()
    {
        // Create application object
        App app = new App();

        // Create country for testing
        Country country = new Country();
        country.code = "GBR";
        country.name = "United Kingdom";
        country.continent = "Europe";
        country.region = "British Islands";
        country.population = 59623400;
        country.capital = "London";

        // Create country list
        ArrayList<Country> countries = new ArrayList<>();

        // Add country to list
        countries.add(country);

        // Test country list
        app.displayCountries(countries);
    }



    // ----------------
    // TESTS FOR CITIES
    // ----------------
    /**
     * Tests displayCities with a null list.
     */
    @Test
    void displayCitiesTestNull()
    {
        // Create application object
        App app = new App();

        // Test null country list
        app.displayCities(null);
    }

    /**
     * Tests displayCities with an empty list.
     */
    @Test
    void displayCitiesTestEmpty()
    {
        // Create application object
        App app = new App();

        // Create empty city list
        ArrayList<City> cities = new ArrayList<>();

        // Test empty city list
        app.displayCities(cities);
    }

    // ----------------
    // TESTS FOR CAPITAL CITIES
    // ----------------
    /**
     * Tests displayCapitalCities with a null list.
     */
    @Test
    void displayCapitalCitiesTestNull()
    {
        // Create application object.
        App app = new App();

        // Test null capital city list.
        app.displayCapitalCities(null);
    }

    /**
     * Tests displayCapitalCities with an empty list.
     */
    @Test
    void displayCapitalCitiesTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create empty capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Test empty capital city list.
        app.displayCapitalCities(capitalCities);
    }
}