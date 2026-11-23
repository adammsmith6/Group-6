
package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Represents language information and handles
 * the language speakers report.
 *
 * Use Case 32.
 */
public class Language
{
    // Name of the language.
    public String name;

    // Estimated number of people speaking the language.
    public long speakers;

    // Percentage of the world's population
    // speaking the language.
    public double worldPercentage;

    // Database connection.
    private Connection con;

    /**
     * Constructor for creating individual language records.
     */
    public Language()
    {
    }

    /**
     * Constructor for retrieving language reports.
     *
     * @param connection Active MySQL database connection.
     */
    public Language(Connection connection)
    {
        this.con = connection;
    }

    // -------------------------
    // Use Case 32 - Language Speakers
    // -------------------------

    /**
     * Retrieves the number of speakers for Chinese,
     * English, Hindi, Spanish, and Arabic.
     *
     * Results are ordered from the greatest number
     * of speakers to the smallest.
     *
     * @return List of language records, or null
     *         if retrieval fails.
     */
    public ArrayList<Language> getLanguages()
    {
        // Check the database connection.
        if (con == null)
        {
            System.out.println("Database connection unavailable.");
            return null;
        }

        try
        {
            // Calculate the number of speakers in each language.
            // Country population is multiplied by the percentage
            // of people speaking that language.
            //
            // Divide by 100 because Percentage is stored
            // as a percentage rather than a fraction.
            //
            // WorldPopulation is calculated separately to
            // avoid counting countries multiple times.
            String sql =
                    "SELECT cl.Language AS Name, " +
                            "ROUND(SUM(c.Population * cl.Percentage / 100.0)) AS Speakers, " +
                            "ROUND( " +
                            "SUM(c.Population * cl.Percentage / 100.0) " +
                            "* 100.0 / world.WorldPopulation, 2 " +
                            ") AS WorldPercentage " +
                            "FROM countrylanguage cl " +
                            "JOIN country c ON cl.CountryCode = c.Code " +
                            "CROSS JOIN ( " +
                            "SELECT SUM(Population) AS WorldPopulation " +
                            "FROM country " +
                            ") world " +
                            "WHERE cl.Language IN (?, ?, ?, ?, ?) " +
                            "GROUP BY cl.Language, world.WorldPopulation " +
                            "ORDER BY Speakers DESC";

            // Create a prepared statement.
            try (PreparedStatement stmt = con.prepareStatement(sql))
            {
                // Set the five required languages.
                stmt.setString(1, "Chinese");
                stmt.setString(2, "English");
                stmt.setString(3, "Hindi");
                stmt.setString(4, "Spanish");
                stmt.setString(5, "Arabic");

                // Execute the query.
                try (ResultSet rset = stmt.executeQuery())
                {
                    // Store language records.
                    ArrayList<Language> languages = new ArrayList<>();

                    // Process each returned row.
                    while (rset.next())
                    {
                        // Create a language object.
                        Language language = new Language();

                        // Store the language name.
                        language.name = rset.getString("Name");

                        // Store the estimated speakers.
                        language.speakers = rset.getLong("Speakers");

                        // Store the world population percentage.
                        language.worldPercentage =
                                rset.getDouble("WorldPercentage");

                        // Add the language record to the list.
                        languages.add(language);
                    }

                    // Return the completed list.
                    return languages;
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language information.");

            return null;
        }
    }

    /**
     * Displays the language speakers report.
     *
     * @param languages List of language records.
     */
    public void displayLanguages(ArrayList<Language> languages)
    {
        // Check whether retrieval failed.
        if (languages == null)
        {
            System.out.println("No language information available.");
            return;
        }

        // Check whether the list is empty.
        if (languages.isEmpty())
        {
            System.out.println("No language records found.");
            return;
        }

        // Display the report headings.
        System.out.printf(
                "%-25s %-25s %-20s%n",
                "Language",
                "Number of Speakers",
                "World Population %"
        );

        // Display each language record.
        for (Language language : languages)
        {
            System.out.printf(
                    "%-25s %-25,d %-20.2f%n",
                    language.name,
                    language.speakers,
                    language.worldPercentage
            );
        }
    }
}

