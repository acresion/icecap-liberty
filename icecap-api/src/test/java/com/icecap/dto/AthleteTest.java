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

class AthleteTest {
  private static final int MONEY_SCALE = 2;

  private static UUID teamId = UUID
      .fromString("abf45179-d6d4-48a0-93cc-4da7e4316217");

  private static UUID athleteId = UUID.randomUUID();
  private static UUID contractId = UUID.randomUUID();

  static private Athlete athlete;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    athlete = createAthlete(athleteId, contractId, teamId);

  }

  private static Athlete createAthlete(UUID athleteId, UUID contractId,
      UUID teamId) {
    return Athlete
        .builder()
          .withUuid(athleteId)
          .withTeamID(teamId)
          .withFirstName("Test")
          .withLastName("Athlete")
          .withNumber(1)
          .withAge(22)
          .withPos("55")
          .withHeightFeet(5)
          .withHeightInches(5)
          .withWeightPounds(5)
          .withAgentFirstName("Frank")
          .withAgentLastName("Herbert")
          .withNationality("Canada")
          .withDateOfBirth("Jan 14, 1984")

          .build();
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    athlete = null;
    teamId = null;
    contractId = null;
    athleteId = null;
  }

  @Test
  void testHashCode() {
    assertNotEquals(0, athlete.hashCode());

    assertEquals(athlete.hashCode(), athlete.hashCode());
  }



  @Test
  void testGetUuid() {
    assertEquals(athleteId, athlete.getUuid());
  }

  @Test
  void testGetTeamID() {
    assertEquals(teamId, athlete.getTeamID());

  }

  @Test
  void testGetFirstName() {
    assertEquals("Test", athlete.getFirstName());
  }

  @Test
  void testGetLastName() {
    assertEquals("Athlete", athlete.getLastName());
  }


  @Test
  void testGetNumber() {
    assertEquals(1, athlete.getNumber());

  }

  @Test
  void testGetAge() {
    assertEquals(22, athlete.getAge());

  }

  @Test
  void testGetPos() {
    assertEquals("55", athlete.getPos());

  }

  @Test
  void testGetHeightFeet() {
    assertEquals(5, athlete.getHeightFeet());
  }
  @Test
  void testGetHeightInches() {
    assertEquals(5, athlete.getHeightInches());
  }

  @Test
  void testGetWeightPounds() {
    assertEquals(5, athlete.getWeightPounds());
  }

  @Test
  void testGetAgentFirstName() {
    assertEquals("Frank", athlete.getAgentFirstName());
  }

  @Test
  void testGetAgentLastName() {
    assertEquals("Herbert", athlete.getAgentLastName());

  }

  @Test
  void testGetNationality() {
    assertEquals("Canada", athlete.getNationality());
  }

  @Test
  void testGetDateOfBirth() {
    assertEquals("Jan 14, 1984", athlete.getDateOfBirth());
  }





  @Test
  void testEqualsObject() {
    Athlete sameAthlete = createAthlete(athleteId, contractId, teamId) ;
    assertTrue(athlete.equals(sameAthlete));
    assertTrue(sameAthlete.equals(athlete));
    assertFalse(athlete.equals(false));
    Athlete differentAthlete = createAthlete(UUID.randomUUID(), contractId,
        teamId);
    assertFalse(athlete.equals(differentAthlete));
    assertFalse(differentAthlete.equals(athlete));

  }

  @Test
  void testToString() {
    assertNotNull(athlete.toString());
  }

}
