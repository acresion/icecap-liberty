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

class ContractTest {
  private static final int MONEY_SCALE = 2;
  private static UUID teamId = UUID
      .fromString("abf45179-d6d4-48a0-93cc-4da7e4316217");
  private static UUID contractId = UUID.randomUUID();
  private static UUID athleteId = UUID
      .fromString("034240b5-7c15-4fcc-88c7-eac59df00c3e");
  static private Contract contract;

  @BeforeAll
  static void setUp() {

    contract = createContract(teamId, contractId, athleteId);

  }

  @AfterAll
  static void cleanUp() {
    contract = null;
    teamId = null;
    contractId = null;
    athleteId = null;
  }

  private static Contract createContract(UUID teamId, UUID contractId,
      UUID athleteId) {
    return Contract
        .builder()
          .withAgentName("abc")
          .withAthleteId(athleteId)
          .withCapHit(new BigDecimal("1000.11").setScale(MONEY_SCALE))
          .withContractId(contractId)
          .withFirstSeason(1918)
          .withPercent(new BigDecimal("10.82").setScale(MONEY_SCALE))
          .withStatus("RFA")
          .withTeamName(teamId)
          .withTerm(5)
          .withValue(new BigDecimal("100.20").setScale(MONEY_SCALE))
          .build();
  }

  @Test
  void testHashCode() {

    assertNotEquals(0, contract.hashCode());

    assertEquals(contract.hashCode(), contract.hashCode());
  }

  @Test
  void testGetContractId() {
    assertEquals(contractId, contract.getContractId());
  }

  @Test
  void testGetAthleteId() {
    assertEquals(athleteId, contract.getAthleteId());
  }

  @Test
  void testGetFirstSeason() {
    assertEquals(1918, contract.getFirstSeason());
  }

  @Test
  void testGetAgentName() {
    assertEquals("abc", contract.getAgentName());

  }

  @Test
  void testGetTeamName() {
    assertEquals(teamId, contract.getTeamName());
  }

  @Test
  void testGetTerm() {
    assertEquals(5, contract.getTerm());
  }

  @Test
  void testGetValue() {
    assertEquals(new BigDecimal("100.20").setScale(MONEY_SCALE),
        contract.getValue());
  }

  @Test
  void testGetCapHit() {
    assertEquals(new BigDecimal("1000.11").setScale(MONEY_SCALE),
        contract.getCapHit());
  }

  @Test
  void testGetPercent() {
    assertEquals(new BigDecimal("10.82").setScale(MONEY_SCALE),
        contract.getPercent());

  }

  @Test
  void testGetStatus() {
    assertEquals("RFA", contract.getStatus());
  }

  @Test
  void testEqualsObject() {
    Contract sameContract = createContract(teamId, contractId, athleteId);
    assertTrue(contract.equals(sameContract));
    assertTrue(sameContract.equals(contract));
    assertFalse(contract.equals(false));
    Contract differentContract = createContract(teamId, UUID.randomUUID(),
        athleteId);
    assertFalse(contract.equals(differentContract));
    assertFalse(differentContract.equals(contract));
  }

  @Test
  void testToString() {
    assertNotNull(contract.toString());
  }


}
