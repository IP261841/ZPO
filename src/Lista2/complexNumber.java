package Lista2;

import java.util.Objects;

public class complexNumber extends vector2D{
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

    public static void main(String[] args) {
        complexNumber z1 = new complexNumber(3, 4);
        complexNumber z2 = new complexNumber(1, 2);
        complexNumber z4 = new complexNumber(3, 4);
        int n = 3;
        System.out.println("Liczba zespolona z1: " + z1);
        System.out.println("Liczba zespolona z2: " + z2);
        System.out.println("Moduł: " + z1.getModulus());
        System.out.println("Argument: " + z1.getArgument() + " radianów");
        System.out.println("Reprezentacja wykładnicza: " + z1.getExponentialForm());
        // Operacje na liczbach zespolonych
        complexNumber sum = z1.add(z2);
        System.out.println("Suma: " + sum);

        complexNumber difference = z1.subtract(z2);
        System.out.println("Różnica: " + difference);

        complexNumber product = z1.multiply(z2);
        System.out.println("Iloczyn: " + product);

        complexNumber quotient = z1.divide(z2);
        System.out.println("Iloraz: " + quotient);

        System.out.println("Potęga " + n + ": " + z1.power(n));

        double modulus = 5;
        double argument = Math.PI / 4;

        complexNumber z3 = complexNumber.fromPolarCoordinates(modulus, argument);
        System.out.println("Liczba zespolona z: " + z3);

        // Porównywanie instancji
        System.out.println("Czy z1 jest równe z4? " + z1.equals(z4));
        System.out.println("Czy z1 jest równe z2? " + z1.equals(z2));
    }
}

