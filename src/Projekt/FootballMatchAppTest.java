package Projekt;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FootballMatchAppTest {

    @Test
    public void testAddMatches() {
        List<FootballMatch> matches = new ArrayList<>();
        matches.add(new FootballMatch("TeamA", "TeamB", 2, 1, "liga", "2023"));
        matches.add(new FootballMatch("TeamC", "TeamD", 3, 3, "puchar krajowy", "2023"));

        assertEquals(2, matches.size());
    }

    @Test
    public void testSaveMatchesToFile() {
        List<FootballMatch> matches = new ArrayList<>();
        matches.add(new FootballMatch("TeamA", "TeamB", 2, 1, "liga", "2023"));
        matches.add(new FootballMatch("TeamC", "TeamD", 3, 3, "puchar krajowy", "2023"));
        FootballMatchApp.saveMatchesToFile(matches, "test_matches.json");

        File file = new File("test_matches.json");
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    public void testReadMatchFromFile() {
        FootballMatch match1 = new FootballMatch("TeamA", "TeamB", 2, 1, "liga", "2023");
        FootballMatch match2 = new FootballMatch("TeamC", "TeamD", 3, 3, "puchar krajowy", "2023");

        FootballMatchApp.saveMatchesToFile(List.of(match1, match2), "test_read_match.json");

        List<FootballMatch> readMatches = FootballMatchApp.readMatchesFromFile("test_read_match.json");
        assertNotNull(readMatches);
        assertEquals(2, readMatches.size());

        FootballMatch readMatch1 = readMatches.get(0);
        FootballMatch readMatch2 = readMatches.get(1);

        assertEquals(match1.getHomeTeam(), readMatch1.getHomeTeam());
        assertEquals(match1.getAwayTeam(), readMatch1.getAwayTeam());
        assertEquals(match1.getHomeScore(), readMatch1.getHomeScore());
        assertEquals(match1.getAwayScore(), readMatch1.getAwayScore());
        assertEquals(match1.getCompetitionType(), readMatch1.getCompetitionType());
        assertEquals(match1.getSeason(), readMatch1.getSeason());

        assertEquals(match2.getHomeTeam(), readMatch2.getHomeTeam());
        assertEquals(match2.getAwayTeam(), readMatch2.getAwayTeam());
        assertEquals(match2.getHomeScore(), readMatch2.getHomeScore());
        assertEquals(match2.getAwayScore(), readMatch2.getAwayScore());
        assertEquals(match2.getCompetitionType(), readMatch2.getCompetitionType());
        assertEquals(match2.getSeason(), readMatch2.getSeason());

        File file = new File("test_read_match.json");
        file.delete();
    }

}
