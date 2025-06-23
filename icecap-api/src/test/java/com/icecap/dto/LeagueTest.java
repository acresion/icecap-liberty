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

class LeagueTest {
  private static UUID leagueId = UUID.randomUUID();
  private static League league;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    league = createLeague(leagueId);
  }

  private static League createLeague(UUID leagueId) {
    return League
        .builder()
          .withUuid(leagueId)
          .withCommissioner("Gary")
          .withContract_limit(55)
          .withFounded(1917)
          .withName("NHL")
          .withRetained_limit(45)
          .withRoster_limit(55)
          .withSalary_cap(new BigDecimal("55.55"))
          .withSport("Hockey")
          .withTeams(24)
          .build();
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    league = null;
    leagueId = null;
  }

  @Test
  void testHashCode() {
    assertNotEquals(league.hashCode(), 0);
    assertEquals(league.hashCode(), league.hashCode());

  }



  @Test
  void testGetUuid() {
    assertEquals(leagueId, league.getUuid());
  }

  @Test
  void testGetName() {
    assertEquals("NHL", league.getName());
  }

  @Test
  void testGetSport() {
    assertEquals("Hockey", league.getSport());
  }

  @Test
  void testGetFounded() {
    assertEquals(1917, league.getFounded());

  }

  @Test
  void testGetCommissioner() {
    assertEquals("Gary", league.getCommissioner());

  }

  @Test
  void testGetTeams() {
    assertEquals(24, league.getTeams());
  }

  @Test
  void testGetRoster_limit() {
    assertEquals(55, league.getRoster_limit());

  }

  @Test
  void testGetSalary_cap() {
    assertEquals(new BigDecimal("55.55"), league.getSalary_cap());

  }

  @Test
  void testGetContract_limit() {
    assertEquals(55, league.getContract_limit());
  }

  @Test
  void testGetRetained_limit() {
    assertEquals(45, league.getRetained_limit());
  }

  @Test
  void testEqualsObject() {
    League same = createLeague(leagueId);
    assertTrue(league.equals(same));
    assertTrue(same.equals(league));
    League diff = createLeague(UUID.randomUUID());
    assertFalse(diff.equals(league));
    assertFalse(league.equals(diff));
  }

  @Test
  void testToString() {
    assertNotNull(league.toString());
  }



}
