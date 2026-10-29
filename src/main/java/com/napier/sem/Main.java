package com.napier.sem;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // Create the application.
        App a = new App();

        // Connect to the World database.
        a.connect();

        // Use Case 1
        // Retrieve all countries ordered from largest
        // population to smallest.
        // ArrayList<Country> countries = a.getCountries();

        // Display the country population report.
        // a.displayCountries(countries);

        // Use Case 2
        // Retrieve all countries in Europe ordered by population.
        ArrayList<Country> countriesByContinent =
                a.getCountriesByContinent("Europe");

        // Display the countries in Europe.
        a.displayCountriesByContinent(countriesByContinent);


        // Use Case 3
        System.out.println(
                "\n========== USE CASE 3: WESTERN EUROPE ==========\n"
        );

        // Retrieve all countries in Western Europe,
        // ordered from largest population to smallest.
        ArrayList<Country> countriesByRegion =
                a.getCountriesByRegion("Western Europe");

        // Display the countries in Western Europe.
        a.displayCountriesByRegion(countriesByRegion);

        // -------------------------
        // Use Case 4
        // -------------------------

        System.out.println(
                "\n========== USE CASE 4: TOP 5 COUNTRIES ==========\n"
        );

        // Retrieve the top 5 populated countries
        // in the world.
        ArrayList<Country> topCountries =
                a.getTopNCountries(5);

        // Display the top 5 countries.
        a.displayTopNCountries(topCountries);

        // -------------------------
        // Use Case 5
        // -------------------------

        System.out.println(
                "\n========== USE CASE 5: TOP 5 COUNTRIES IN EUROPE ==========\n"
        );

        // Retrieve the top 5 populated countries in Europe.
        ArrayList<Country> topCountriesByContinent =
                a.getTopNCountriesByContinent("Europe", 5);

        // Display the top 5 countries in Europe.
        a.displayTopNCountriesByContinent(topCountriesByContinent);

        // -------------------------
        // Use Case 6
        // -------------------------

        System.out.println(
                "\n========== USE CASE 6: TOP 5 COUNTRIES IN WESTERN EUROPE ==========\n"
        );

        // Retrieve the top 5 populated countries
        // in Western Europe.
        ArrayList<Country> topCountriesByRegion =
                a.getTopNCountriesByRegion("Western Europe", 5);

        // Display the top 5 countries in Western Europe.
        a.displayTopNCountriesByRegion(topCountriesByRegion);

        // -------------------------
        // Use Case 7
        // -------------------------

        System.out.println(
                "\n========== USE CASE 7: CITY REPORT ==========\n"
        );

        // Retrieve all cities ordered from largest
        // population to smallest.
        // ArrayList<City> cities = a.getCities();

        // Display the country population report.
        // a.displayCities(cities);


        // Disconnect from the database.
        a.disconnect();
    }
}