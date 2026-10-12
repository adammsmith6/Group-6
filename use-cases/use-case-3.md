# USE CASE: 3 Produce a Report of All Countries in a Region by Population

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of all the countries in a given region organised from largest population to smallest* so that *I can access accurate population information for organisational reporting.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country, region, and population information.

### Success End Condition

A report of all countries in the specified region, ordered from largest population to smallest, is produced.

### Failed End Condition

No country report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of all countries in a specified region ordered by population.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of all countries in a region.
2. The employee specifies the region.
3. The system retrieves all countries belonging to the specified region from the database.
4. The system orders the countries from largest population to smallest.
5. The system generates the country report.
6. The employee receives the completed report.

The country report contains:

- Code
- Name
- Continent
- Region
- Population
- Capital

## EXTENSIONS

2. **Region does not exist**:
    1. The system cannot find the specified region.
    2. The employee is informed that the region does not exist.

3. **No country data is available for the region**:
    1. The system finds no countries belonging to the specified region.
    2. The employee is informed that no country information is available.

3a. **Database information cannot be retrieved**:
1. The system cannot retrieve the required country information.
2. The employee is informed that the report cannot be produced.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026