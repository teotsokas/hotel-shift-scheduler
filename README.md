# Hotel Shift Scheduler (Java)

Core domain model of a **decision support system for hotel staff scheduling**, developed as part of my BSc thesis in Computer Science at the Aristotle University of Thessaloniki.

The goal of the full system is to estimate staffing needs from hotel occupancy and automatically build and adjust shift schedules that respect labour rules. This repository contains the first building blocks.

## What it does so far

**`Shift`**
- Calculates shift duration, including overnight shifts (e.g. 22:00 → 06:00 = 8 hours)
- Checks the **11-hour minimum rest** rule between consecutive shifts
- Validates input: hours must be 0–23 and start ≠ end, otherwise an `IllegalArgumentException` with a clear message is thrown

**`Employee`**
- Keeps the list of assigned shifts
- Calculates total weekly hours
- Checks that **every pair of consecutive shifts** respects the minimum rest rule
- Rejects a non-positive hourly rate

## Testing

16 automated **JUnit 5** tests (`ShiftTest`, `EmployeeTest`), designed with a QA mindset:

- **Boundary value analysis**: exactly 11 hours of rest (valid) vs 10 (invalid); hours 0 and 23 (accepted) vs -1 and 24 (rejected)
- **Negative testing**: invalid input must throw the expected exception
- **Edge cases**: overnight shifts, a shift starting at midnight, an employee with no shifts
- **Mutation testing (manual)**: the test suite was verified by deliberately introducing bugs (e.g. `>=` → `>`, off-by-one in the loop) and confirming that a specific test fails each time

## How to run

Open the project in IntelliJ IDEA (JDK 17+), then right-click the `src` folder → **Run 'All Tests'**.

## Next steps

- Occupancy-based estimation of staffing needs per day and department
- Automatic schedule generation and rescheduling when an employee is absent
- REST API (Spring Boot) and database persistence
