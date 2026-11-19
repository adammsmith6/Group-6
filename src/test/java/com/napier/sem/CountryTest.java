package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Tests for the country report methods.
 */
public class CountryTest
{
    static App app;
    static Country coun;

    @BeforeAll
    static void init() {
        app = new App();
        coun = new Country();
    }
    /**
     * Tests displayCountries with a null list.
     */
    @Test
    void displayCountriesTestNull()
    {
        // Test null country list
        coun.displayCountries(null);
    }

    /**
     * Tests displayCountries with an empty list.
     */
    @Test
    void displayCountriesTestEmpty()
    {

        // Create empty country list
        ArrayList<Country> countries = new ArrayList<>();

        // Test empty country list
        coun.displayCountries(countries);
    }

    /**
     * Tests displayCountries with a country in the list.
     */
    @Test
    void displayCountriesTestCountry()
    {
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
        coun.displayCountries(countries);
    }

    /**
     * Tests displayCountriesByContinent with a null list.
     *
    @Test
    void displayCountriesByContinentTestNull()
    {

        // Test the method with a null country list.
        coun.displayCountriesByContinent(null);
    }
    */

    /**
     * Tests displayCountriesByContinent with an empty list.
     *
    @Test
    void displayCountriesByContinentTestEmpty()
    {

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        coun.displayCountriesByContinent(countries);
    }
    */

    /**
     * Tests displayCountriesByContinent with valid country data.
     *
    @Test
    void displayCountriesByContinentTestCountry()
    {

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
        coun.displayCountries(countries);
    }
    */

    /**
     * Tests displayCountriesByRegion with a null list.
     *
    @Test
    void displayCountriesByRegionTestNull()
    {
        // Test the method with a null country list.
        coun.displayCountriesByRegion(null);
    }
    */

    /**
     * Tests displayCountriesByRegion with an empty list.
     *
    @Test
    void displayCountriesByRegionTestEmpty()
    {

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        coun.displayCountriesByRegion(countries);
    }
    */

    /**
     * Tests displayCountriesByRegion with valid country data.
     *
    @Test
    void displayCountriesByRegionTestCountry()
    {

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
        coun.displayCountriesByRegion(countries);
    }
    */

    /**
     * Tests displayTopNCountries with a null list.
     *
    @Test
    void displayTopNCountriesTestNull()
    {

        // Test the method with a null country list.
        coun.displayTopNCountries(null);
    }
    */


    /**
     * Tests displayTopNCountries with an empty list.
     *
    @Test
    void displayTopNCountriesTestEmpty()
    {
        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        coun.displayTopNCountries(countries);
    }
    */

    /**
     * Tests displayTopNCountries with valid country data.
     *
    @Test
    void displayTopNCountriesTestCountry()
    {

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
        coun.displayTopNCountries(countries);
    }
    */

    /**
     * Tests displayTopNCountriesByContinent with a null list.
     *
    @Test
    void displayTopNCountriesByContinentTestNull()
    {

        // Test the method with a null country list.
        coun.displayTopNCountriesByContinent(null);
    }
    */


    /**
     * Tests displayTopNCountriesByContinent with an empty list.
     *
    @Test
    void displayTopNCountriesByContinentTestEmpty()
    {

        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        coun.displayTopNCountriesByContinent(countries);
    }
    */


    /**
     * Tests displayTopNCountriesByContinent with valid country data.
     *
    @Test
    void displayTopNCountriesByContinentTestCountry()
    {

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
        coun.displayTopNCountriesByContinent(countries);
    }
    */

    /**
     * Tests displayTopNCountriesByRegion with a null list.
     *
    @Test
    void displayTopNCountriesByRegionTestNull()
    {

        // Test the method with a null country list.
        coun.displayTopNCountriesByRegion(null);
    }
    */


    /**
     * Tests displayTopNCountriesByRegion with an empty list.
     *
    @Test
    void displayTopNCountriesByRegionTestEmpty()
    {
        // Create an empty country list.
        ArrayList<Country> countries = new ArrayList<>();

        // Test the method with an empty country list.
        coun.displayTopNCountriesByRegion(countries);
    }
    */


    /**
     * Tests displayTopNCountriesByRegion with valid country data.
     *
    @Test
    void displayTopNCountriesByRegionTestCountry()
    {
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
        coun.displayTopNCountriesByRegion(countries);
    }
    */

}