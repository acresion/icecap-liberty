package com.icecap.dao;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.icecap.config.IceCapConfig;
import com.icecap.dto.Athlete;
import com.icecap.dto.Contract;
import com.icecap.dto.League;
import com.icecap.dto.Team;

public class IcecapController {
  private final ConnectionToSQL con;
  private LeagueDao leagueDao;
  private TeamDao teamDao;
  private AthleteDao athleteDao;
  private ContractDao contractDao;

  public IcecapController(IceCapConfig config) {

    this.con = new ConnectionToSQL(config.getMySqlConfig());
    this.leagueDao = new LeagueDao();
    this.teamDao = new TeamDao();
    this.athleteDao = new AthleteDao();
    this.contractDao = new ContractDao();
  }

  private static final Logger logger = Logger
      .getLogger(MethodHandles.lookup().lookupClass().getName());

  public void testForException() throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("temp method to test exceptionmapper");
    throw new SQLException("SQLException thrown");
  }
  }

  public void addLeague(League league) throws SQLException {
    try (Connection c = con.connect()) {

      leagueDao.addLeague(league, c);
    logger.info("adding league here");

  }
  }

  public List<League> getLeagues() throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("adding league here");
    return leagueDao.getLeagues(c);
  }
  }

  public League getLeagueByID(String leagueId) throws SQLException {
    try (Connection c = con.connect()) {
      return leagueDao.getLeague(c, leagueId);
    }
  }

  public League deleteLeagueByID(String leagueId) throws SQLException {
    try (Connection c = con.connect()) {
      return leagueDao.deleteLeague(c, leagueId);
    }
  }

  public void upsertLeague(League league) throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("upsert league here");
    boolean doesExist = leagueDao
        .leagueExists(league.getUuid().toString(), c);
    logger.info(Boolean.toString(doesExist));
  }

  }

  public void addTeam(String leagueId, Team team) throws SQLException {
    try (Connection c = con.connect()) {
    League league = getLeagueByID(leagueId);
      teamDao.addTeam(team, c);
    logger.info("adding team here");
    }
  }

  public List<Team> getTeams(String leagueId) throws SQLException {
    // ok, for this, I can figure out how:

    try (Connection c = con.connect()) {
      logger.info("Extracting teams for the league: " + leagueId);
      return teamDao.getTeams(c);
  }
  }

  public Team getTeamByID(String leagueId, String teamId) throws SQLException {
    try (Connection c = con.connect()) {
      return teamDao.getTeam(c, teamId);
    }
  }

  public Team deleteTeamByID(String leagueId, String teamId)
      throws SQLException {
    try (Connection c = con.connect()) {
      return teamDao.deleteTeam(c, teamId);
    }
  }

  public void upsertTeam(String leagueId, Team team) throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("upsert team here");
    }
  }

  public void addAthlete(String leagueId, String teamId, Athlete athlete)
      throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("adding athlete here");
    athleteDao.addAthlete(athlete, c);
  }
  }

  public List<Athlete> getAthletes(String leagueId, String teamId)
      throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("adding athlete here");
    return athleteDao.getAllAthletes(c);
  }
  }

  public Athlete getAthlete(String leagueId, String teamId, String athleteId)
      throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("adding athlete here");
    return athleteDao.getAthlete(athleteId, c);
  }

  }

  public Athlete deleteAthlete(String leagueId, String teamId, String athleteId)
      throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("delete athlete here");
    return athleteDao.deleteAthlete(c, athleteId);
    }
  }

  public void upsertAthlete(String leagueId, String teamId, Athlete athlete)
      throws SQLException {
    try (Connection c = con.connect()) {
    logger.info("upsert athlete here");
    }
  }

  public void addContract(String leagueId, String teamId, String athleteId,

      Contract contract) throws SQLException {
    try (Connection c = con.connect()) {
      contractDao.addContract(contract, c);
    }

  }

  public List<Contract> getContracts(String leagueId, String teamId,
      String athleteId) throws SQLException {
    try (Connection c = con.connect()) {
      logger.info("get list of contracts here");
      return contractDao.getContractList(c);
    }
  }

  public Contract getContract(String leagueId, String teamId, String athleteId,
      String contractId) throws SQLException {
    try (Connection c = con.connect()) {
      logger.info("get list of contracts here");
      return contractDao.getContract(contractId, c);
    }
  }

  public Contract deleteContract(String leagueId, String teamId,
      String athleteId, String contractId) throws SQLException {
    try (Connection c = con.connect()) {
      logger.info("get list of contracts here");
      return contractDao.deleteContract(c, contractId);
    }
  }

  public void upsertContract(String leagueId, String teamId, String athleteId)
      throws SQLException {
    try (Connection c = con.connect()) {
      logger.info("upsert contract here");
    }
  }

}
