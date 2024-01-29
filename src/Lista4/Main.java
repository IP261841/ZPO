package Lista4;

import java.util.Scanner;

public class Main {
    // Klasa reprezentująca wyjątek związany z błędnym inputem
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    // Metoda umożliwiająca pobranie liczby zespolonej od użytkownika
    public static complexNumber readComplexNumber() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę zespoloną w formacie x+iy:");
        String input = scanner.nextLine().trim();

        // Sprawdzanie poprawności formatu
        if (!input.matches("^[-+]?\\d*\\.?\\d*[-+]?(i|j)$")) {
            throw new InvalidInputException("Niepoprawny format liczby zespolonej.");
        }

        // Rozdzielanie części rzeczywistej i urojonej
        String[] parts = input.split("[-+]?\\d*\\.?\\d*[-+]?(i|j)");
        double realPart = parts.length > 0 ? Double.parseDouble(parts[0]) : 0;
        double imagPart = parts.length > 1 ? Double.parseDouble(parts[1] + "1") : 0;

        return new complexNumber(realPart, imagPart);
    }


    public static void main(String[] args) {
        complexNumber z1 = new complexNumber(3, 4);
        complexNumber z2 = new complexNumber(0, 0);


        System.out.println("Liczba zespolona z1: " + z1);
        System.out.println("Liczba zespolona z2: " + z2);

        // Dzielenie przez zero - obsługa wyjątków
        try {
            complexNumber result = z1.divide(z2);
            System.out.println("Wynik dzielenia: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

    }
}
