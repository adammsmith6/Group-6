# USE CASE: 12 Produce a Report of the top N populated cities in the world where N is provided by the user.


## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the top N populated cities in the world where N is provided by the user* so that *I can access and compare the populations of the top N cities within the world*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains city and population information.

### Success End Condition

A report of the first N cities within the world, with their respective populations, ordered by largest population to smallest.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the first N cities with the world, ordered by largest to smallest population. Where N is given by the user.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of the first N cities in the world, ordered by population largest to smallest.
2. The employee provides a value for N
3. The employee requests the city population report from the system.
4. The system retrieves the first N cities from the database.
5. The system orders the cities from largest population to smallest.
6. The system generates the city report.
7. The employee receives the completed report.

The City Report contains:

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