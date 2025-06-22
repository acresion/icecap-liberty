package com.icecap.dao;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import com.icecap.dto.Team;

//todo
public class TeamDao {
  Map<String, Team> mapper = new HashMap<>();
  private static final Logger logger = Logger
      .getLogger(MethodHandles.lookup().lookupClass().getName());
  private static final String INSERT_TEAM_SQL = "insert into icecap.team values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String SELECT_ALL_TEAMS_SQL = """
       select
         team_id
         , in_league_id
         , teamName
         , yearFounded
         , conference
         , division
         , gmName
         , coachName
         , captain
         , capHit
         , capSpace
         , active
         , retained
         , owner
         , website
      from
        icecap.team

      """;
  private static final String SELECT_TEAM_SQL = """
      select
         team_id
         , in_league_id
         , teamName
         , yearFounded
         , conference
         , division
         , gmName
         , coachName
         , captain
         , capHit
         , capSpace
         , active
         , retained
         , owner
         , website
      from
        icecap.team
      where
        team_id = ?

      """;
  private static final String DELETE_TEAM_SQL = "delete from icecap.team where team_id = ?";

  public void addTeam(Team team, Connection con) throws SQLException {
    try {

      addTeamInternal(team, con);

      // TODO: add stats;
      // use for writing (insert, update, delete)
      con.commit();
    } catch (SQLException e) {
      con.rollback();
      throw e;
    }

  }

  private void addTeamInternal(Team team, Connection con) throws SQLException {
    try (PreparedStatement p = con.prepareStatement(INSERT_TEAM_SQL)) {
      p.setString(1, team.getUuid().toString());
      p.setString(2, team.getTeam_id().toString());
      p.setString(3, team.getTeamName());
      p.setInt(4, team.getYearFounded());
      p.setString(5, team.getConference());
      p.setString(6, team.getDivision());
      p.setString(7, team.getGmName());
      p.setString(8, team.getCoachName());
      p.setString(9, team.getCaptain());
      p.setBigDecimal(10, team.getCapHit());
      p.setBigDecimal(11, team.getCapSpace());
      p.setInt(12, team.getActive());
      p.setInt(13, team.getRetained());
      p.setString(14, team.getOwner());
      p.setString(15, team.getWebsite());
      p.execute();

    }
  }

  private Team createTeam(ResultSet rs) throws SQLException {

    String team_id = rs.getString("team_id");
    String league_id = rs.getString("in_league_id");
    String teamName = rs.getString("teamName");
    int yearFounded = rs.getInt("yearFounded");
    String conference = rs.getString("conference");
    String division = rs.getString("division");

    String gmName = rs.getString("gmName");
    String coachName = rs.getString("coachName");
    String captain = rs.getString("captain");
    BigDecimal capHit = rs.getBigDecimal("capHit");
    BigDecimal capSpace = rs.getBigDecimal("capSpace");
    int active = rs.getInt("active");
    int retained = rs.getInt("retained");
    String owner = rs.getString("owner");
    String website = rs.getString("website");
    return Team
        .builder()
          .withActive(active)
          .withCapHit(capHit)
          .withCapSpace(capSpace)
          .withCaptain(captain)
          .withCoachName(coachName)
          .withConference(conference)
          .withDivision(division)
          .withGmName(gmName)
          .withOwner(owner)
          .withRetained(retained)
          .withTeam_id(UUID.fromString(team_id))
          .withTeamName(teamName)
          .withUuid(UUID.fromString(league_id))
          .withWebsite(website)
          .withYearFounded(yearFounded)
          .build();

  }

  public List<Team> getTeams(Connection con) throws SQLException {
    try {
      List<Team> lister = new ArrayList<>();
      try (PreparedStatement p = con.prepareStatement(SELECT_ALL_TEAMS_SQL)) {
        try (ResultSet rs = p.executeQuery()) {
          logger.info("query should work");
          while (rs.next()) {
            lister.add(createTeam(rs));
          }
          return lister;
        }

      }
    } finally {
      con.rollback();
    }

  }

  public Team getTeam(Connection con, String teamId) throws SQLException {
    try {
      try (PreparedStatement p = con.prepareStatement(SELECT_TEAM_SQL)) {
        p.setString(1, teamId);
        try (ResultSet rs = p.executeQuery()) {
          logger.info("query should work");
          while (rs.next()) {
            return createTeam(rs);
          }

          return null;
        }

      }
    } finally {
      con.rollback();
    }

  }

  public Team deleteTeam(Connection con, String teamId) throws SQLException {
    try {
      Team team = getTeam(con, teamId);
      try (PreparedStatement p = con.prepareStatement(DELETE_TEAM_SQL)) {
        p.setString(1, teamId);
        p.execute();
      }
      return team;

    } finally {
      con.commit();
    }

  }

}
