# USE CASE: 19 Produce a Report of all the capital cities in a region organised by largest to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of all the capital cities in a region organised by largest to smallest* so that *I can identify and compare the population of the organisation report.*

### Scope

Cities Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country, region, and population information.

### Success End Condition

A report containing all the capital cities in the world organised by largest to smallest.

### Failed End Condition

No capital cities report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of all the capital cities in a specific region organised by largest to smallest.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of all the capital cities in the region organised by largest to smallest.
2. The employee specifies the capital cities.
3. The system retrieves all capital cities in a region from largest to smallest in the database.
4. The system orders the capital cities from largest to smallest in a region.
5. The system generates a region capital cities report.
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
   1. The system cannot find the specified capital cities.
   2. The employee is informed that the capital cities does not exist.

3. **No capital cities data is available for the region report**:
   1. The system finds no capital cities belonging to the region.
   2. The employee is informed that no cities information is available.

3a. **Database information cannot be retrieved**:
1. The system cannot retrieve the required cities information.
2. The employee is informed that the report cannot be produced.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026