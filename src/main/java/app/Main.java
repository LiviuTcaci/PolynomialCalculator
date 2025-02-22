package app;

import ui.PolynomialCalculatorUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PolynomialCalculatorUI::new);
    }
}
