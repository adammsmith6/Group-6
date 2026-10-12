# USE CASE: 27 Produce a Report of the population of a continent

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the population of a continent* so that *I can gain a specific continent's population.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report containing the total population of a continent

### Failed End Condition

No population report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of population information for a given continent.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of population information for each country.
2. A specific continent is supplied by the organisation.
3. The system retrieves country and population information from the database.
4. The system calculates the total population for each country within the given continent.
5. The system creates a summation of these populations.
6. The system generates the population report.
7. The employee receives the completed report.

The population report contains:

- Country
- Total Population

## EXTENSIONS

1. **Database information cannot be retrieved**:
   1. The system cannot retrieve the required city information.
   2. The employee is informed that the report cannot be produced.

2. **No country data is available**:
   1. The system finds no country records.
   2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026