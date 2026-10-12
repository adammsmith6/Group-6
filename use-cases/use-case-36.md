# USE CASE: 36 Produce a Report of the number of people who speak Arabic from greatest to smallest, including the percentage of the world population

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the number of people who speak Arabic from greatest to smallest, including the percentage of the world population* so that *I can compare this language's count compared the world count, and see which countries have which number*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and language information.

### Success End Condition

A report containing the number of people who speak Arabic from greatest to smallest, including the percentage of the world population

### Failed End Condition

No language report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the number of people who speak Arabic from greatest to smallest, including the percentage of the world population

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of language information for each country.
2. The system retrieves country and language information from the CountryLanguage table within the database.
3. The system calculates the total population for each country that speak Arabic.
4. The system calculates the percentage of these speakers compared to the world population.
5. The system generates the population report.
6. The employee receives the completed report.

The population report contains:

- Country
- Language
- Percentage of these speakers compared to the world population

## EXTENSIONS

1. **Database information cannot be retrieved**:
   1. The system cannot retrieve the required city information.
   2. The employee is informed that the report cannot be produced.

2. **No language data is available**:
   1. The system finds no language records.
   2. The employee is informed that no language information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026