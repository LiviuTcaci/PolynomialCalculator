package model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Polynomial implements PolynomialOperations {
    private Map<Integer, Double> terms;

    public Polynomial(Map<Integer, Double> terms) {
        this.terms = new HashMap<>(terms);
    }

    public Polynomial add(Polynomial other) {
        Map<Integer, Double> resultTerms = new HashMap<>(this.terms);
        other.terms.forEach((exp, coeff) -> resultTerms.merge(exp, coeff, Double::sum));
        return new Polynomial(resultTerms);
    }


    public Polynomial subtract(Polynomial other) {
        Map<Integer, Double> resultTerms = new HashMap<>(this.terms);
        other.terms.forEach((exp, coeff) -> resultTerms.merge(exp, -coeff, Double::sum));
        return new Polynomial(resultTerms);
    }


    public Polynomial multiply(Polynomial other) {
        Map<Integer, Double> resultTerms = new HashMap<>();

        for (Map.Entry<Integer, Double> thisTerm : this.terms.entrySet()) {
            for (Map.Entry<Integer, Double> otherTerm : other.terms.entrySet()) {
                int newExp = thisTerm.getKey() + otherTerm.getKey();
                double newCoeff = thisTerm.getValue() * otherTerm.getValue();

                // Correctly accumulate coefficients for terms with the same exponent
                resultTerms.merge(newExp, newCoeff, Double::sum);
            }
        }

        return new Polynomial(resultTerms);
    }

    public Polynomial derive() {
        Map<Integer, Double> resultTerms = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : terms.entrySet()) {
            Integer power = entry.getKey();
            Double coefficient = entry.getValue();
            if (power > 0) {
                resultTerms.put(power - 1, power * coefficient);
            }
        }
        return new Polynomial(resultTerms);
    }

    public Polynomial integrate() {
        Map<Integer, Double> resultTerms = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : terms.entrySet()) {
            Integer power = entry.getKey();
            Double coefficient = entry.getValue();
            resultTerms.put(power + 1, coefficient / (power + 1));
        }
        return new Polynomial(resultTerms);
    }

    @Override
    public String toString() {
        if (terms.isEmpty()) {
            return "0";
        }

        DecimalFormat format = new DecimalFormat("0.0###");
        StringBuilder builder = new StringBuilder();
        terms.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByKey().reversed())
                .forEach(entry -> {
                    if (builder.length() > 0) builder.append(" + ");
                    double coeff = entry.getValue();
                    int exp = entry.getKey();
                    if (coeff < 0) {
                        builder.append("- ");
                        coeff = -coeff;
                    }
                    String formattedCoeff = format.format(coeff).replaceAll("([.][0-9]*[1-9])0+$|([.]0*$)", "$1");
                    if (exp > 0) {
                        builder.append(formattedCoeff).append(exp > 1 ? "x^" + exp : "x");
                    } else {
                        builder.append(formattedCoeff);
                    }
                });
        return builder.toString().replace("+ -", "- ");
    }



    public Map<Integer, Double> getTerms() {
        return terms;
    }

    public void setTerms(Map<Integer, Double> terms) {
        this.terms = terms;
    }
}
