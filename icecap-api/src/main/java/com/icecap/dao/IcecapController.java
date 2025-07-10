package com.icecap.dao;

import java.lang.invoke.MethodHandles;
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
    logger.info("temp method to test exceptionmapper");
    throw new SQLException("SQLException thrown");
  }

  public void addLeague(League league) throws SQLException {

    leagueDao.addLeague(league, con.connect());
    logger.info("adding league here");
  }

  public List<League> getLeagues() throws SQLException {
    logger.info("adding league here");
    return leagueDao.getLeagues(con.connect());
  }

  public League getLeagueByID(String leagueId) throws SQLException {
    return leagueDao.getLeague(con.connect(), leagueId);
  }

  public League deleteLeagueByID(String leagueId) throws SQLException {
    return leagueDao.deleteLeague(con.connect(), leagueId);
  }

  public void upsertLeague(League league) throws SQLException {
    logger.info("upsert league here");
    boolean doesExist = leagueDao
        .leagueExists(league.getUuid().toString(), con.connect());
    logger.info(Boolean.toString(doesExist));

  }

  public void addTeam(String leagueId, Team team) throws SQLException {
    League league = getLeagueByID(leagueId);
    teamDao.addTeam(team, con.connect());
    logger.info("adding team here");
  }

  public List<Team> getTeams(String leagueId) throws SQLException {
    // ok, for this, I can figure out how:
    logger.info("adding league here");
    return teamDao.getTeams(con.connect());
  }

  public Team getTeamByID(String leagueId, String teamId) throws SQLException {
    return teamDao.getTeam(con.connect(), teamId);
  }

  public Team deleteTeamByID(String leagueId, String teamId)
      throws SQLException {
    return teamDao.deleteTeam(con.connect(), teamId);
  }

  public void upsertTeam(String leagueId, Team team) throws SQLException {
    logger.info("upsert team here");
  }

  public void addAthlete(String leagueId, String teamId, Athlete athlete)
      throws SQLException {
    logger.info("adding athlete here");
    athleteDao.addAthlete(athlete, con.connect());
  }

  public List<Athlete> getAthletes(String leagueId, String teamId)
      throws SQLException {
    logger.info("adding athlete here");
    return athleteDao.getAllAthletes(con.connect());
  }

  public Athlete getAthlete(String leagueId, String teamId, String athleteId)
      throws SQLException {
    logger.info("adding athlete here");
    return athleteDao.getAthlete(athleteId, con.connect());

  }

  public Athlete deleteAthlete(String leagueId, String teamId, String athleteId)
      throws SQLException {
    logger.info("delete athlete here");
    return athleteDao.deleteAthlete(con.connect(), athleteId);
  }

  public void upsertAthlete(String leagueId, String teamId, Athlete athlete)
      throws SQLException {
    logger.info("upsert athlete here");
  }

  public void addContract(String leagueId, String teamId, String athleteId,

      Contract contract) throws SQLException {
    contractDao.addContract(contract, con.connect());

  }

  public List<Contract> getContracts(String leagueId, String teamId,
      String athleteId) throws SQLException {
    logger.info("get list of contracts here");
    return contractDao.getContractList(con.connect());
  }

  public Contract getContract(String leagueId, String teamId, String athleteId,
      String contractId) throws SQLException {
    logger.info("get list of contracts here");
    return contractDao.getContract(contractId, con.connect());
  }

  public Contract deleteContract(String leagueId, String teamId,
      String athleteId, String contractId) throws SQLException {
    logger.info("get list of contracts here");
    return contractDao.deleteContract(con.connect(), contractId);
  }

  public void upsertContract(String leagueId, String teamId, String athleteId)
      throws SQLException {
    logger.info("upsert contract here");
  }

}
