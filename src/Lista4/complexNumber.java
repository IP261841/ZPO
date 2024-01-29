package Lista4;

import java.util.Objects;

public class complexNumber extends vector2D {
    public complexNumber(double real, double imag) {
        super(real, imag);
    }

    public double getModulus() {
        // Moduł liczby zespolonej |z| = sqrt(x^2 + y^2)
        return Math.sqrt(x * x + y * y);
    }

    public double getArgument() {
        // Argument liczby zespolonej φ = atan2(y, x)
        return Math.atan2(y, x);
    }
    public String getExponentialForm() {
        // Reprezentacja wykładnicza liczby zespolonej z = |z| * exp(iφ)
        double modulus = getModulus();
        double argument = getArgument();
        return modulus + " * exp(i" + argument + ")";
    }
    // Metody do operacji na liczbach zespolonych

    public complexNumber add(complexNumber other) {
        double realResult = this.x + other.x;
        double imagResult = this.y + other.y;
        return new complexNumber(realResult, imagResult);
    }

    public complexNumber subtract(complexNumber other) {
        double realResult = this.x - other.x;
        double imagResult = this.y - other.y;
        return new complexNumber(realResult, imagResult);
    }

    public complexNumber multiply(complexNumber other) {
        double realResult = this.x * other.x - this.y * other.y;
        double imagResult = this.x * other.y + this.y * other.x;
        return new complexNumber(realResult, imagResult);
    }

    public complexNumber divide(complexNumber other) {
        double denominator = other.x * other.x + other.y * other.y;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }

        double realResult = (this.x * other.x + this.y * other.y) / denominator;
        double imagResult = (this.y * other.x - this.x * other.y) / denominator;

        return new complexNumber(realResult, imagResult);
    }
    // Metoda do obliczania n-tej potęgi liczby zespolonej
    public complexNumber power(int n) {
        double modulusPower = Math.pow(getModulus(), n);
        double argumentPower = getArgument() * n;

        double realResult = modulusPower * Math.cos(argumentPower);
        double imagResult = modulusPower * Math.sin(argumentPower);

        return new complexNumber(realResult, imagResult);
    }
    // Metoda umożliwiająca ustalenie współrzędnych wektora poprzez reprezentację biegunową
    public static complexNumber fromPolarCoordinates(double modulus, double argument) {
        double x = modulus * Math.cos(argument);
        double y = modulus * Math.sin(argument);
        return new complexNumber(x, y);
    }

    @Override
    public String toString() {
        // Reprezentacja kanoniczna liczby zespolonej z = x + iy
        return "(" + x + " + " + y + "i)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        complexNumber other = (complexNumber) obj;
        return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }



}

