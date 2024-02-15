package Projekt;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FootballMatchApp {
    private static final String FILENAME = "match.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w aplikacji do zarządzania meczami piłkarskimi!");

        while (true) {
            System.out.println("\nCo chcesz zrobić?");
            System.out.println("1. Dodaj nowe mecze");
            System.out.println("2. Wyświetl istniejące mecze");
            System.out.println("3. Wyjdź z programu");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addMatches(scanner);
                        break;
                    case 2:
                        displayMatchesFromFile(FILENAME);
                        break;
                    case 3:
                        System.out.println("Dziękujemy za skorzystanie z aplikacji!");
                        return;
                    default:
                        System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawne dane wejściowe. Wprowadź liczbę od 1 do 3.");
            }
        }
    }



    public static void addMatches(Scanner scanner) {
        List<FootballMatch> matches = new ArrayList<>();
        boolean addAnotherMatch = true;

        while (addAnotherMatch) {
            try {
                System.out.println("Podaj nazwę drużyny gospodarzy:");
                String homeTeam = scanner.nextLine();

                System.out.println("Podaj nazwę drużyny gości:");
                String awayTeam = scanner.nextLine();

                System.out.println("Podaj wynik drużyny gospodarzy:");
                int homeScore = Integer.parseInt(scanner.nextLine());

                System.out.println("Podaj wynik drużyny gości:");
                int awayScore = Integer.parseInt(scanner.nextLine());

                System.out.println("Podaj typ rozgrywek (liga, puchar krajowy, puchar kontynentalny):");
                String competitionType = scanner.nextLine();

                System.out.println("Podaj sezon:");
                String season = scanner.nextLine();

                FootballMatch match = new FootballMatch(homeTeam, awayTeam, homeScore, awayScore, competitionType, season);
                matches.add(match);

                System.out.println("Czy chcesz dodać kolejny mecz? (T/N)");
                String choice = scanner.nextLine().toUpperCase();
                addAnotherMatch = choice.equals("T");
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawne dane wejściowe. Wprowadź liczbę.");
            }
        }

        saveMatchesToFile(matches, FILENAME);
        System.out.println("Mecze zostały dodane!");
    }

    public static void displayMatchesFromFile(String filename) {
        List<FootballMatch> matches = readMatchesFromFile(filename);
        if (matches != null && !matches.isEmpty()) {
            for (FootballMatch match : matches) {
                System.out.println("\nDrużyna gospodarzy: " + match.getHomeTeam());
                System.out.println("Drużyna gości: " + match.getAwayTeam());
                System.out.println("Wynik: " + match.getHomeScore() + " - " + match.getAwayScore());
                System.out.println("Typ rozgrywek: " + match.getCompetitionType());
                System.out.println("Sezon: " + match.getSeason());
            }
        } else {
            System.out.println("Brak zapisanych meczów.");
        }
    }


    public static void saveMatchesToFile(List<FootballMatch> matches, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (FootballMatch match : matches) {
                fileWriter.write(match.toJSON().toString() + "\n");
            }
        } catch (IOException | JSONException e) {
            System.out.println("Błąd podczas zapisywania meczów do pliku.");
            e.printStackTrace();
        }
    }

    public static List<FootballMatch> readMatchesFromFile(String filename) {
        List<FootballMatch> matches = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Plik " + filename + " nie istnieje.");
            return matches;
        }

        try (FileReader fileReader = new FileReader(file);
             Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                JSONObject json = new JSONObject(line);
                FootballMatch match = FootballMatch.fromJSON(json);
                matches.add(match);
            }

        } catch (IOException | JSONException e) {
            System.out.println("Błąd podczas odczytywania meczów z pliku.");
            e.printStackTrace();
        }

        return matches;
    }


}
