package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for the city report methods.
 */
public class CityTest
{
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
