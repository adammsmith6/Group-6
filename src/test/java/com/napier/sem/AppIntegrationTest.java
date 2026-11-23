
package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    // Application used to manage the database connection.
    private static App app;

    // Database connection shared by integration tests.
    private static Connection connection;

    // Country object used to retrieve database reports.
    private static Country coun;

    /**
     * Retrieve the existing database connection from App.
     */
    private static Connection getAppConnection()
    {
        try
        {
            Class<?> currentClass = app.getClass();

            while (currentClass != null)
            {
                for (Field field : currentClass.getDeclaredFields())
                {
                    if (Connection.class.isAssignableFrom(field.getType()))
                    {
                        field.setAccessible(true);

                        Connection found =
                                (Connection) field.get(app);

                        if (found != null)
                        {
                            return found;
                        }
                    }
                }

                currentClass = currentClass.getSuperclass();
            }
        }
        catch (Exception e)
        {
            fail("Could not access database connection.", e);
        }

        return null;
    }

    /**
     * Assign the database connection to a report object.
     */
    private static void setConnection(Object object)
    {
        boolean found = false;

        try
        {
            Class<?> currentClass = object.getClass();

            while (currentClass != null)
            {
                for (Field field : currentClass.getDeclaredFields())
                {
                    if (Connection.class.isAssignableFrom(field.getType()))
                    {
                        field.setAccessible(true);
                        field.set(object, connection);
                        found = true;
                    }
                }

                currentClass = currentClass.getSuperclass();
            }
        }
        catch (Exception e)
        {
            fail("Could not assign database connection.", e);
        }

        assertTrue(found,
                "No Connection field found in "
                        + object.getClass().getSimpleName());
    }

    /**
     * Connect to MySQL before running the tests.
     */
    @BeforeAll
    static void init()
    {
        app = new App();

        // Connect to the database.
        app.connect("localhost:33060", 0);

        // Retrieve the existing database connection.
        connection = getAppConnection();

        // Ensure the database connection exists.
        assertNotNull(connection,
                "Database connection failed.");

        // Create Country object.
        coun = new Country();

        // Assign the existing connection.
        setConnection(coun);
    }

    /**
     * Tests that getCountries retrieves the
     * United Kingdom correctly from the database.
     */
    @Test
    void getCountriesTest()
    {
        // Create the expected country information.
        Country country = new Country();

        country.code = "GBR";
        country.name = "United Kingdom";
        country.continent = "Europe";
        country.region = "British Islands";
        country.population = 59623400;
        country.capital = "London";

        // Retrieve all countries from the database.
        ArrayList<Country> countries = coun.getCountries();

        // Ensure the query returned a list.
        assertNotNull(countries,
                "Country query should return a non-null list.");

        // Check whether the expected country exists.
        boolean found = false;

        for (Country c : countries)
        {
            if (Objects.equals(c.code, country.code))
            {
                assertEquals(country.code, c.code);
                assertEquals(country.name, c.name);
                assertEquals(country.continent, c.continent);
                assertEquals(country.region, c.region);
                assertEquals(country.population, c.population);
                assertEquals(country.capital, c.capital);

                found = true;
                break;
            }
        }

        assertTrue(found,
                "United Kingdom should exist in the report.");
    }

    // ----------------
    // TESTS FOR CITIES
    // ----------------

    /**
     * Tests getCities by checking if it contains
     * an example city.
     */
    @Test
    void getCitiesTest()
    {
        // Create city with database connection.
        City city = new City(connection);

        city.name = "Seoul";
        city.country = "South Korea";
        city.district = "Seoul";
        city.population = 9981619;

        // Retrieve cities from database.
        ArrayList<City> cities = city.getCities();

        // Ensure the query returned a list.
        assertNotNull(cities,
                "City query should return a non-null list.");

        // Check if the expected city exists.
        boolean found = false;

        for (City c : cities)
        {
            if (Objects.equals(c.name, city.name))
            {
                assertEquals(city.name, c.name);
                assertEquals(city.country, c.country);
                assertEquals(city.district, c.district);
                assertEquals(city.population, c.population);

                found = true;
                break;
            }
        }

        assertTrue(found,
                "Seoul should exist in the city report.");
    }

    // ------------------------
    // TESTS FOR CAPITAL CITIES
    // ------------------------

    /**
     * Tests getCapitalCities by checking if it
     * contains an example capital city.
     */
    @Test
    void getCapitalCitiesTest()
    {
        // Create capital city for testing.
        CapitalCity city = new CapitalCity();

        // Assign the database connection.
        setConnection(city);

        city.name = "Seoul";
        city.country = "South Korea";
        city.population = 9981619;

        // Retrieve capital cities from database.
        ArrayList<CapitalCity> cities =
                city.getCapitalCities();

        // Ensure the query returned a list.
        assertNotNull(cities,
                "Capital city query should return a non-null list.");

        // Check if the expected city exists.
        boolean found = false;

        for (CapitalCity c : cities)
        {
            if (Objects.equals(c.name, city.name))
            {
                assertEquals(city.name, c.name);
                assertEquals(city.country, c.country);
                assertEquals(city.population, c.population);

                found = true;
                break;
            }
        }

        assertTrue(found,
                "Seoul should exist in the capital city report.");
    }
}
