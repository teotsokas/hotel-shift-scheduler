# Hotel Shift Scheduler

Personal Java project: the core of a decision support system for hotel staff scheduling. The idea comes from my own experience building weekly shift schedules as a hotel operations supervisor.

## What it does
- Calculates shift duration, including overnight shifts (e.g. 22:00 → 06:00)
- Enforces the 11-hour minimum rest rule between consecutive shifts
- Validates input and rejects invalid data with clear exceptions

## How it's tested
16 automated JUnit 5 tests:
- **Boundary value analysis:** exactly 11 vs 10 hours of rest; hours 0/23 vs -1/24
- **Negative testing:** invalid input must throw the expected exception
- **Edge cases:** overnight shifts, an employee with no shifts
- **Manual mutation testing:** I deliberately introduced bugs and confirmed that a specific test fails each time

## Running the tests
Open the project in IntelliJ IDEA and run `ShiftTest` and `EmployeeTest`.

## Next steps
- Occupancy-based staffing estimation
- Automatic schedule generation
- Spring Boot REST API
