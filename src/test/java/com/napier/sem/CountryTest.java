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

    /**
     * Tests displayCountriesByContinent with a null list.
     */
    @Test
    void displayCountriesByContinentTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null country list.
        app.displayCountriesByContinent(null);
    }


    /**
     * Tests displayCountriesByContinent with an empty list.
     */
    @Test
    void displayCountriesByContinentTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        app.displayCountriesByContinent(countries);
    }


    /**
     * Tests displayCountriesByContinent with valid country data.
     */
    @Test
    void displayCountriesByContinentTestCountry()
    {
        // Create application object.
        App app = new App();

        // Create a country for testing.
        Country country = new Country();
        country.code = "GBR";
        country.name = "United Kingdom";
        country.continent = "Europe";
        country.region = "British Islands";
        country.population = 59623400;
        country.capital = "London";

        // Create a country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Add the country to the list.
        countries.add(country);

        // Test the method with valid country data.
        app.displayCountriesByContinent(countries);
    }

    /**
     * Tests displayCountriesByRegion with a null list.
     */
    @Test
    void displayCountriesByRegionTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null country list.
        app.displayCountriesByRegion(null);
    }


    /**
     * Tests displayCountriesByRegion with an empty list.
     */
    @Test
    void displayCountriesByRegionTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        app.displayCountriesByRegion(countries);
    }


    /**
     * Tests displayCountriesByRegion with valid country data.
     */
    @Test
    void displayCountriesByRegionTestCountry()
    {
        // Create application object.
        App app = new App();

        // Create a country for testing.
        Country country = new Country();
        country.code = "DEU";
        country.name = "Germany";
        country.continent = "Europe";
        country.region = "Western Europe";
        country.population = 82164700;
        country.capital = "Berlin";

        // Create a country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Add the country to the list.
        countries.add(country);

        // Test the method with valid country data.
        app.displayCountriesByRegion(countries);
    }

    /**
     * Tests displayTopNCountries with a null list.
     */
    @Test
    void displayTopNCountriesTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null country list.
        app.displayTopNCountries(null);
    }


    /**
     * Tests displayTopNCountries with an empty list.
     */
    @Test
    void displayTopNCountriesTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        app.displayTopNCountries(countries);
    }


    /**
     * Tests displayTopNCountries with valid country data.
     */
    @Test
    void displayTopNCountriesTestCountry()
    {
        // Create application object.
        App app = new App();

        // Create a country for testing.
        Country country = new Country();
        country.code = "CHN";
        country.name = "China";
        country.continent = "Asia";
        country.region = "Eastern Asia";
        country.population = 1277558000;
        country.capital = "Peking";

        // Create a country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Add the country to the list.
        countries.add(country);

        // Test the method with valid country data.
        app.displayTopNCountries(countries);
    }

    /**
     * Tests displayTopNCountriesByContinent with a null list.
     */
    @Test
    void displayTopNCountriesByContinentTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null country list.
        app.displayTopNCountriesByContinent(null);
    }


    /**
     * Tests displayTopNCountriesByContinent with an empty list.
     */
    @Test
    void displayTopNCountriesByContinentTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        app.displayTopNCountriesByContinent(countries);
    }


    /**
     * Tests displayTopNCountriesByContinent with valid country data.
     */
    @Test
    void displayTopNCountriesByContinentTestCountry()
    {
        // Create application object.
        App app = new App();

        // Create a country for testing.
        Country country = new Country();
        country.code = "RUS";
        country.name = "Russian Federation";
        country.continent = "Europe";
        country.region = "Eastern Europe";
        country.population = 146934000;
        country.capital = "Moscow";

        // Create a country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Add the country to the list.
        countries.add(country);

        // Test the method with valid country data.
        app.displayTopNCountriesByContinent(countries);
    }

    /**
     * Tests displayTopNCountriesByRegion with a null list.
     */
    @Test
    void displayTopNCountriesByRegionTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null country list.
        app.displayTopNCountriesByRegion(null);
    }


    /**
     * Tests displayTopNCountriesByRegion with an empty list.
     */
    @Test
    void displayTopNCountriesByRegionTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        app.displayTopNCountriesByRegion(countries);
    }


    /**
     * Tests displayTopNCountriesByRegion with valid country data.
     */
    @Test
    void displayTopNCountriesByRegionTestCountry()
    {
        // Create application object.
        App app = new App();

        // Create a country for testing.
        Country country = new Country();
        country.code = "DEU";
        country.name = "Germany";
        country.continent = "Europe";
        country.region = "Western Europe";
        country.population = 82164700;
        country.capital = "Berlin";

        // Create a country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Add the country to the list.
        countries.add(country);

        // Test the method with valid country data.
        app.displayTopNCountriesByRegion(countries);
    }

}