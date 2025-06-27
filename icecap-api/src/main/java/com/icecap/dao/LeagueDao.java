package com.icecap.dao;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import com.icecap.dto.League;

public class LeagueDao {
  private static final Logger logger = Logger
      .getLogger(MethodHandles.lookup().lookupClass().getName());
  private static final String INSERT_LEAGUE_SQL = "insert into icecap.league values(?,?,?,?,?,?,?,?,?,?)";
  private static final String SELECT_ALL_LEAGUE_SQL = """
      select
          league_id
        , name
        , sport
        , founded
        , commissioner
        , teams
        , roster_limit
        , salary_cap
        , contracts_limit
        , retained_limit
      from
        icecap.league
      """;
  private static final String SELECT_LEAGUE_SQL = """
      select
          league_id
        , name
        , sport
        , founded
        , commissioner
        , teams
        , roster_limit
        , salary_cap
        , contracts_limit
        , retained_limit
      from
        icecap.league
      where
        league_id = ?
      """;
  private static final String DELETE_LEAGUE_SQL = "delete from icecap.league where league_id = ?";
  private static final String EXISTS_LEAGUE_SQL = "select exists("
      + SELECT_LEAGUE_SQL + ") as doesExist";

  public void addLeague(League league, Connection con) throws SQLException {
    try {

      addLeagueInternal(league, con);

      // TODO: add stats;
      // use for writing (insert, update, delete)
      con.commit();
    } catch (SQLException e) {
      con.rollback();
      throw e;
    }
  }

  public void addLeagueInternal(League league, Connection con)
      throws SQLException {
    try (PreparedStatement p = con.prepareStatement(INSERT_LEAGUE_SQL)) {
      p.setString(1, league.getUuid().toString());
      p.setString(2, league.getName());
      p.setString(3, league.getSport());
      p.setInt(4, league.getFounded());
      p.setString(5, league.getCommissioner());
      p.setInt(6, league.getTeams());
      p.setInt(7, league.getRoster_limit());
      p.setBigDecimal(8, league.getSalary_cap().setScale(2));
      p.setInt(9, league.getContract_limit());
      p.setInt(10, league.getRetained_limit());
      p.execute();

    }

  }

  public League createLeague(ResultSet rs) throws SQLException {
    UUID uuid = UUID.fromString(rs.getString("league_id"));
    String name = rs.getString("name");
    String sport = rs.getString("sport");
    int founded = rs.getInt("founded");
    String com = rs.getString("commissioner");
    int teams = rs.getInt("teams");
    int roster = rs.getInt("roster_limit");
    BigDecimal cap = rs.getBigDecimal("salary_cap");
    int contracts_limit = rs.getInt("contracts_limit");
    int retained = rs.getInt("retained_limit");
    return League
        .builder()
          .withUuid(uuid)
          .withName(name)
          .withSport(sport)
          .withFounded(founded)
          .withCommissioner(com)
          .withTeams(teams)
          .withRoster_limit(roster)
          .withSalary_cap(cap)
          .withContract_limit(contracts_limit)
          .withRetained_limit(retained)
          .build();
  }

  public List<League> getLeagues(Connection con) throws SQLException {
    List<League> lister = new ArrayList<>();
    try {
      try (PreparedStatement p = con.prepareStatement(SELECT_ALL_LEAGUE_SQL)) {
        try (ResultSet rs = p.executeQuery()) {
          while (rs.next()) {
            lister.add(createLeague(rs));
          }
          return lister;
        }

      }
    } finally {
      con.rollback();
    }

  }

  public League getLeague(Connection con, String leagueId) throws SQLException {
    try {
      try (PreparedStatement p = con.prepareStatement(SELECT_LEAGUE_SQL)) {
        p.setString(1, leagueId);
        try (ResultSet rs = p.executeQuery()) {
          while (rs.next()) {
            return createLeague(rs);
          }

          return null;
        }

      }
    } finally {
      con.rollback();
    }

  }

  public League deleteLeague(Connection con, String leagueId)
      throws SQLException {
    try {
      League league = getLeague(con, leagueId);
      try (PreparedStatement p = con.prepareStatement(DELETE_LEAGUE_SQL)) {
        p.setString(1, leagueId);
        p.execute();
      }
      return league;
    } finally {
      con.commit();
    }

  }

  public boolean leagueExists(String leagueId, Connection con)
      throws SQLException {
    try {
      try (PreparedStatement p = con.prepareStatement(EXISTS_LEAGUE_SQL)) {
        p.setString(1, leagueId);
        try (ResultSet rs = p.executeQuery()) {
          if (rs.next()) {
            return rs.getInt("doesExist") == 1;
          }

          return false;
        }

      }
    } finally {
      con.rollback();
    }

  }
}
