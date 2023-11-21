package step6_G3;

public class PolynomialEquation implements EqSolver {
    private double[] coefficients;
    private double solution;
    private static final double EPSILON = 1e-7;

    public PolynomialEquation(double[] coefficients) {
        this.coefficients = coefficients;
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
        double x0 = 0;
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

        solution = x1;
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
        System.out.println("解: " + solution);
    }
}
