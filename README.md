# Adao Enrollment System

A Java console-based enrollment management system built with Interface-Driven Architecture. Submitted as the final Capstone Project for the Bachelor of Science in Information Technology program at De La Salle Lipa.

## Features

### Core Functionality
- **Student Management** — Add, display, update, and remove students.
- **Instructor Management** — Full CRUD plus assignment of instructors to sections.
- **Course Management** — Add, display, update, and remove courses.
- **Department & Section Management** — Create departments and add sections with maximum capacity limits.
- **Enrollment** — Enroll students into sections with automatic capacity validation.
- **Tuition Fee Management** — Calculate fees per unit, process payments, view balances, check fully-paid status.
- **Department Hierarchy View** — Inspect Department → Section → Instructor + Students at a glance.

### Architecture
The codebase strictly separates data, contracts, and behavior into distinct packages:

| Package | Purpose |
|---|---|
| `entities/` | Pure data classes (`Person`, `Student`, `Instructor`, `Course`, `Section`, `Department`, `TuitionFeePayment`) |
| `services/` | Behavior contracts (interfaces only — `IStudentService`, `IInstructorService`, etc.) |
| `impl/` | Concrete service implementations |
| `exceptions/` | Custom checked exceptions |
| `tests/` | JUnit 5 unit tests |

### Custom Exceptions
- **`SectionFullException`** — Thrown when enrollment is attempted in a section at maximum capacity.
- **`DuplicateIdException`** — Thrown when adding a student, instructor, or course with an existing ID.

In both cases, the CLI catches the exception and displays a friendly error message — keeping business validation in the service layer and presentation in the CLI.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Open `src/Main.java`.
3. Click the green ▶ Run arrow next to `public static void main`.
4. Use the numbered menu in the console. Press `0` to exit any menu.

The program seeds sample data on startup so all features can be exercised immediately without manual setup.

## How to Run the Tests

1. Right-click the `tests` package in the project tree.
2. Select **Run 'Tests in 'tests''**.
3. All 6 JUnit tests across 3 test classes should pass.

## Bonus Features Implemented

- **JUnit 5 Unit Testing** — 6 passing tests covering capacity validation, tuition calculation (with and without discount), overpayments, and duplicate ID rejection.
- **Robust Input Validation** — Numeric input parsing wrapped in try-catch loops; the program never crashes on non-numeric input. Duplicate IDs are rejected via custom checked exception.
- **Git Mastery** — Feature-branch workflow with descriptive Pull Requests for every feature. Conventional, imperative-mood commit messages throughout the project history.

## Author
[Your Full Name]
De La Salle Lipa — BS Information Technology