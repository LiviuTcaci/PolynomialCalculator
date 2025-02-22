package ui;

import controller.PolynomialController;
import model.Operation;
import model.Polynomial;
import util.PolynomialParser;

import javax.swing.*;
import java.awt.*;

public class PolynomialCalculatorUI extends JFrame {
    public JTextField inputPolynomial1 = new JTextField(20);
    public JTextField inputPolynomial2 = new JTextField(20);
    public JTextArea resultArea = new JTextArea(5, 20);
    private PolynomialController controller = new PolynomialController();

    public PolynomialCalculatorUI() {
        createUI();
        setTitle("Polynomial Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createUI() {
        setLayout(new FlowLayout());

        // Add components
        add(new JLabel("Polynomial 1:"));
        add(inputPolynomial1);
        add(new JLabel("Polynomial 2:"));
        add(inputPolynomial2);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> performOperation(Operation.ADD));
        add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(e -> performOperation(Operation.SUBTRACT));
        add(subtractButton);

        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(e -> performOperation(Operation.MULTIPLY));
        add(multiplyButton);

        JButton deriveButton = new JButton("Derive");
        deriveButton.addActionListener(e -> performOperation(Operation.DERIVE));
        add(deriveButton);

        JButton integrateButton = new JButton("Integrate");
        integrateButton.addActionListener(e -> performOperation(Operation.INTEGRATE));
        add(integrateButton);

        add(new JScrollPane(resultArea));
    }

    public void performOperation(Operation operation) {
        Polynomial poly1 = PolynomialParser.parse(inputPolynomial1.getText());
        Polynomial result;

        switch (operation) {
            case DERIVE:
            case INTEGRATE:
                result = operation == Operation.DERIVE ? poly1.derive() : poly1.integrate();
                break;
            default:
                Polynomial poly2 = PolynomialParser.parse(inputPolynomial2.getText());
                result = controller.performOperation(poly1, poly2, operation);
                break;
        }

        resultArea.setText(result.toString());
    }

}
