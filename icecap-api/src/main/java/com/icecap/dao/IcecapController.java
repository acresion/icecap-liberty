package com.icecap.dao;

import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.ArrayList;
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


  private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
  
  
  public void addLeague(League league) throws SQLException {
    // TODO: figure out how expections become REST payloads
    leagueDao.addLeague(league, con.connect());
    logger.info("adding league here");
  }
  
  public List<League> getLeagues() throws SQLException {
    // TODO: figure out how expections become REST payloads
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
    // TODO: figure out how expections become REST payloads
    logger.info("upsert league here");
    boolean doesExist = leagueDao.leagueExists(league.getUuid().toString(), con.connect());
    logger.info(Boolean.toString(doesExist));

  }

  public void addTeam(String leagueId, Team team) throws SQLException {
    // TODO: figure out how expections become REST payloads
    League league = getLeagueByID(leagueId);
    teamDao.addTeam(team, con.connect());
    logger.info("adding team here");
  }

  public List<Team> getTeams(String leagueId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    // ok, for this, I can figure out how:
    logger.info("adding league here");
    return teamDao.getTeams(con.connect());
  }

  public Team getTeamByID(String leagueId, String teamId)throws SQLException {
    return teamDao.getTeam(con.connect(), teamId);
  }

  public Team deleteTeamByID(String leagueId, String teamId) throws SQLException {
    return teamDao.deleteTeam(con.connect(), teamId);
  }

  public void upsertTeam(String leagueId, Team team) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("upsert team here");
  }

  public void addAthlete(String leagueId, String teamId, Athlete athlete) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding athlete here");
    athleteDao.addAthlete(athlete, con.connect());
  }

  public List<Athlete> getAthletes(String leagueId, String teamId) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding athlete here");
    return new ArrayList<>();
  }

  public Athlete getAthlete(String leagueId, String teamId, String athleteId) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding athlete here");
    return null;
  }

  public Athlete deleteAthlete(String leagueId, String teamId, String athleteId) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("delete athlete here");
    return null;
  }

  public void upsertAthlete(String leagueId, String teamId, Athlete athlete) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("upsert athlete here");
  }

  public void addContract(String leagueId, String teamId, String athleteId,

      Contract contract) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding athlete here");

  }

  public List<Contract> getContracts(String leagueId, String teamId, String athleteId) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("get list of contracts here");
    return new ArrayList<>();
  }

  public Contract getContract(String leagueId, String teamId, String athleteId, String contractId) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("get list of contracts here");
    return null;
  }

  public Contract deleteContract(String leagueId, String teamId, String athleteId, String contractId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("get list of contracts here");
    return null;
  }

  public void upsertContract(String leagueId, String teamId, String athleteId) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("upsert contract here");
  }


}
