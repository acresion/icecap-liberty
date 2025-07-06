package com.icecap.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.icecap.dto.Team;
import com.icecap.sql.MockConnection;
import com.icecap.sql.MockResultSet;

class TeamDaoTest {

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
        .addHeaders(new String[] { "team_id", "in_league_id", "teamName",
            "yearFounded", "conference", "division", "gmName", "coachName",
            "captain", "capHit", "capSpace", "active", "retained", "owner",
            "website", "doesExist" });
    rs
        .addRow(new Object[] { "1f3d1687-877b-47de-bf04-f2ed203d7c70",
            "ee1b2aca-1cf1-41a7-8896-d0bf856bdf38",
            "TeamThing", 1984, "Eastern", "Atlantic", "Test", "Jerome F",
            "Pat Burns", new BigDecimal("15.12").setScale(2),
            new BigDecimal("22.12").setScale(2), 1, 5, "MLSE", "http", 1 });

    Connection con = MockConnection.wireConnection(rs);

    return con;
  }

  private Team createTeam() {
    return Team
        .builder()
          .withActive(1)
          .withCapHit(new BigDecimal("15.12").setScale(2))
          .withCapSpace(new BigDecimal("22.12").setScale(2))
          .withCaptain("Pat Burns")
          .withCoachName("Jerome F")
          .withConference("Eastern")
          .withDivision("Atlantic")
          .withGmName("Test")
          .withOwner("MLSE")
          .withRetained(5)
          .withTeam_id(UUID.fromString("ee1b2aca-1cf1-41a7-8896-d0bf856bdf38"))
          .withTeamName("TeamThing")
          .withUuid(UUID.fromString("1f3d1687-877b-47de-bf04-f2ed203d7c70"))
          .withWebsite("http")
          .withYearFounded(1984)
          .build();
          
  }



  @Test
  void testGetTeams() throws SQLException {
    Connection con = createMockConnection();
    Team team = createTeam();
    List<Team> teamList = new ArrayList<>();
    teamList.add(team);
    TeamDao dao = new TeamDao();
    assertEquals(teamList, dao.getTeams(con));
  }

  @Test
  void testGetTeam() throws SQLException {
    Connection con = createMockConnection();
    Team team = createTeam();

    TeamDao dao = new TeamDao();
    assertEquals(team,
        dao.getTeam(con, "1f3d1687-877b-47de-bf04-f2ed203d7c70"));
  }

  @Test
  void testDeleteTeam() throws SQLException {
    Connection con = createMockConnection();
    Team team = createTeam();

    TeamDao dao = new TeamDao();
    assertEquals(team,
        dao.deleteTeam(con, "1f3d1687-877b-47de-bf04-f2ed203d7c70"));
  }

}
