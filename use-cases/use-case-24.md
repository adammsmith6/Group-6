# USE CASE: 24 Produce a Report of the population of people, people living in cities, and people not living in cities in each region

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Organisation* I want *to produce a report of the population of people, people living in cities, and people not living in cities in each region* so that *I can compare population distribution across regions.*

### Scope

Population Reporting System.

### Level

Primary task.

### Preconditions

The world database is available and contains country and population information.

### Success End Condition

A report containing the total population, population living in cities, and population not living in cities for each region.

### Failed End Condition

No population report is produced.

### Primary Actor

Organisation Employee.

### Trigger

The organisation requests a report of population information for each region.

## MAIN SUCCESS SCENARIO

1. The organisation requests a report of population information for each region.
2. The system retrieves country and city information from the database.
3. The system calculates the total population for each region.
4. The system calculates the total population living in cities for each region.
5. The system calculates the percentage of the population living in cities for each region.
6. The system calculates the total population not living in cities for each region.
7. The system calculates the percentage of the population not living in cities for each region.
8. The system generates the population report.
9. The employee receives the completed report.

The population report contains:

- Region
- Total Population
- Population Living in Cities
- Percentage of Population Living in Cities
- Population Not Living in Cities
- Percentage of Population Not Living in Cities

## EXTENSIONS

2. **Database information cannot be retrieved**:
    1. The system cannot retrieve the required country and city information.
    2. The employee is informed that the report cannot be produced.

2a. **No country or city data is available**:
1. The system finds no relevant country or city records.
2. The employee is informed that no population information is available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: 12/10/2026