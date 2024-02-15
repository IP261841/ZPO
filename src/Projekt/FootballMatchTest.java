package Projekt;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FootballMatchTest {

    private FootballMatch match;

    @Before
    public void setUp() {
        match = new FootballMatch("Real Madrid", "FC Barcelona", 2, 1, "liga", "2023/2024");
    }

    @Test
    public void testToJSON() throws JSONException {
        JSONObject json = match.toJSON();
        assertNotNull(json);
        assertEquals("Real Madrid", json.getString("homeTeam"));
        assertEquals("FC Barcelona", json.getString("awayTeam"));
        assertEquals(2, json.getInt("homeScore"));
        assertEquals(1, json.getInt("awayScore"));
        assertEquals("liga", json.getString("competitionType"));
        assertEquals("2023/2024", json.getString("season"));
    }

    @Test
    public void testFromJSON() throws JSONException {
        JSONObject json = match.toJSON();
        FootballMatch newMatch = FootballMatch.fromJSON(json);
        assertNotNull(newMatch);
        assertEquals(match.getHomeTeam(), newMatch.getHomeTeam());
        assertEquals(match.getAwayTeam(), newMatch.getAwayTeam());
        assertEquals(match.getHomeScore(), newMatch.getHomeScore());
        assertEquals(match.getAwayScore(), newMatch.getAwayScore());
        assertEquals(match.getCompetitionType(), newMatch.getCompetitionType());
        assertEquals(match.getSeason(), newMatch.getSeason());
    }
}

