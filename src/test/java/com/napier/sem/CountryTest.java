
package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Country.java.
 *
 * Tests the common displayCountries() method
 * used by country reports UC1 to UC6.
 *
 * Based on the testing approach in Lab 06.
 */
public class CountryTest
{
    // Country object used for testing.
    static Country countryReports;

    /**
     * Initialise the Country object before tests run.
     */
    @BeforeAll
    static void init()
    {
        countryReports = new Country();
    }

    /**
     * Test 1:
     * Check that a null country list does not
     * cause an exception.
     */
    @Test
    void displayCountriesTestNull()
    {
        assertDoesNotThrow(() ->
                countryReports.displayCountries(null));
    }

    /**
     * Test 2:
     * Check that an empty country list does not
     * cause an exception.
     */
    @Test
    void displayCountriesTestEmpty()
    {
        // Create an empty list.
        ArrayList<Country> countries = new ArrayList<>();

        // Display the empty list.
        assertDoesNotThrow(() ->
                countryReports.displayCountries(countries));
    }

    /**
     * Test 3:
     * Check that a list containing a null
     * country does not cause an exception.
     */
    @Test
    void displayCountriesTestContainsNull()
    {
        // Create a country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Add a null country.
        countries.add(null);

        // Display the list.
        assertDoesNotThrow(() ->
                countryReports.displayCountries(countries));
    }

    /**
     * Test 4:
     * Check that a valid country can be displayed.
     */
    @Test
    void displayCountriesTestValid()
    {
        // Create a list to store countries.
        ArrayList<Country> countries = new ArrayList<>();

        // Create a country.
        Country country = new Country();

        // Set country attributes.
        country.code = "GBR";
        country.name = "United Kingdom";
        country.continent = "Europe";
        country.region = "British Islands";
        country.population = 59623400;
        country.capital = "London";

        // Add the country to the list.
        countries.add(country);

        // Display the list.
        assertDoesNotThrow(() ->
                countryReports.displayCountries(countries));
    }
}
