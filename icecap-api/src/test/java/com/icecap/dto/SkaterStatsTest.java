package com.icecap.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SkaterStatsTest {

  private static UUID teamId = UUID
      .fromString("abf45179-d6d4-48a0-93cc-4da7e4316217");
  private static UUID statsId = UUID.randomUUID();
  private static UUID athleteId = UUID
      .fromString("034240b5-7c15-4fcc-88c7-eac59df00c3e");
  static private SkaterStats skater;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    skater = createSkater(teamId, statsId, athleteId);
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    skater = null;
    statsId = null;
    teamId = null;
    athleteId = null;
  }

  private static SkaterStats createSkater(UUID teamId, UUID statsId,
      UUID athleteId) {
    return SkaterStats
        .builder()
          .withAssists(3)
          .withAthlete_id(athleteId)
          .withEvenStrengthGoals(4)
          .withEvenStrengthPoints(55)
          .withGames(44)
          .withGoals(6)
          .withPenaltyMinutes(54)
          .withPlusMinus(0)
          .withPoints(65)
          .withPowerPlayGoals(5)
          .withPowerPlayPoints(443)
          .withPenaltyMinutes(0)
          .withSeason_id(statsId)
          .withShots(0)
          .withTeam_id(teamId)
          .withYear(0)
          .build();

  }

  @Test
  void testHashCode() {
    assertNotEquals(0, skater.hashCode());
    assertEquals(skater.hashCode(), skater.hashCode());
  }



  @Test
  void testGetSeason_id() {
    assertEquals(statsId, skater.getSeason_id());
  }

  @Test
  void testGetAthlete_id() {
    assertEquals(athleteId, skater.getAthlete_id());
  }

  @Test
  void testGetYear() {
    assertEquals(0, skater.getYear());

  }

  @Test
  void testGetTeam_id() {
    assertEquals(teamId, skater.getTeam_id());

  }

  @Test
  void testGetGames() {
    assertEquals(44, skater.getGames());
  }

  @Test
  void testGetGoals() {
    assertEquals(6, skater.getGoals());

  }

  @Test
  void testGetAssists() {
    assertEquals(3, skater.getAssists());

  }

  @Test
  void testGetPoints() {
    assertEquals(65, skater.getPoints());

  }

  @Test
  void testGetPlusMinus() {
    assertEquals(0, skater.getPlusMinus());

  }

  @Test
  void testGetPenaltyMinutes() {
    assertEquals(0, skater.getPlusMinus());

  }

  @Test
  void testGetEvenStrengthGoals() {
    assertEquals(4, skater.getEvenStrengthGoals());

  }

  @Test
  void testGetEvenStrengthPoints() {
    assertEquals(55, skater.getEvenStrengthPoints());

  }

  @Test
  void testGetPowerPlayGoals() {
    assertEquals(5, skater.getPowerPlayGoals());

  }

  @Test
  void testGetPowerPlayPoints() {
    assertEquals(443, skater.getPowerPlayPoints());
  }

  @Test
  void testGetShots() {
    assertEquals(0, skater.getShots());
  }

  @Test
  void testEqualsObject() {
    SkaterStats same = createSkater(teamId, statsId, athleteId);
    assertTrue(same.equals(skater));
    assertTrue(skater.equals(same));
    SkaterStats diff = createSkater(teamId, UUID.randomUUID(), athleteId);
    assertFalse(skater.equals(diff));
    assertFalse(diff.equals(skater));

  }

  @Test
  void testToString() {
    assertNotNull(skater.toString());
  }



}
