package model;

public interface PolynomialOperations {
    Polynomial add(Polynomial other);
    Polynomial subtract(Polynomial other);
    Polynomial multiply(Polynomial other);
    Polynomial derive();
    Polynomial integrate();
}
