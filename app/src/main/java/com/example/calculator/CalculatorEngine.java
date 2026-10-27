package com.example.calculator;

import java.math.BigDecimal;

public class CalculatorEngine {
    private static final int MAX_INPUT_LENGTH = 15;
    private static final String ZERO = "0";

    private String input = ZERO;
    private String currentSign;

    public void add() {
        currentSign = "+";
    }

    public void calculate() {
        if (currentSign == "+") {

             }
    }

    public void inputDigit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("цифра должна быть в 0..9: " + digit);
        }
        // prepareForInput()
        if (digitCount() < MAX_INPUT_LENGTH) {
            input = input.equals(ZERO) ? String.valueOf(digit) : input + digit;
        }
    }

    public String getDisplay() {
        return input;
    }

    private int digitCount() {
        return (int) input.chars().filter(Character::isDigit).count();
    }
}
