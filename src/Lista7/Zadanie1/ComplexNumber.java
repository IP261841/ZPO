package Lista7.Zadanie1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.*;
import java.util.Locale;

public class ComplexNumber extends Vector2D {
    public ComplexNumber(double real, double imag) {
        super(real, imag);
    }

    public double getModulus() {
        return Math.sqrt(x * x + y * y);
    }

    public double getArgument() {
        return Math.atan2(y, x);
    }

    public String getExponentialForm() {
        double modulus = getModulus();
        double argument = getArgument();
        return modulus + " * exp(i" + argument + ")";
    }

    public ComplexNumber add(ComplexNumber other) {
        double realResult = this.x + other.x;
        double imagResult = this.y + other.y;
        return new ComplexNumber(realResult, imagResult);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double realResult = this.x - other.x;
        double imagResult = this.y - other.y;
        return new ComplexNumber(realResult, imagResult);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realResult = this.x * other.x - this.y * other.y;
        double imagResult = this.x * other.y + this.y * other.x;
        return new ComplexNumber(realResult, imagResult);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.x * other.x + other.y * other.y;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }

        double realResult = (this.x * other.x + this.y * other.y) / denominator;
        double imagResult = (this.y * other.x - this.x * other.y) / denominator;

        return new ComplexNumber(realResult, imagResult);
    }

    public ComplexNumber power(int n) {
        double modulusPower = Math.pow(getModulus(), n);
        double argumentPower = getArgument() * n;

        double realResult = modulusPower * Math.cos(argumentPower);
        double imagResult = modulusPower * Math.sin(argumentPower);

        return new ComplexNumber(realResult, imagResult);
    }

    public static ComplexNumber fromPolarCoordinates(double modulus, double argument) {
        double x = modulus * Math.cos(argument);
        double y = modulus * Math.sin(argument);
        return new ComplexNumber(x, y);
    }

    public static List<ComplexNumber> readComplexData(String fileName) throws IOException {
        List<ComplexNumber> complexNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            // Skip the first line (title)
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.trim().split("\\s+");

                if (parts.length >= 2) {
                    try {
                        String time = parts[0];
                        String numberStr = parts[1];

                        // Check if the number begins with '-'
                        boolean isNegative = numberStr.startsWith("-");
                        if (isNegative) {
                            // Remove '-' and split the number into real and imaginary parts
                            String[] realImagParts = numberStr.substring(1).replace("i", "").split("([+-])");

                            // Extracting real and imaginary parts
                            String realPartStr = realImagParts[0];
                            String imagPartStr = (realImagParts.length > 1) ? "-" + realImagParts[1] : "0";

                            // Parsing real and imaginary parts
                            double realPart = Double.parseDouble(realPartStr);
                            double imagPart = Double.parseDouble(imagPartStr);

                            // Create the ComplexNumber object
                            ComplexNumber complexNumber = new ComplexNumber(realPart, imagPart);
                            complexNumbers.add(complexNumber);
                        } else {
                            // Split the number into real and imaginary parts
                            String[] realImagParts = numberStr.replace("i", "").split("([+-])");

                            // Extracting real and imaginary parts
                            String realPartStr = realImagParts[0];
                            String imagPartStr = (realImagParts.length > 1) ? realImagParts[1] : "0";

                            // Parsing real and imaginary parts
                            double realPart = Double.parseDouble(realPartStr);
                            double imagPart = Double.parseDouble(imagPartStr);

                            // Create the ComplexNumber object
                            ComplexNumber complexNumber = new ComplexNumber(realPart, imagPart);
                            complexNumbers.add(complexNumber);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing complex number on line " + lineNumber + ": " + line);
                    }
                } else {
                    System.out.println("Invalid format on line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }

        // Print the contents of complexNumbers for debugging
        System.out.println("Read ComplexNumbers size: " + complexNumbers.size());
        System.out.println("Read ComplexNumbers contents: " + complexNumbers);

        return complexNumbers;
    }


    public static void writeTransformedData(List<ComplexNumber> complexNumbers, List<Double> times, String outputFileName) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println("# t mod arg");

            for (int i = 0; i < complexNumbers.size(); i++) {
                ComplexNumber complexNumber = complexNumbers.get(i);
                double time = times.get(i);

                double modulus = complexNumber.getModulus();
                double argument = complexNumber.getArgument();
                writer.printf(Locale.US, "%.5f %.5f %.5f%n", time, modulus, argument);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error writing data to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static ComplexNumber parseComplexNumber(String complexString) {
        complexString = complexString.replaceAll("\\s", "");

        if (!complexString.matches("[-+]?\\d*\\.?\\d*([-+]?i\\d*\\.?\\d*)?")) {
            throw new NumberFormatException("Niepoprawny format liczby zespolonej: " + complexString);
        }

        complexString = complexString.replaceAll("\\+(?![0-9])", "+1");
        complexString = complexString.replaceAll("i(?!\\d)", "i1");

        String[] parts = complexString.split("[-+]?i1?");
        double realPart = 0;
        double imagPart = 0;

        if (parts.length > 0) {
            realPart = Double.parseDouble(parts[0]);
        }

        if (parts.length > 1) {
            imagPart = Double.parseDouble(parts[1]);
        }

        return new ComplexNumber(realPart, imagPart);
    }
    // Method to read times from a file
    public static List<Double> readTimes(String fileName) throws IOException {
        List<Double> times = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }

                try {
                    double time = Double.parseDouble(line.trim().split("\\s+")[0]);
                    times.add(time);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing time on line " + lineNumber + ": " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading times from file: " + e.getMessage());
            e.printStackTrace();
        }

        // Print the contents of times for debugging
        System.out.println("Read Times size: " + times.size());
        System.out.println("Read Times contents: " + times);

        return times;
    }

    @Override
    public String toString() {
        return "(" + x + " + " + y + "i)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ComplexNumber other = (ComplexNumber) obj;
        return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        try {
            List<ComplexNumber> complexNumbers = readComplexData("src/Lista7/Zadanie1/data.dat");
            List<Double> times = readTimes("src/Lista7/Zadanie1/data.dat");
            writeTransformedData(complexNumbers, times, "src/Lista7/Zadanie1/out_data.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
