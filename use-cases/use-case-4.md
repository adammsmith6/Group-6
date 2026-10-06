# USE CASE: 4 Produce a Report of the Top N Populated Countries in the World

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the top N populated countries in the world where N is provided by the user* so that *I can identify and compare the most populated countries in the world.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report containing the top N populated countries in the world, ordered from largest population to smallest, is produced.

### Failed End Condition

No country report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the top N populated countries in the world.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of the top N populated countries in the world.
2. The employee provides the value of N.
3. The system validates the value of N.
4. The system retrieves country information from the database.
5. The system orders the countries from largest population to smallest.
6. The system selects the top N countries.
7. The system generates the country report.
8. The employee receives the completed report.

The country report contains:

- Code
- Name
- Continent
- Region
- Population
- Capital

## EXTENSIONS

2. **Invalid value of N is provided**:
    1. The system identifies that N is invalid.
    2. The employee is informed that a valid positive number must be provided.

4. **Database information cannot be retrieved**:
    1. The system cannot retrieve the required country information.
    2. The employee is informed that the report cannot be produced.

4a. **No country data is available**:
1. The system finds no country records.
2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026