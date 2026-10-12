# USE CASE: 22 Produce a Report of the Top N Populated capital cities in a region where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the top N populated capital cities in a region where N is provided by the user* so that *I can identify and compare the most populated capital cities within a region.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report containing the top N populated capital cities in a region where N is provided by the user.

### Failed End Condition

No capital city report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the top N populated capital cities in a region.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of the top N populated capital cities in a region.
2. The employee provides the region and the value of N.
3. The system validates the region and the value of N.
4. The system retrieves country information from the database.
5. The system selects the top N populated capital cities within the specified region.
6. The system generates the capital city report.
7. The employee receives the completed report.

The capital city report contains:

- Name
- Country
- Population

## EXTENSIONS

2. **Invalid value of N is provided**:
    1. The system identifies that N is invalid.
    2. The employee is informed that a valid positive number must be provided.

2a. **Invalid region is provided**:
1. The system identifies that the region is invalid.
2. The employee is informed that a valid region must be provided.

4. **Database information cannot be retrieved**:
    1. The system cannot retrieve the required country information.
    2. The employee is informed that the report cannot be produced.

4a. **No country data is available**:
1. The system finds no country records for the specified region.
2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026