# Polynomial Calculator

A Java application that allows users to perform mathematical operations on polynomials through a graphical user interface. This calculator supports addition, subtraction, multiplication, derivation, and integration of polynomials.

## Features

- Input polynomials in standard format (e.g., 3x^2 + 2x - 5)
- Perform basic operations:
  - Addition
  - Subtraction
  - Multiplication
- Calculate derivatives
- Calculate integrals
- User-friendly GUI with clear input fields and results display

## Architecture

The application follows the Model-View-Controller (MVC) architecture:

- **Model**: Represents polynomials and defines operations (`Polynomial`, `PolynomialOperations`, `Operation`)
- **View**: Graphical user interface for interaction (`PolynomialCalculatorUI`)
- **Controller**: Handles user actions and connects model with view (`PolynomialController`)

## Implementation Details

### Polynomial Representation

Polynomials are represented using a `Map<Integer, Double>`, where:
- The key is the exponent of a term
- The value is the coefficient of that term

Example: 3x² + 2x - 5 is stored as {2:3.0, 1:2.0, 0:-5.0}

### Key Classes

- **Polynomial**: Implements operations on polynomials (add, subtract, multiply, derive, integrate)
- **PolynomialParser**: Converts string input into polynomial objects
- **PolynomialCalculatorUI**: Manages the graphical interface using Java Swing
- **PolynomialController**: Coordinates operations between UI and model

## How to Use

1. Run the application (`Main.java`)
2. Enter the first polynomial in the "Polynomial 1" field
3. Enter the second polynomial in the "Polynomial 2" field (required only for addition, subtraction, and multiplication)
4. Click the operation button you want to perform
5. View the result in the display area

### Input Format

Polynomials should be entered in the standard format, examples:
- `3x^2 + 2x - 5` (3x² + 2x - 5)
- `x^3 - 4x` (x³ - 4x)
- `5` (constant polynomial)

## Testing

The application includes comprehensive JUnit tests (`PolynomialTest.java`) that verify:
- Polynomial addition
- Polynomial subtraction
- Polynomial multiplication
- Derivation of polynomials
- Integration of polynomials

Tests cover both standard cases and edge cases with different polynomial forms.

## Future Improvements

Potential enhancements for the project:
- Support for division of polynomials
- Calculating polynomial roots
- Handling of rational coefficients
- Improved error handling and user feedback
- Enhanced visualization of polynomial operations
