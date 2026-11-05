package Swing;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {

    int boardWidth = 360;
    int boardHeight = 540;

    Color lightgray = new Color(212, 212, 210);
    Color darkgray = new Color(80, 80, 80);
    Color black = new Color(28, 28, 28);
    Color orange = new Color(255, 149, 0);

    String[] buttonValues = {
        "AC", "+/-", "%", "/",
        "7", "8", "9", "*",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "nil", "="
    };

    String[] rightSymbols = {"/", "*", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String A = "0";
    String operator = null;
    String B = null;

    Calculator() {

        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(black);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(black);
        frame.add(buttonsPanel, BorderLayout.CENTER);

        for (int i = 0; i < buttonValues.length; i++) {

            JButton button = new JButton();
            String buttonValue = buttonValues[i];

            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(black));

            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(lightgray);
                button.setForeground(black);
            }
            else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(orange);
                button.setForeground(Color.white);
            }
            else {
                button.setBackground(darkgray);
                button.setForeground(Color.white);
            }

            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton clickedButton = (JButton) e.getSource();
                    String value = clickedButton.getText();

                    if (Arrays.asList(rightSymbols).contains(value)) {

                        if (value.equals("=")) {

                            if (operator != null && A != null) {

                                B = displayLabel.getText();

                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);
                                double result = 0;

                                if (operator.equals("+")) {
                                    result = numA + numB;
                                }
                                else if (operator.equals("-")) {
                                    result = numA - numB;
                                }
                                else if (operator.equals("*")) {
                                    result = numA * numB;
                                }
                                else if (operator.equals("/")) {

                                    if (numB == 0) {
                                        displayLabel.setText("Cannot divide by 0");
                                        clearAll();
                                        return;
                                    }

                                    result = numA / numB;
                                }

                                displayLabel.setText(removezero(result));
                                clearAll();
                            }
                        }
                        else {
                            if (operator == null) {
                                A = displayLabel.getText();
                                displayLabel.setText("0");
                            }

                            operator = value;
                        }
                    }

                    else if (Arrays.asList(topSymbols).contains(value)) {

                        if (value.equals("AC")) {
                            clearAll();
                            displayLabel.setText("0");
                        }
                        else if (value.equals("+/-")) {
                            double number =
                                Double.parseDouble(displayLabel.getText());

                            number = number * -1;
                            displayLabel.setText(removezero(number));
                        }
                        else if (value.equals("%")) {
                            double number =
                                Double.parseDouble(displayLabel.getText());

                            number = number / 100;
                            displayLabel.setText(removezero(number));
                        }
                    }

                    else if (value.equals(".")) {

                        if (!displayLabel.getText().contains(".")) {
                            displayLabel.setText(
                                displayLabel.getText() + "."
                            );
                        }
                    }

                    else if (value.length() == 1 &&
                             "0123456789".contains(value)) {

                        if (displayLabel.getText().equals("0")) {
                            displayLabel.setText(value);
                        }
                        else {
                            displayLabel.setText(
                                displayLabel.getText() + value
                            );
                        }
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    void clearAll() {
        A = "0";
        operator = null;
        B = null;
    }

    String removezero(double number) {

        if (number % 1 == 0) {
            return Integer.toString((int) number);
        }
        else {
            return Double.toString(number);
        }
    }
}
