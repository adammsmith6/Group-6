package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for the city report methods.
 */
public class CityTest
{

    static City cityObj;

    @BeforeAll
    static void init() {
        App a = new App();
        a.connect("localhost:33060", 0);
        cityObj = new City(a.con);
    }

    // ========================================
    // Test for UC7 - All cities in the world
    // ========================================

    /**
     * Tests that getCities() doesn't return an empty list
     */
    @Test
    void getCitiesTest()
    {
        // Checks that the getCities() method doesn't return an empty list
        ArrayList<City> allCities = cityObj.getCities();
        assert(!(allCities.isEmpty()));
    }

    // ========================================
    // Test for UC8 - All cities in a given continent
    // ========================================

    /**
     * Tests that getCitiesByContinent() doesn't return an empty list
     */
    @Test
    void getCitiesByContinentTest()
    {
        // Checks that the getCitiesByContinent() method doesn't return an empty list, for a random continent
        ArrayList<City> allCities = cityObj.getCitiesByContinent("Asia");
        assert(!(allCities.isEmpty()));
    }

    /**
     * Tests that getCitiesByContinent() returns an empty list when given a null continent
     */
    @Test
    void getCitiesByContinentNullTest()
    {
        // Checks that the getCitiesByContinent() method does return an empty list
        ArrayList<City> allCities = cityObj.getCitiesByContinent(null);
        assert(allCities.isEmpty());
    }

    // ========================================
    // Test for UC9 - All cities in a given region
    // ========================================

    /**
     * Tests that getCitiesByRegion() doesn't return an empty list
     */
    @Test
    void getCitiesByRegionTest()
    {
        // Checks that the getCitiesInRegion() method doesn't return an empty list, for a random region
        ArrayList<City> allCities = cityObj.getCitiesInRegion("Western Europe");
        assert(!(allCities.isEmpty()));
    }

    /**
     * Tests that getCitiesInRegion() returns an empty list when given a null continent
     */
    @Test
    void getCitiesByRegionNullTest()
    {
        // Checks that the getCitiesInRegion() method does return an empty list
        ArrayList<City> allCities = cityObj.getCitiesInRegion(null);
        assert(allCities.isEmpty());
    }

    // ========================================
    // Test for UC10 - All cities in a given Country
    // ========================================

    /**
     * Tests that getCitiesByCountry() doesn't return an empty list
     */
    @Test
    void getCitiesByCountryTest()
    {
        // Checks that the getCitiesInCountry() method doesn't return an empty list, for a random country
        ArrayList<City> allCities = cityObj.getCitiesInCountry("United Kingdom");
        assert(!(allCities.isEmpty()));
    }

    /**
     * Tests that getCitiesInCountry() returns an empty list when given a null country
     */
    @Test
    void getCitiesByCountryNullTest()
    {
        // Checks that the getCitiesInCountry() method does return an empty list
        ArrayList<City> allCities = cityObj.getCitiesInCountry(null);
        assert(allCities.isEmpty());
    }


    // ========================================
    // Test for UC11 - All cities in a given district
    // ========================================

    /**
     * Tests that getCitiesByDistrict() doesn't return an empty list
     */
    @Test
    void getCitiesByDistrictTest()
    {
        // Checks that the getCitiesInDistrict() method doesn't return an empty list, for a random district
        ArrayList<City> allCities = cityObj.getCitiesInDistrict("Scotland");
        assert(!(allCities.isEmpty()));
    }

    /**
     * Tests that getCitiesInDistrict() returns an empty list when given a null district
     */
    @Test
    void getCitiesByDistrictNullTest()
    {
        // Checks that the getCitiesInDistrict() method does return an empty list
        ArrayList<City> allCities = cityObj.getCitiesInDistrict(null);
        assert(allCities.isEmpty());
    }

    // ========================================
    // Test for UC12 - Top N cities in the world
    // ========================================
    /**
     * Tests that getTopNCities() returns a list of the correct length
     */
    @Test
    void getTopNCitiesTest()
    {
        // Checks that the getTopNCities() method returns a list of the correct length
        ArrayList<City> allCities = cityObj.getTopNCities(5);
        assert(allCities.size() == 5);
    }

    /**
     * Tests that getTopNCities() returns an empty list when given a value of zero
     */
    @Test
    void getTopNCitiesNullTest()
    {
        // Checks that the getCitiesInDistrict() method does return an empty list
        ArrayList<City> allCities = cityObj.getTopNCities(0);
        assert(allCities.isEmpty());
    }

    // ========================================
    // Test for UC13 - Top N cities in a continent
    // ========================================
    /**
     * Tests that getTopNCitiesByContinent() returns a list of the correct length
     */
    @Test
    void getTopNCitiesByContinentTest()
    {
        // Checks that the getTopNCitiesByContinent() method returns a list of the correct length
        ArrayList<City> allCities = cityObj.getTopNCitiesByContinent("Europe",5);
        assert(allCities.size() == 5);
    }

    /**
     * Tests that getTopNCitiesByContinent() returns an empty list when given a value of null
     */
    @Test
    void getTopNCitiesByContinentNullTest()
    {
        // Checks that the getCitiesInDistrict() method does return an empty list
        ArrayList<City> allCities = cityObj.getTopNCitiesByContinent(null,0);
        assert(allCities.isEmpty());
    }

    // ========================================
    // Test for UC14 - Top N cities in a region
    // ========================================
    /**
     * Tests that getTopNCitiesByRegion() returns a list of the correct length
     */
    @Test
    void getTopNCitiesByRegionTest()
    {
        // Checks that the getTopNCitiesByRegion() method returns a list of the correct length
        ArrayList<City> allCities = cityObj.getTopNCitiesByRegion("Eastern Europe",8);
        assert(allCities.size() == 8);
    }

    /**
     * Tests that getTopNCitiesByRegion() returns an empty list when given a value of null
     */
    @Test
    void getTopNCitiesByRegionNullTest()
    {
        // Checks that the getCitiesInDistrict() method does return an empty list
        ArrayList<City> allCities = cityObj.getTopNCitiesByRegion(null,13);
        assert(allCities.isEmpty());
    }

    // ========================================
    // Test for UC15 - Top N cities in a country
    // ========================================
    /**
     * Tests that getTopNCitiesByCountry() returns a list of the correct length
     */
    @Test
    void getTopNCitiesByCountryTest()
    {
        // Checks that the getTopNCitiesByCountry() method returns a list of the correct length
        ArrayList<City> allCities = cityObj.getTopNCitiesByCountry("Japan",7);
        assert(allCities.size() == 7);
    }

    /**
     * Tests that getTopNCitiesByCountry() returns an empty list when given a value of null
     */
    @Test
    void getTopNCitiesByCountryNullTest()
    {
        // Checks that the getCitiesInDistrict() method does return an empty list
        ArrayList<City> allCities = cityObj.getTopNCitiesByCountry(null,2);
        assert(allCities.isEmpty());
    }


    // ========================================
    // Tests for displayCities()
    // ========================================
    /**
     * Tests displayCities with a null list.
     */
    @Test
    void displayCitiesTestNull()
    {
        // Test the method with a null city list.
        cityObj.displayCities(null);
    }

    /**
     * Tests displayCities with an empty list.
     */
    @Test
    void displayCitiesTestEmpty()
    {
        // Create an empty city list.
        ArrayList<City> cities = new ArrayList<>();

        // Test the method with an empty city list.
        cityObj.displayCities(cities);
    }

    /**
     * Tests displayCities with valid city data.
     */
    @Test
    void displayCitiesTestCity()
    {
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
        cityObj.displayCities(cities);
    }
}
