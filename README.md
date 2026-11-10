Campus Smart-Parking System

Programming in Java – Assignment 1

Name: Prartana T
Register Number: 192421099
Course: Programming in Java

About the Project

This project is a Campus Smart-Parking System developed using Java. It is designed to manage parking spaces for different types of vehicles such as two-wheelers, cars and electric vehicles.

The system allows vehicles to enter and exit the parking area, assigns available parking slots, generates parking tickets and calculates parking fees based on the vehicle type and parking duration.

It also supports student and staff monthly passes, visitor day passes and additional features such as electric bikes and delivery vans.

Technologies Used

Java

Object-Oriented Programming

Collections Framework

Arrays and HashMap

Project Structure

src/smartparking/ – Main parking system source code.

Task01 to Task12 – Individual assignment tasks.

Task03_CompleteCode/ – ParkingFacility program.

Task08_CompleteCode/ – FeeDemo program.

report/ – Assignment report and UML diagram.

tests/ – Test cases and test results.

How to Run

Make sure Java JDK is installed on your system.

1. Compile the main program

javac -d out src/smartparking/*.java

2. Run the program

java -cp out smartparking.Main

Running the Individual Programs

Task 3 – Parking Facility

javac -d out Task03_CompleteCode/ParkingFacility.java
java -cp out ParkingFacility

Task 8 – Vehicle Fee Calculation

javac -d out Task08_CompleteCode/FeeDemo.java
java -cp out FeeDemo

Testing

The project was tested for vehicle entry, duplicate registration, parking slot availability, parking fee calculation and vehicle exit.

Additional test cases were performed for the Task 12 features, including e-bike fees, delivery van charges, visitor day passes and five-floor parking allocation.
