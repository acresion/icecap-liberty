package com.icecap.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.icecap.dto.Contract;
import com.icecap.sql.MockConnection;
import com.icecap.sql.MockResultSet;

class ContractDaoTest {
  // The purpose behind these guys is to make sure we copy database calls
  // without affecting the database.

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  public Connection createMockConnection() throws SQLException {
    MockResultSet rs = new MockResultSet();
    // Mock Driver Pattern
    rs
        .addHeaders(new String[] { "contract_id", "player_id", "first_season",
            "agent", "team", "term", "value", "capHit",
            "percent_at_start", "status", "doesExist" });
    rs
        .addRow(new Object[] { "1c40ae21-f852-4c19-ae3e-7d648fb741d5",
            "5d5a4aac-ea2c-4bc1-8c97-94f8560f7272", 1918, "Fred Warner",
            "abf45179-d6d4-48a0-93cc-4da7e4316217", 5,
            new BigDecimal("11.23").setScale(2),
            new BigDecimal("11").setScale(2),
            new BigDecimal("15.00").setScale(2), "RFA", 1 });

    Connection con = MockConnection.wireConnection(rs);

    return con;
  }

  private Contract createContract() {
    return Contract
        .builder()
          .withAgentName("Fred Warner")
          .withAthleteId(
              UUID.fromString("5d5a4aac-ea2c-4bc1-8c97-94f8560f7272"))
          .withCapHit(new BigDecimal("11").setScale(2))
          .withContractId(
              UUID.fromString("1c40ae21-f852-4c19-ae3e-7d648fb741d5"))
          .withFirstSeason(1918)
          .withPercent(new BigDecimal("15.00").setScale(2))
          .withStatus("RFA")
          .withTeamName(UUID.fromString("abf45179-d6d4-48a0-93cc-4da7e4316217"))
          .withTerm(5)
          .withValue(new BigDecimal("11.23").setScale(2))
          .build();
  }


  @Test
  void testGetListContracts() throws SQLException {
    Contract contract = createContract();
    Connection con = createMockConnection();
    ContractDao dao = new ContractDao();
    assertEquals(List.of(contract), dao.getContractList(con));

  }

  @Test
  void testGetContract() throws SQLException {
    Contract contract = createContract();
    Connection con = createMockConnection();
    ContractDao dao = new ContractDao();
    assertEquals(contract,
        dao.getContract("1c40ae21-f852-4c19-ae3e-7d648fb741d5", con));

  }

  @Test
  void testDeleteContract() throws SQLException {


    Contract contract = createContract();
    Connection con = createMockConnection();
    ContractDao dao = new ContractDao();
    assertEquals(contract,
        dao.deleteContract(con, "1c40ae21-f852-4c19-ae3e-7d648fb741d5"));

  }

}
