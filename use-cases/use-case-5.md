# USE CASE: 5 Produce a Report of the Top N Populated Countries in a Continent

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the top N populated countries in a given continent where N is provided by the user* so that *I can identify and compare the most populated countries within a continent.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country, continent, and population information.

### Success End Condition

A report containing the top N populated countries in the specified continent, ordered from largest population to smallest, is produced.

### Failed End Condition

No country report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the top N populated countries in a specified continent.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of the top N populated countries in a continent.
2. The employee specifies the continent.
3. The employee provides the value of N.
4. The system validates the continent and the value of N.
5. The system retrieves countries belonging to the specified continent from the database.
6. The system orders the countries from largest population to smallest.
7. The system selects the top N countries.
8. The system generates the country report.
9. The employee receives the completed report.

The country report contains:

- Code
- Name
- Continent
- Region
- Population
- Capital

## EXTENSIONS

2. **Continent does not exist**:
    1. The system cannot find the specified continent.
    2. The employee is informed that the continent does not exist.

3. **Invalid value of N is provided**:
    1. The system identifies that N is invalid.
    2. The employee is informed that a valid positive number must be provided.

5. **No country data is available for the continent**:
    1. The system finds no countries belonging to the specified continent.
    2. The employee is informed that no country information is available.

5a. **Database information cannot be retrieved**:
1. The system cannot retrieve the required country information.
2. The employee is informed that the report cannot be produced.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026