# USE CASE: 6 As an Organisation I want to produce a report of the top N populated countries in a region where N is provided by the user.


## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report of the top N populated countries in a region where N is provided by the user so that the user can decide how many countries they want in their report.
### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report of the top N (N being specified by the user) populated countries in a region is produced.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of the top N populated countries in a region where the user is able to provide N and choose how many of the top countries they want to be included in the report.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of the top N populated countries in a region where the user is able to provide N thus choosing how many of the top countries they want to be included in the report.
2. The employee specifies the region
3. The employee specifies the number of top countries they want the report to produce (N)
4. The system validates the region and the value of N
5. The system retrieves countries belonging to the specified region from the database.
6. The system orders the countries from largest population to smallest.
7. The system selects the top N countries.
8. The system generates the country report.
9. The employee receives the completed report.

The report contains:

- Country Name
- Region
- Population

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

**DUE DATE**: 23/11/2026