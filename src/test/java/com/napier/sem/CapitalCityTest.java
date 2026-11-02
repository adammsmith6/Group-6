
package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for the capital city report methods.
 */
public class CapitalCityTest
{
    /**
     * UC17: Tests displayCapitalCities with a null list.
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
     * UC17: Tests displayCapitalCities with an empty list.
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

    /**
     * UC17: Tests displayCapitalCities with valid capital city data.
     */
    @Test
    void displayCapitalCitiesTestCapitalCity()
    {
        // Create application object.
        App app = new App();

        // Create capital city for testing.
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.name = "London";
        capitalCity.country = "United Kingdom";
        capitalCity.population = 7285000;

        // Create capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Add capital city to list.
        capitalCities.add(capitalCity);

        // Test capital city list.
        app.displayCapitalCities(capitalCities);
    }

    /**
     * UC18: Tests displayCapitalCitiesByContinent with a null list.
     */
    @Test
    void displayCapitalCitiesByContinentTestNull()
    {
        // Create application object.
        App app = new App();

        // Test null capital city list.
        app.displayCapitalCitiesByContinent(null);
    }

    /**
     * UC18: Tests displayCapitalCitiesByContinent with an empty list.
     */
    @Test
    void displayCapitalCitiesByContinentTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create empty capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Test empty capital city list.
        app.displayCapitalCitiesByContinent(capitalCities);
    }

    /**
     * UC18: Tests displayCapitalCitiesByContinent with valid capital city data.
     */
    @Test
    void displayCapitalCitiesByContinentTestCapitalCity()
    {
        // Create application object.
        App app = new App();

        // Create capital city for testing.
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.name = "Lima";
        capitalCity.country = "Peru";
        capitalCity.population = 6464693;

        // Create capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Add capital city to list.
        capitalCities.add(capitalCity);

        // Test capital city list.
        app.displayCapitalCitiesByContinent(capitalCities);
    }

    /**
     * UC19: Tests displayCapitalCitiesByRegion with a null list.
     */
    @Test
    void displayCapitalCitiesByRegionTestNull()
    {
        // Create application object.
        App app = new App();

        // Test null capital city list.
        app.displayCapitalCitiesByRegion(null);
    }

    /**
     * UC19: Tests displayCapitalCitiesByRegion with an empty list.
     */
    @Test
    void displayCapitalCitiesByRegionTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create empty capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Test empty capital city list.
        app.displayCapitalCitiesByRegion(capitalCities);
    }

    /**
     * UC19: Tests displayCapitalCitiesByRegion with valid capital city data.
     */
    @Test
    void displayCapitalCitiesByRegionTestCapitalCity()
    {
        // Create application object.
        App app = new App();

        // Create capital city for testing.
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.name = "La Habana";
        capitalCity.country = "Cuba";
        capitalCity.population = 2256000;

        // Create capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Add capital city to list.
        capitalCities.add(capitalCity);

        // Test capital city list.
        app.displayCapitalCitiesByRegion(capitalCities);
    }

    /**
     * UC20: Tests displayTopNCapitalCities with a null list.
     */
    @Test
    void displayTopNCapitalCitiesTestNull()
    {
        // Create application object.
        App app = new App();

        // Test null capital city list.
        app.displayTopNCapitalCities(null);
    }

    /**
     * UC20: Tests displayTopNCapitalCities with an empty list.
     */
    @Test
    void displayTopNCapitalCitiesTestEmpty()
    {
        // Create application object.
        App app = new App();

        // Create empty capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Test empty capital city list.
        app.displayTopNCapitalCities(capitalCities);
    }

    /**
     * UC20: Tests displayTopNCapitalCities with valid capital city data.
     */
    @Test
    void displayTopNCapitalCitiesTestCapitalCity()
    {
        // Create application object.
        App app = new App();

        // Create capital city for testing.
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.name = "Tokyo";
        capitalCity.country = "Japan";
        capitalCity.population = 7980230;

        // Create capital city list.
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        // Add capital city to list.
        capitalCities.add(capitalCity);

        // Test capital city list.
        app.displayTopNCapitalCities(capitalCities);
    }
}
