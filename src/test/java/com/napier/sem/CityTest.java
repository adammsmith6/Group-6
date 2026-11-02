package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for the city report methods.
 *
 * UC7  - All cities in the world.
 * UC8  - All cities in a continent.
 * UC16 - Top N cities in a district.
 */
public class CityTest
{
    // ========================================
    // UC7 - All cities in the world
    // ========================================

    /**
     * Tests displayCities with a null list.
     */
    @Test
    void displayCitiesTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null city list.
        app.displayCities(null);
    }

    /**
     * Tests displayCities with an empty list.
     */
    @Test
    void displayCitiesTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty city list.
        ArrayList<City> cities = new ArrayList<>();

        // Test the method with an empty city list.
        app.displayCities(cities);
    }

    /**
     * Tests displayCities with valid city data.
     */
    @Test
    void displayCitiesTestCity()
    {
        // Create application object.
        App app = new App();

        // Create a city for testing.
        City city = new City();
        city.name = "Mumbai";
        city.country = "India";
        city.district = "Maharashtra";
        city.population = 10500000;

        // Create a city list.
        ArrayList<City> cities = new ArrayList<>();

        // Add the city to the list.
        cities.add(city);

        // Test the method with valid city data.
        app.displayCities(cities);
    }

    // ========================================
    // UC8 - All cities in a continent
    // ========================================

    /**
     * Tests displayCitiesByContinent with a null list.
     */
    @Test
    void displayCitiesByContinentTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null city list.
        app.displayCitiesByContinent(null);
    }

    /**
     * Tests displayCitiesByContinent with an empty list.
     */
    @Test
    void displayCitiesByContinentTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty city list.
        ArrayList<City> cities = new ArrayList<>();

        // Test the method with an empty city list.
        app.displayCitiesByContinent(cities);
    }

    /**
     * Tests displayCitiesByContinent with valid city data.
     */
    @Test
    void displayCitiesByContinentTestCity()
    {
        // Create application object.
        App app = new App();

        // Create a city in Asia for testing.
        City city = new City();
        city.name = "Tokyo";
        city.country = "Japan";
        city.district = "Tokyo-to";
        city.population = 7980230;

        // Create a city list.
        ArrayList<City> cities = new ArrayList<>();

        // Add the city to the list.
        cities.add(city);

        // Test the method with valid city data.
        app.displayCitiesByContinent(cities);
    }

    // ========================================
    // UC16 - Top N cities in a district
    // ========================================

    /**
     * Tests displayTopNCitiesByDistrict with a null list.
     */
    @Test
    void displayTopNCitiesByDistrictTestNull()
    {
        // Create application object.
        App app = new App();

        // Test the method with a null city list.
        app.displayTopNCitiesByDistrict(null);
    }

    /**
     * Tests displayTopNCitiesByDistrict with an empty list.
     */
    @Test
    void displayTopNCitiesByDistrictTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create an empty city list.
        ArrayList<City> cities = new ArrayList<>();

        // Test the method with an empty city list.
        app.displayTopNCitiesByDistrict(cities);
    }

    /**
     * Tests displayTopNCitiesByDistrict with valid city data.
     */
    @Test
    void displayTopNCitiesByDistrictTestCity()
    {
        // Create application object.
        App app = new App();

        // Create a city for testing.
        City city = new City();
        city.name = "Los Angeles";
        city.country = "United States";
        city.district = "California";
        city.population = 3694820;

        // Create a city list.
        ArrayList<City> cities = new ArrayList<>();

        // Add the city to the list.
        cities.add(city);

        // Test the method with valid city data.
        app.displayTopNCitiesByDistrict(cities);
    }
}
