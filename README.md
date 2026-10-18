# Hotel Shift Scheduler

A personal Java project: the core of a staff scheduling system for hotels.
The idea comes from my own experience building weekly shift schedules
as a hotel operations supervisor.

## What it does so far
- `Shift`: represents a work shift and validates its times and duration.
- `Employee`: represents a staff member and validates their data.
- Rest-time rule: checks the minimum rest between two consecutive shifts.
- Unit tests with JUnit 5, including boundary-value cases.

## Planned
- Estimating staff needs from hotel occupancy
- Building and adjusting a weekly schedule automatically
- Storing data in a SQL database

## Running the tests
Open the project in IntelliJ IDEA and run the tests in `ShiftTest` and `EmployeeTest`.

## Author
Thodoris Tsokas, github.com/teotsokas
