
package com.napier.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Population class.
 *
 * Tests the population reports for UC23, UC24 and UC25.
 *
 * The tests verify display functionality and handling
 * of an unavailable database connection.
 */
public class PopulationTest
{
    // Population object used for testing.
    private Population populationReports;

    // Stores the original console output.
    private PrintStream originalOutput;

    // Stores the output generated during tests.
    private ByteArrayOutputStream output;

    /**
     * Sets up the testing environment before each test.
     */
    @BeforeEach
    public void setUp()
    {
        // Create a Population object without a database.
        populationReports = new Population();

        // Save the original console output.
        originalOutput = System.out;

        // Capture output from display methods.
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    /**
     * Restores console output after each test.
     */
    @AfterEach
    public void tearDown()
    {
        System.setOut(originalOutput);
    }

    /**
     * Creates a sample population record.
     *
     * @param name Name of continent, region or country.
     * @param total Total population.
     * @param city City population.
     * @return Population object containing test data.
     */
    private Population createPopulation(
            String name, long total, long city)
    {
        Population population = new Population();

        population.name = name;
        population.totalPopulation = total;
        population.cityPopulation = city;

        // Calculate non-city population.
        population.nonCityPopulation = total - city;

        // Calculate population percentages.
        if (total > 0)
        {
            population.cityPercentage =
                    city * 100.0 / total;

            population.nonCityPercentage =
                    population.nonCityPopulation * 100.0 / total;
        }
        else
        {
            population.cityPercentage = 0;
            population.nonCityPercentage = 0;
        }

        return population;
    }

    /**
     * Test 1:
     * Check that a null population list is handled.
     */
    @Test
    public void displayPopulationTestNull()
    {
        // Display a null list.
        populationReports.displayPopulationByContinent(null);

        // Verify the appropriate message is printed.
        assertTrue(output.toString().contains(
                "No population information available."
        ));
    }

    /**
     * Test 2:
     * Check that an empty population list is handled.
     */
    @Test
    public void displayPopulationTestEmpty()
    {
        // Create an empty list.
        ArrayList<Population> populations =
                new ArrayList<>();

        // Display the empty list.
        populationReports.displayPopulationByContinent(
                populations
        );

        // Verify the appropriate message is printed.
        assertTrue(output.toString().contains(
                "No population records found."
        ));
    }

    /**
     * Test 3:
     * Check that a valid continent population
     * is displayed correctly.
     */
    @Test
    public void displayPopulationByContinentTestValid()
    {
        ArrayList<Population> populations =
                new ArrayList<>();

        // Create population test data.
        populations.add(createPopulation(
                "Asia", 1000000, 600000
        ));

        // Display population by continent.
        populationReports.displayPopulationByContinent(
                populations
        );

        String result = output.toString();

        // Verify the displayed information.
        assertAll(
                () -> assertTrue(result.contains("Asia")),
                () -> assertTrue(result.contains("1000000")),
                () -> assertTrue(result.contains("600000")),
                () -> assertTrue(result.contains("400000")),
                () -> assertTrue(result.contains("60.00")),
                () -> assertTrue(result.contains("40.00"))
        );
    }

    /**
     * Test 4:
     * Check that a valid region population
     * is displayed correctly.
     */
    @Test
    public void displayPopulationByRegionTestValid()
    {
        ArrayList<Population> populations =
                new ArrayList<>();

        // Create population test data.
        populations.add(createPopulation(
                "Southeast Asia", 800000, 200000
        ));

        // Display population by region.
        populationReports.displayPopulationByRegion(
                populations
        );

        String result = output.toString();

        // Verify the region and population values.
        assertAll(
                () -> assertTrue(
                        result.contains("Southeast Asia")),
                () -> assertTrue(result.contains("800000")),
                () -> assertTrue(result.contains("200000")),
                () -> assertTrue(result.contains("600000")),
                () -> assertTrue(result.contains("25.00")),
                () -> assertTrue(result.contains("75.00"))
        );
    }

    /**
     * Test 5:
     * Check that a valid country population
     * is displayed correctly.
     */
    @Test
    public void displayPopulationByCountryTestValid()
    {
        ArrayList<Population> populations =
                new ArrayList<>();

        // Create population test data.
        populations.add(createPopulation(
                "Myanmar", 500000, 300000
        ));

        // Display population by country.
        populationReports.displayPopulationByCountry(
                populations
        );

        String result = output.toString();

        // Verify country population details.
        assertAll(
                () -> assertTrue(result.contains("Myanmar")),
                () -> assertTrue(result.contains("500000")),
                () -> assertTrue(result.contains("300000")),
                () -> assertTrue(result.contains("200000")),
                () -> assertTrue(result.contains("60.00")),
                () -> assertTrue(result.contains("40.00"))
        );
    }

    /**
     * Test 6:
     * Check that the correct column headings
     * are displayed for population reports.
     */
    @Test
    public void displayPopulationTestHeadings()
    {
        ArrayList<Population> populations =
                new ArrayList<>();

        populations.add(createPopulation(
                "Europe", 1000000, 700000
        ));

        populationReports.displayPopulationByContinent(
                populations
        );

        String result = output.toString();

        // Verify all required column headings.
        assertAll(
                () -> assertTrue(result.contains("Continent")),
                () -> assertTrue(result.contains("Total Population")),
                () -> assertTrue(result.contains("City Population")),
                () -> assertTrue(result.contains("Non-City Population")),
                () -> assertTrue(result.contains("City %")),
                () -> assertTrue(result.contains("Non-City %"))
        );
    }

    /**
     * Test 7:
     * Check that multiple population records
     * are displayed correctly.
     */
    @Test
    public void displayPopulationTestMultiple()
    {
        ArrayList<Population> populations =
                new ArrayList<>();

        // Create two population records.
        populations.add(createPopulation(
                "Asia", 1000000, 600000
        ));

        populations.add(createPopulation(
                "Europe", 800000, 400000
        ));

        // Display the population report.
        populationReports.displayPopulationByContinent(
                populations
        );

        String result = output.toString();

        // Verify both records appear in the output.
        assertAll(
                () -> assertTrue(result.contains("Asia")),
                () -> assertTrue(result.contains("Europe")),
                () -> assertTrue(result.contains("1000000")),
                () -> assertTrue(result.contains("800000")),
                () -> assertTrue(result.contains("600000")),
                () -> assertTrue(result.contains("400000"))
        );
    }

    /**
     * Test 8:
     * Check that zero population values
     * are displayed correctly.
     */
    @Test
    public void displayPopulationTestZero()
    {
        ArrayList<Population> populations =
                new ArrayList<>();

        // Create a record with zero population.
        populations.add(createPopulation(
                "Test Region", 0, 0
        ));

        populationReports.displayPopulationByRegion(
                populations
        );

        String result = output.toString();

        // Verify zero percentages and no invalid values.
        assertAll(
                () -> assertTrue(
                        result.contains("Test Region")),
                () -> assertTrue(result.contains("0.00")),
                () -> assertFalse(result.contains("NaN")),
                () -> assertFalse(result.contains("Infinity"))
        );
    }

    /**
     * Test 9:
     * Check that retrieving a continent population
     * without a database connection returns null.
     */
    @Test
    public void getPopulationByContinentTestNoConnection()
    {
        ArrayList<Population> populations =
                populationReports.getPopulationByContinent();

        // Verify retrieval fails safely.
        assertNull(populations);

        // Verify the error message.
        assertTrue(output.toString().contains(
                "Database connection unavailable."
        ));
    }

    /**
     * Test 10:
     * Check that region and country retrieval methods
     * handle a missing database connection.
     */
    @Test
    public void getPopulationByRegionAndCountryTestNoConnection()
    {
        // Retrieve population without a connection.
        ArrayList<Population> regions =
                populationReports.getPopulationByRegion();

        ArrayList<Population> countries =
                populationReports.getPopulationByCountry();

        // Verify both methods return null.
        assertAll(
                () -> assertNull(regions),
                () -> assertNull(countries)
        );
    }
}
