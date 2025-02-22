package util;

import model.Polynomial;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialParser {
    public static Polynomial parse(String text) {
        Map<Integer, Double> terms = new HashMap<>();
        // Adjusted regex pattern to match valid polynomial parts
        Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d*)x?(\\^\\d+)?");

        // Removing unsupported characters for simplicity in this example
        // In a real scenario, more sophisticated filtering might be needed
        text = text.replaceAll("[^\\dx^+-]", "");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String matchedTerm = matcher.group();
            if (matchedTerm.isEmpty()) continue; // Skip empty matches

            double coefficient = 1.0;
            int exponent = 0;

            // Check if there's an 'x' in the term
            if (matchedTerm.contains("x")) {
                String[] parts = matchedTerm.split("x\\^?");
                if (parts.length > 0 && parts[0].equals("-")) {
                    coefficient = -1.0;
                } else if (parts.length > 0 && !parts[0].isEmpty() && !parts[0].equals("+")) {
                    coefficient = Double.parseDouble(parts[0]);
                }

                // Determine the exponent
                if (parts.length > 1 && !parts[1].isEmpty()) {
                    exponent = Integer.parseInt(parts[1]);
                } else {
                    exponent = 1; // Default exponent value when 'x' is present but no explicit exponent
                }
            } else {
                // No 'x' means it's a constant term; handle it accordingly
                coefficient = Double.parseDouble(matchedTerm);
            }

            terms.merge(exponent, coefficient, Double::sum);
        }

        if (terms.isEmpty()) {
            throw new IllegalArgumentException("Invalid polynomial format");
        }

        return new Polynomial(terms);
    }
}
