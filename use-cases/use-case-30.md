# USE CASE: 30 Produce a Report of the population of a district

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the population of a district* so that *I can gain a specific district's population.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains city and population information.

### Success End Condition

A report containing the total population of a district

### Failed End Condition

No population report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of population information for a given district.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of population information for each city (City Table).
2. A specific district is supplied by the organisation.
3. The system retrieves city and population information from the City Table within the database.
4. The system creates a summation of the populations of all cities for this specific district.
5. The system generates the population report.
6. The employee receives the completed report.

The population report contains:

- District
- Total Population

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

**DUE DATE**: 12/10/2026