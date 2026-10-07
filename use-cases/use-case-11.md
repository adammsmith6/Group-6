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

A report of all cities within a district, with their respective populations, ordered by largest population to smallest.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of all cities with a district, ordered by largest to smallest population.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of all cities in a district, ordered by population largest to smallest.
2. The employee requests the city population report from the system.
3. The system retrieves all cities within a specific district from the database.
4. The system orders the cities from largest population to smallest.
5. The system generates the city report.
6. The employee receives the completed report.

The City report contains:

- City
- Country
- District
- Population

## EXTENSIONS

1. **Database information cannot be retrieved**:
   1. The system cannot retrieve the required city information.
   2. The employee is informed that the report cannot be produced.

2. **No city data is available**:
   1. The system finds no city records.
   2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 23/11/2026