# Polynomial Calculator
This repository contains the source code and documentation for Assignment 1 of the Fundamental Programming Techniques course. The Polynomial Calculator is a Java-based application designed to perform various operations on polynomials—including addition, subtraction, multiplication, derivation, and integration—via a user-friendly graphical interface built with Java Swing.

## Overview

- **Assignment Objective:**  
  Develop a tool to simplify polynomial operations that are typically complex and time-consuming when done manually.

- **Key Features:**  
  - Input of polynomials in textual format.
  - Support for multiple operations: addition, subtraction, multiplication, derivation, and integration.
  - MVC architecture separating the model (polynomial operations), view (GUI), and controller (user action handler).
  - Comprehensive error handling and result display in a simplified polynomial format.
  - Unit testing using JUnit to ensure correctness of polynomial operations.

## Project Structure
```
.
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       ├── app
│   │       │   └── Main.java
│   │       ├── controller
│   │       │   └── PolynomialController.java
│   │       ├── model
│   │       │   ├── Operation.java
│   │       │   ├── Polynomial.java
│   │       │   └── PolynomialOperations.java
│   │       ├── ui
│   │       │   └── PolynomialCalculatorUI.java
│   │       └── util
│   │           └── PolynomialParser.java
│   └── test
│       └── java
│           └── PolynomialTest.java
└── README.md
```

## How to Run

1. **Build the Project:**  
   Use Maven to compile and package the application:
   ```bash
   mvn clean install
   ```

	2.	Run the Application:
Execute the main class from the target directory or within your IDE:
`
java -cp target/PT2024_30221_Tcaci_Liviu_Assignment_1-1.0-SNAPSHOT.jar app.Main
`


	4.	Using the Calculator:
	
 •	Enter polynomials in the provided input fields.
	
 •	Select the desired operation (Add, Subtract, Multiply, Derive, or Integrate) by clicking the corresponding button.
	
 •	The result will be displayed in a text area in simplified polynomial format.

Testing

Unit tests have been implemented with JUnit to validate all polynomial operations. To run the tests, execute:
```
mvn test
```

Documentation

For detailed information about the assignment objective, design, implementation, and testing results, please refer to the project documentation included in the repository.
