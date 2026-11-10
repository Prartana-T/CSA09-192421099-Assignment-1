# Campus Smart-Parking System — Assignment 1 (CO1)

**Student:** Prartana T  
**Register Number:** 192421099  
**Course:** Programming in Java  
**Repository:** `CSA09-192421099-Assignment1`

## Requirements
- JDK 17 or later (the code uses modern Java pattern matching for `instanceof`).
- Terminal / Command Prompt.

## Project structure
- `src/smartparking/` — complete object-oriented parking system.
- `Task03_CompleteCode/` — completed `ParkingFacility` exercise from the PPT.
- `Task08_CompleteCode/` — completed `FeeDemo` exercise from the PPT.
- `report/` — assignment report.
- `tests/` — test plan.

## Compile and run the main system
From the repository root:

```bash
javac -d out src/smartparking/*.java
java -cp out smartparking.Main
```

## Run Complete the Code programs
```bash
javac -d out Task03_CompleteCode/ParkingFacility.java
java -cp out ParkingFacility

javac -d out Task08_CompleteCode/FeeDemo.java
java -cp out FeeDemo
```

## Design summary
The implementation uses a jagged array to represent floors with different slot counts, an abstract `Vehicle` superclass, specialized subclasses, a `Chargeable` interface, validated constructors, encapsulated fields, a static ticket counter, and a `HashMap` for active tickets. Student/staff monthly passes and visitor day passes are free in the model; ordinary visitors are charged according to vehicle type and duration.

## Submission checklist
- [ ] Replace/confirm student details on the report cover page.
- [ ] Compile and run every Java program locally.
- [ ] Capture genuine output screenshots and place them in the relevant task folders.
- [ ] Update test results with actual outputs from your machine.
- [ ] Create GitHub repository `CSA09-192421099-Assignment1`.
- [ ] Push all files and verify repository visibility.
- [ ] Paste the repository URL into Google Classroom.

**Note:** GitHub publishing must be performed while signed into the student's GitHub account. This package is prepared locally and does not claim to have been uploaded.
