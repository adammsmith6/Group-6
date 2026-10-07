# USE CASE: 11 Produce a Report of All the Cities in a District Organised by Largest Population to Smallest.


## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of all the cities in a district organised by largest population to smallest* so that *I can access and compare the populations of cities within a district.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains city and population information.

### Success End Condition

A report of all cities within a district, with their respective populations, ordered by lrgest population to smallest.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of all cities with a district, ordered by largest to smallest population.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of all countries in the world.
2. The employee requests the country population report from the system.
3. The system retrieves all countries from the database.
4. The system orders the countries from largest population to smallest.
5. The system generates the country report.
6. The employee receives the completed report.

The report contains:

- Code
- Name
- Continent
- Region
- Population
- Capital

## EXTENSIONS

1. **Database information cannot be retrieved**:
   1. The system cannot retrieve the required country information.
   2. The employee is informed that the report cannot be produced.

2. **No country data is available**:
   1. The system finds no country records.
   2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 23/11/2026