import model.Polynomial;
import util.PolynomialParser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {

    @Test
    public void testAddition() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(2, 3.0);
        terms1.put(0, 2.0);
        Polynomial poly1 = new Polynomial(terms1);

        Map<Integer, Double> terms2 = new HashMap<>();
        terms2.put(1, 4.0);
        terms2.put(0, 3.0);
        Polynomial poly2 = new Polynomial(terms2);

        Polynomial result = poly1.add(poly2);

        assertEquals(5.0, result.getTerms().get(0));
        assertEquals(4.0, result.getTerms().get(1));
        assertEquals(3.0, result.getTerms().get(2));
    }

    @Test
    public void testSubtraction() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(2, 3.0);
        terms1.put(1, 5.0);
        Polynomial poly1 = new Polynomial(terms1);

        Map<Integer, Double> terms2 = new HashMap<>();
        terms2.put(2, 1.0);
        terms2.put(0, 2.0);
        Polynomial poly2 = new Polynomial(terms2);

        Polynomial result = poly1.subtract(poly2);

        assertEquals(2.0, result.getTerms().get(2));
        assertEquals(5.0, result.getTerms().get(1));
        assertEquals(-2.0, result.getTerms().get(0));
    }

    @Test
    public void testMultiplication() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(1, 2.0);
        Polynomial poly1 = new Polynomial(terms1);

        Map<Integer, Double> terms2 = new HashMap<>();
        terms2.put(1, 3.0);
        Polynomial poly2 = new Polynomial(terms2);

        Polynomial result = poly1.multiply(poly2);

        assertEquals(6.0, result.getTerms().get(2));
    }

    @Test
    public void testDerivation() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(3, 3.0);
        terms.put(2, 2.0);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.derive();

        assertEquals(9.0, result.getTerms().get(2));
        assertEquals(4.0, result.getTerms().get(1));
    }

    @Test
    public void testIntegration() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(2, 2.0);
        terms.put(0, 4.0);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.integrate();

        assertEquals(0.6666666666666666, result.getTerms().get(3)); // Assuming precision loss is acceptable
        assertEquals(4.0, result.getTerms().get(1));
    }


    ///new tests
    @Test
    public void testStandardPolynomialAddition() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(3, 2.0);
        terms1.put(2, -4.0);
        terms1.put(1, 6.0);
        terms1.put(0, -8.0);
        Polynomial poly1 = new Polynomial(terms1);

        // Add poly1 to itself as an example
        Polynomial result = poly1.add(poly1);

        assertEquals(4.0, result.getTerms().get(3));
        assertEquals(-8.0, result.getTerms().get(2));
        assertEquals(12.0, result.getTerms().get(1));
        assertEquals(-16.0, result.getTerms().get(0));
    }

    @Test
    public void testFloatingPointPolynomialDerivation() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(4, 3.5);
        terms.put(3, -1.2);
        terms.put(1, 0.5);
        terms.put(0, -0.25);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.derive();

        assertEquals(14.0, result.getTerms().get(3));
        assertEquals(-3.6, result.getTerms().get(2), 0.0001);
        assertEquals(0.5, result.getTerms().get(0), 0.5);
    }

    @Test
    public void testPositiveCoefficientsPolynomialIntegration() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(5, 1.0);
        terms.put(4, 2.0);
        terms.put(3, 3.0);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.integrate();

        assertEquals(0.16666666666666666, result.getTerms().get(6));
        assertEquals(0.4, result.getTerms().get(5));
        assertEquals(0.75, result.getTerms().get(4));
    }

    @Test
    public void testLinearPolynomialMultiplication() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(1, 5.0);
        terms1.put(0, 10.0);
        Polynomial poly1 = new Polynomial(terms1);

        // Multiply poly1 by itself as an example
        Polynomial result = poly1.multiply(poly1);

        // Expected result: 25x^2 + 100x + 100
        assertEquals(25.0, result.getTerms().get(2));
        assertEquals(100.0, result.getTerms().get(1));
        assertEquals(100.0, result.getTerms().get(0));
    }

    @Test
    public void testConstantPolynomialIntegration() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(0, 7.0);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.integrate();

        // Expected result: 7x
        assertEquals(7.0, result.getTerms().get(1));
    }

    @Test
    public void testLeadingNegativeCoefficientPolynomialSubtraction() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(6, -1.0);
        terms1.put(3, 4.0);
        terms1.put(1, -1.0);
        terms1.put(0, 1.0);
        Polynomial poly1 = new Polynomial(terms1);

        // Subtract poly1 from itself as an example
        Polynomial result = poly1.subtract(poly1);

        assertEquals(0.0, result.getTerms().getOrDefault(6, 0.0));
        assertEquals(0.0, result.getTerms().getOrDefault(3, 0.0));
        assertEquals(0.0, result.getTerms().getOrDefault(1, 0.0));
        assertEquals(0.0, result.getTerms().getOrDefault(0, 0.0));
    }

    @Test
    public void testPolynomialWithMissingCoefficientsIntegration() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(4, 1.0);
        terms.put(3, -1.0);
        terms.put(2, 1.0);
        terms.put(1, -1.0);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.integrate();

        assertEquals(0.2, result.getTerms().get(5));
        assertEquals(-0.25, result.getTerms().get(4));
        assertEquals(0.3333333333333333, result.getTerms().get(3));
        assertEquals(-0.5, result.getTerms().get(2));
    }

    @Test
    public void testPolynomialWithSpacesAddition() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(3, 3.0);
        terms1.put(2, -4.0);
        terms1.put(1, 5.0);
        terms1.put(0, -6.0);
        Polynomial poly1 = new Polynomial(terms1);

        // Add poly1 to itself as an example
        Polynomial result = poly1.add(poly1);

        assertEquals(6.0, result.getTerms().get(3));
        assertEquals(-8.0, result.getTerms().get(2));
        assertEquals(10.0, result.getTerms().get(1));
        assertEquals(-12.0, result.getTerms().get(0));
    }

    @Test
    public void testZeroPolynomialMultiplication() {
        Map<Integer, Double> terms1 = new HashMap<>();
        terms1.put(0, 0.0);
        Polynomial poly1 = new Polynomial(terms1);

        Map<Integer, Double> terms2 = new HashMap<>();
        terms2.put(2, 3.0);
        terms2.put(1, 2.0);
        terms2.put(0, 1.0);
        Polynomial poly2 = new Polynomial(terms2);

        Polynomial result = poly1.multiply(poly2);

        assertEquals(0.0, result.getTerms().getOrDefault(2, 0.0));
        assertEquals(0.0, result.getTerms().getOrDefault(1, 0.0));
        assertEquals(0.0, result.getTerms().getOrDefault(0, 0.0));
    }

    @Test
    public void testPolynomialWithAllPositiveTermsDerivation() {
        Map<Integer, Double> terms = new HashMap<>();
        terms.put(2, 1.0);
        terms.put(1, 2.0);
        terms.put(0, 3.0);
        Polynomial poly = new Polynomial(terms);

        Polynomial result = poly.derive();

        assertEquals(2.0, result.getTerms().get(1));
        assertEquals(2.0, result.getTerms().get(0));
    }






}
