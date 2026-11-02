
package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Unit tests for population reports.
 *
 * UC23 - Population by continent
 * UC24 - Population by region
 * UC25 - Population by country
 */
public class PopulationTest
{
    // ========================================
    // USE CASE 23 - Population by Continent
    // ========================================

    /**
     * UC23: Test that the method does not crash.
     */
    @Test
    void displayPopulationByContinentTest()
    {
        // Create application object.
        App app = new App();
        app.connect("localhost:33060", 0);

        // Test the population report method.
        assertDoesNotThrow(() ->
                app.displayPopulationByContinent());
    }


    // ========================================
    // USE CASE 24 - Population by Region
    // ========================================

    /**
     * UC24: Test that the method does not crash.
     */
    @Test
    void displayPopulationByRegionTest()
    {
        // Create application object.
        App app = new App();
        app.connect("localhost:33060", 0);

        // Test the population report method.
        assertDoesNotThrow(() ->
                app.displayPopulationByRegion());
    }


    // ========================================
    // USE CASE 25 - Population by Country
    // ========================================

    /**
     * UC25: Test that the method does not crash.
     */
    @Test
    void displayPopulationByCountryTest()
    {
        // Create application object.
        App app = new App();
        app.connect("localhost:33060", 0);

        // Test the population report method.
        assertDoesNotThrow(() ->
                app.displayPopulationByCountry());
    }
}
