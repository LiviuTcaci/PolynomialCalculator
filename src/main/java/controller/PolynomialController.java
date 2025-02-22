package controller;

import model.Polynomial;
import model.Operation;

public class PolynomialController {
    // Methods to perform operations on polynomials
    public Polynomial performOperation(Polynomial poly1, Polynomial poly2, Operation operation) {
        // Switch case to handle different operations
        switch (operation) {
            case ADD:
                return poly1.add(poly2);
            case SUBTRACT:
                return poly1.subtract(poly2);
            case MULTIPLY:
                return poly1.multiply(poly2);
            case DERIVE:
                return poly1.derive();
            case INTEGRATE:
                return poly1.integrate();

            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
