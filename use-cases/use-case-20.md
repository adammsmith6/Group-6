# USE CASE: 20 Produce a Report of the Top N Populated capital cities in the world where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the top N populated capital cities in the world where N is provided by the user* so that *I can identify and compare the most populated capital cities in the world.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report containing the top N populated capital cities in the world where N is provided by the user.

### Failed End Condition

No capital city report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the top N populated capital cities in the world.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of the top N populated cities in the world.
2. The employee provides the value of N.
3. The system validates the value of N.
4. The system retrieves country information from the database.
5. The system selects the top N capital cities.
6. The system generates the capital city report.
7. The employee receives the completed report.

The city report contains:

- Code
- Name
- Continent
- Region
- Population
- Capital

## EXTENSIONS

2. **Invalid value of N is provided**:
    1. The system identifies that N is invalid.
    2. The employee is informed that a valid positive number must be provided.

4. **Database information cannot be retrieved**:
    1. The system cannot retrieve the required country information.
    2. The employee is informed that the report cannot be produced.

4a. **No country data is available**:
1. The system finds no country records.
2. The employee is informed that no country information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026