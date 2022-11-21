package br.com.vericode.data;

import lombok.Data;

@Data
public class Calculator {
    double num1;
    double num2;

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }
}
