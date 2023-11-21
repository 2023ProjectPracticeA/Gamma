package step6_G3;

import java.util.Random;

public class PolynomialEquation implements EqSolver {
    private double[] coefficients;
    private double[] solutions;

    private static final double EPSILON = 1e-7;

    public PolynomialEquation(double[] coefficients) {
        this.coefficients = coefficients;
        this.solutions = new double[coefficients.length - 1];
    }

    private double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    private double derivative(double x) {
        double result = 0;
        for (int i = 1; i < coefficients.length; i++) {
            result += i * coefficients[i] * Math.pow(x, i - 1);
        }
        return result;
    }

    @Override
    public void solve() {
        for (int i = 0; i < solutions.length; i++) {
            Random rand = new Random();
    
            double x0 = rand.nextDouble() * Double.MAX_VALUE;
            if (rand.nextBoolean()) {
                x0 *= -1;
            }
            double x1;

            while (true) {
                double f = evaluate(x0);
                double fPrime = derivative(x0);

                x1 = x0 - f / fPrime;

                if (Math.abs(x1 - x0) < EPSILON) {
                    break;
                }

                x0 = x1;
            }

            solutions[i] = x1;
        }
    }

    @Override
    public void dispEq() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            System.out.print(coefficients[i] + "x" + ProgG32Eqtn2.toSuperscript(i) + (i > 0 ? " + " : ""));
        }
        System.out.println(" = 0");
    }

    @Override
    public void dispAns() {
        System.out.print("解: ");
        for (double solution : solutions) {
            System.out.print(solution + " ");
        }
        System.out.println();
    }
}
