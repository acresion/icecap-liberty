package com.icecap.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GoalieStatsTest {
  private static UUID teamId = UUID
      .fromString("abf45179-d6d4-48a0-93cc-4da7e4316217");
  private static UUID statsId = UUID.randomUUID();
  private static UUID athleteId = UUID
      .fromString("034240b5-7c15-4fcc-88c7-eac59df00c3e");
  static private GoalieStats goalie;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    goalie = createGoalie(teamId, statsId, athleteId);
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    goalie = null;
    statsId = null;
    teamId = null;
    athleteId = null;
  }

  private static GoalieStats createGoalie(UUID teamId, UUID statsId,
      UUID athleteId) {
    return GoalieStats
        .builder()
          .withAthlete_id(athleteId)
          .withGaa(new BigDecimal("3.12").setScale(2))
          .withGamesPlayed(5)
          .withGamesStarted(3)
          .withGoalsAgainst(44)
          .withLosses(2)
          .withOvertimeLosses(2)
          .withSavePercent(new BigDecimal("0.87").setScale(2))
          .withSaves(44)
          .withSeason_id(statsId)
          .withShotsAgainst(55)
          .withShutouts(0)
          .withTeam_id(teamId)
          .withWins(5)
          .withYearSkate(113)
          .build();
  }

  @Test
  void testHashCode() {
    assertEquals(goalie.hashCode(), goalie.hashCode());
    assertNotEquals(0, goalie.hashCode());

  }


  @Test
  void testGetSeason_id() {
    assertEquals(statsId, goalie.getSeason_id());
  }

  @Test
  void testGetAthlete_id() {
    assertEquals(athleteId, goalie.getAthlete_id());
  }

  @Test
  void testGetYearSkate() {
    assertEquals(113, goalie.getYearSkate());

  }

  @Test
  void testGetTeam_id() {
    assertEquals(teamId, goalie.getTeam_id());

  }

  @Test
  void testGetGamesPlayed() {
    assertEquals(5, goalie.getGamesPlayed());

  }

  @Test
  void testGetGamesStarted() {
    assertEquals(3, goalie.getGamesStarted());
  }

  @Test
  void testGetWins() {
    assertEquals(5, goalie.getWins());

  }

  @Test
  void testGetLosses() {
    assertEquals(2, goalie.getLosses());

  }

  @Test
  void testGetOvertimeLosses() {
    assertEquals(2, goalie.getOvertimeLosses());
  }

  @Test
  void testGetShotsAgainst() {
    assertEquals(2, goalie.getLosses());
  }

  @Test
  void testGetSaves() {
    assertEquals(44, goalie.getSaves());
  }

  @Test
  void testGetGoalsAgainst() {
    assertEquals(44, goalie.getSaves());
  }

  @Test
  void testGetGaa() {
    assertEquals(new BigDecimal("3.12"), goalie.getGaa());

  }

  @Test
  void testGetSavePercent() {
    assertEquals(new BigDecimal("0.87"), goalie.getSavePercent());

  }

  @Test
  void testGetShutouts() {
    assertEquals(0, goalie.getShutouts());
  }

  @Test
  void testEquals() {
    GoalieStats same = createGoalie(teamId, statsId, athleteId);
    assertTrue(goalie.equals(same));
    assertTrue(same.equals(goalie));
    GoalieStats diff = createGoalie(teamId, UUID.randomUUID(), athleteId);
    assertFalse(goalie.equals(diff));
    assertFalse(diff.equals(goalie));
  }

  @Test
  void testToString() {
    assertNotNull(goalie.toString());
  }


}
