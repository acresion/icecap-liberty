package com.icecap.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.icecap.dto.League;

@Disabled
class LeagueDaoTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  public Connection createMockConnection() throws SQLException {
    Connection con = mock(Connection.class);
    PreparedStatement ps = mock(PreparedStatement.class);
    ResultSet rs = mock(ResultSet.class);
    when(con.prepareStatement(anyString())).thenReturn(ps);
    when(ps.executeQuery()).thenReturn(rs);
    when(rs.next()).thenReturn(true, false);
    when(rs.getString("league_id"))
        .thenReturn("1c40ae21-f852-4c19-ae3e-7d648fb741d5");
    when(rs.getString("name")).thenReturn("NHL");
    when(rs.getString("sport")).thenReturn("Ice hockey");
    when(rs.getInt("founded")).thenReturn(1917);
    when(rs.getString("commissioner")).thenReturn("Jon Arbuckle");
    when(rs.getInt("teams")).thenReturn(11);
    when(rs.getInt("roster_limit")).thenReturn(12);
    when(rs.getBigDecimal("salary_cap"))
        .thenReturn(new BigDecimal("14.00").setScale(2));
    when(rs.getInt("contracts_limit")).thenReturn(13);
    when(rs.getInt("retained_limit")).thenReturn(3);

    return con;
  }

  @Test
  void testAddLeague() {

  }

  @Test
  void testGetLeagues() throws SQLException {
    Connection con = createMockConnection();
    League league = createLeague();
    List<League> leagueList = new ArrayList<>();
    leagueList.add(league);
    LeagueDao dao = new LeagueDao();
    assertEquals(leagueList, dao.getLeagues(con));

  }

  private League createLeague() {
    return League
        .builder()
          .withUuid(UUID.fromString("1c40ae21-f852-4c19-ae3e-7d648fb741d5"))
          .withCommissioner("Jon Arbuckle")
          .withContract_limit(13)
          .withFounded(1917)
          .withName("NHL")
          .withRetained_limit(3)
          .withRoster_limit(12)
          .withSalary_cap(new BigDecimal("14.00").setScale(2))
          .withSport("Ice hockey")
          .withTeams(11)
          .build();
  }

  @Test
  void testGetLeague() throws SQLException {
    Connection con = createMockConnection();
    League league = createLeague();
    LeagueDao dao = new LeagueDao();
    assertEquals(league,
        dao
            .getLeague(con,
                "1c40ae21-f852-4c19-ae3e-7d648fb741d5"));

  }


  @Test
  void testDeleteLeague() {
    fail("Not yet implemented");
  }

  @Test
  void testLeagueExists() {
    fail("Not yet implemented");
  }

}
