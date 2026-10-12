# USE CASE: 8 As an organisation I want to produce a report of all the cities in a continent organised by largest population to smallest.


## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report of all the cities in a continent organised by largest population to the smallest so that I can see a list of all the cities in a continent organised by population.
### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report of all the cities in a continent organised by population from largest to smallest is produced.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of all the cities in a continent organised by population largest to smallest.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of all the cities in a continent organised by population largest to smallest.
2. The employee specifies a continent.
2. The system retrieves all cities belonging to the specified continent from the database.
3. The system orders the cities from the largest population to smallest.
4. The system generates the city population report.
5. The employee receives the completed report.

The report contains:

- City Name
- Population

## EXTENSIONS

1. **Database information cannot be retrieved**:
   1. The system cannot retrieve the required city information.
   2. The employee is informed that the report cannot be produced.

2. **No city data is available**:
   1. The system finds no city records.
   2. The employee is informed that no city information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 23/11/2026