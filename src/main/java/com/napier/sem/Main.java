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

        // Retrieve all countries ordered from largest
        // population to smallest.
        ArrayList<Country> countries = a.getCountries();

        // Display the country population report.
        a.displayCountries(countries);

        // Disconnect from the database.
        a.disconnect();
    }
}