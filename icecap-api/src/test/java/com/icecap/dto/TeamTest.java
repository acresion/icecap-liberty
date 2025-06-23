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

class TeamTest {
  private static UUID leagueId = UUID
      .fromString("abf45179-d6d4-48a0-93cc-4da7e4316217");
  private static UUID teamId = UUID.randomUUID();
  private static Team team;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    team = createTeam(leagueId, teamId);

  }

  private static Team createTeam(UUID leagueId, UUID teamId) {
    return Team
        .builder()
          .withActive(44)
          .withCapHit(new BigDecimal("44.00"))
          .withCapSpace(new BigDecimal("55.00"))
          .withCaptain("Auston Matthews")
          .withCoachName("Craig Berube")
          .withConference("Eastern")
          .withDivision("Atlantic")
          .withGmName("Reed Richards")
          .withOwner("MLSE")
          .withRetained(3)
          .withTeam_id(leagueId)
          .withTeamName("Toronto Maple Leafs")
          .withUuid(teamId)
          .withWebsite("http")
          .withYearFounded(1984)
          .build();
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    team = null;
    leagueId = null;
    teamId = null;
  }

  @Test
  void testHashCode() {
    assertNotEquals(team.hashCode(), 0);
    assertEquals(team.hashCode(), team.hashCode());
  }



  @Test
  void testGetUuid() {
    assertEquals(teamId, team.getUuid());
  }

  @Test
  void testGetTeam_id() {
    assertEquals(leagueId, team.getTeam_id());
  }

  @Test
  void testGetTeamName() {
    assertEquals("Toronto Maple Leafs", team.getTeamName());
  }

  @Test
  void testGetYearFounded() {
    assertEquals(1984, team.getYearFounded());
  }

  @Test
  void testGetConference() {
    assertEquals("Eastern", team.getConference());
  }

  @Test
  void testGetDivision() {
    assertEquals("Atlantic", team.getDivision());
  }

  @Test
  void testGetGmName() {
    assertEquals("Reed Richards", team.getGmName());
  }

  @Test
  void testGetCoachName() {
    assertEquals("Craig Berube", team.getCoachName());

  }

  @Test
  void testGetCaptain() {
    assertEquals("Auston Matthews", team.getCaptain());
  }

  @Test
  void testGetCapHit() {
    assertEquals(new BigDecimal("44.00"), team.getCapHit());
  }

  @Test
  void testGetCapSpace() {
    assertEquals(new BigDecimal("55.00"), team.getCapSpace());
  }

  @Test
  void testGetActive() {
    assertEquals(44, team.getActive());
  }

  @Test
  void testGetRetained() {
    assertEquals(3, team.getRetained());
  }

  @Test
  void testGetOwner() {
    assertEquals("MLSE", team.getOwner());
  }

  @Test
  void testGetWebsite() {
    assertEquals("http", team.getWebsite());
  }

  @Test
  void testEqualsObject() {
    Team sameTeam = createTeam(leagueId, teamId);
    assertTrue(team.equals(sameTeam));
    assertTrue(sameTeam.equals(team));
    Team diffTeam = createTeam(leagueId, UUID.randomUUID());
    assertFalse(team.equals(diffTeam));
    assertFalse(diffTeam.equals(team));

  }

  @Test
  void testToString() {
    assertNotNull(team.toString());
  }



}
