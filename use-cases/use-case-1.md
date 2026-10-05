# USE CASE: 1 Produce a Report of All Countries in the World by Population

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of all the countries in the world organised from largest population to smallest* so that *I can access accurate population information for organisational reporting.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report of all countries, ordered from largest population to smallest, is produced.

### Failed End Condition

No country report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of all countries ordered by population.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of all countries in the world.
2. The employee requests the country population report from the system.
3. The system retrieves all countries from the database.
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

3. **Database information cannot be retrieved**:
   1. The system cannot retrieve the required country information.
   2. The employee is informed that the report cannot be produced.

3a. **No country data is available**:
1. The system finds no country records.
2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0