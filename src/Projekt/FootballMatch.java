package Projekt;

import org.json.JSONObject;
import org.json.JSONException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class FootballMatch {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private String competitionType; // Typ rozgrywek
    private String season;

    public FootballMatch(String homeTeam, String awayTeam, int homeScore, int awayScore, String competitionType, String season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.competitionType = competitionType;
        this.season = season;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("homeTeam", homeTeam);
        json.put("awayTeam", awayTeam);
        json.put("homeScore", homeScore);
        json.put("awayScore", awayScore);
        json.put("competitionType", competitionType);
        json.put("season", season);
        return json;
    }

    public static FootballMatch fromJSON(JSONObject json) throws JSONException {
        String homeTeam = json.getString("homeTeam");
        String awayTeam = json.getString("awayTeam");
        int homeScore = json.getInt("homeScore");
        int awayScore = json.getInt("awayScore");
        String competitionType = json.getString("competitionType");
        String season = json.getString("season");
        return new FootballMatch(homeTeam, awayTeam, homeScore, awayScore, competitionType, season);
    }

    public static void main(String[] args) {
        // Tworzenie meczu piłkarskiego
        FootballMatch match = new FootballMatch("Real Madrid", "FC Barcelona", 2, 1, "liga", "2023/2024");

        // Zapisywanie danych do pliku JSON
        saveMatchToFile(match, "match.json");

        // Odczytywanie danych z pliku JSON
        FootballMatch readMatch = readMatchFromFile("match.json");
        if (readMatch != null) {
            System.out.println("Drużyna gospodarzy: " + readMatch.getHomeTeam());
            System.out.println("Drużyna gości: " + readMatch.getAwayTeam());
            System.out.println("Wynik: " + readMatch.getHomeScore() + " - " + readMatch.getAwayScore());
            System.out.println("Typ rozgrywek: " + readMatch.getCompetitionType());
            System.out.println("Sezon: " + readMatch.getSeason());
        } else {
            System.out.println("Błąd podczas odczytywania meczu z pliku.");
        }
    }

    public static void saveMatchToFile(FootballMatch match, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(match.toJSON().toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static FootballMatch readMatchFromFile(String filename) {
        try (FileReader fileReader = new FileReader(filename)) {
            StringBuilder sb = new StringBuilder();
            int character;
            while ((character = fileReader.read()) != -1) {
                sb.append((char) character);
            }
            JSONObject json = new JSONObject(sb.toString());
            return FootballMatch.fromJSON(json);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getCompetitionType() {
        return competitionType;
    }

    public String getSeason() {
        return season;
    }
}
