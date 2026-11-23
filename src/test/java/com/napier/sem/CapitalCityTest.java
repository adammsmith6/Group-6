package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Tests the capital city report display for use cases 17 to 22.
 */
public class CapitalCityTest
{
    static CapitalCity capCityObj;


    @BeforeAll
    static void init()
    {
        capCityObj = new CapitalCity();
    }

    @Test
    void displayCapitalCitiesTestNull()
    {
        capCityObj.displayCapitalCities(null);
    }

    @Test
    void displayCapitalCitiesTestEmpty()
    {
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();

        capCityObj.displayCapitalCities(capitalCities);
    }

    /** UC17 checks display of the world capital city report. */
    @Test
    void displayCapitalCitiesTestWorld()
    {
        displayCapitalCity("London", "United Kingdom", 7285000);
    }

    /** UC18 checks display of the South America capital city report. */
    @Test
    void displayCapitalCitiesTestSouthAmerica()
    {
        displayCapitalCity("Buenos Aires", "Argentina", 2982146);
    }

    /** UC19 checks display of the Caribbean capital city report. */
    @Test
    void displayCapitalCitiesTestCaribbean()
    {
        displayCapitalCity("Havana", "Cuba", 2256000);
    }

    /** UC20 checks display of a row from the worldwide top-five report. */
    @Test
    void displayTopFiveCapitalCitiesTestWorld()
    {
        displayCapitalCity("Tokyo", "Japan", 7980230);
    }

    /** UC21 checks display of a row from the top-six report for Asia. */
    @Test
    void displayTopSixCapitalCitiesTestAsia()
    {
        displayCapitalCity("Jakarta", "Indonesia", 9604900);
    }

    /** UC22 checks display of a row from the top-six report for Eastern Asia. */
    @Test
    void displayTopSixCapitalCitiesTestEasternAsia()
    {
        displayCapitalCity("Seoul", "South Korea", 9981619);
    }
    private void displayCapitalCity(String name, String country, int population)
    {
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.name = name;
        capitalCity.country = country;
        capitalCity.population = population;

        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        capitalCities.add(capitalCity);

        capCityObj.displayCapitalCities(capitalCities);
    }
}