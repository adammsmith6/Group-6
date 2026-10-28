package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Tests for the country report methods.
 */
public class CountryTest
{
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
}