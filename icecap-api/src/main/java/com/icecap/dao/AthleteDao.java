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

import com.icecap.dto.Athlete;
import com.icecap.dto.Contract;

public class AthleteDao {

  private static final Logger logger = Logger
      .getLogger(MethodHandles.lookup().lookupClass().getName());
  private static final String INSERT_ATHLETE_SQL = "insert into athlete values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String INSERT_CONTRACT_SQL = "insert into contract_info values(?,?,?,?,?,?,?,?,?,?)";
  private static final String DELETE_ATHLETE_SQL = "delete from icecap.athlete where athlete_id = ?";

  private static final String GET_ATHLETE_SQL = """
      select
          athlete_id
        , current_team_id
        , firstName
        , lastName
        , jNumber
        , age
        , pos
        , heightFeet
        , heightInches
        , weightPounds
        , agentFirst
        , agentLast
        , nation
        , dob
      from
        icecap.athlete
      where athlete_id = ?
      			""";

  private static final String GET_ATHLETE_LIST_SQL = """
      select
          athlete_id
        , current_team_id
        , firstName
        , lastName
        , jNumber
        , age
        , pos
        , heightFeet
        , heightInches
        , weightPounds
        , agentFirst
        , agentLast
        , nation
        , dob
      from
        icecap.athlete
            """;

  private static final String GET_ATHLETES_FROM_TEAM_SQL = """
      select
          athlete_id
        , current_team_id
        , firstName
        , lastName
        , jNumber
        , age
        , pos
        , heightFeet
        , heightInches
        , weightPounds
        , agentFirst
        , agentLast
        , nation
        , dob
      from
        icecap.athlete
      where current_team_id = ?
            """;

  private static final String GET_CONTRACT_FROM_ATHLETE_SQL = """
      select
          contract_id
        , player_id
        , first_season
        , agent
        , team
        , term
        , value
        , capHit
        , percent_at_start
        , status
      from
        icecap.contract_info
      where player_id = ?
            """;

  public AthleteDao() {

  }

  public void addAthlete(Athlete athlete, Connection con) throws SQLException {

    try {
      addAthleteInternal(athlete, con);
      for (Contract contract : athlete.getContracts()) {
        addContract(contract, con);
      }
      // use for writing (insert, update, delete)
      con.commit();
    } catch (SQLException e) {
      con.rollback();
      throw e;

    }
  }

  private void addAthleteInternal(Athlete athlete, Connection con)
      throws SQLException {
    try (PreparedStatement p = con.prepareStatement(INSERT_ATHLETE_SQL)) {

      p.setString(1, athlete.getUuid().toString());
      p.setString(2, athlete.getTeamID().toString());
      p.setString(3, athlete.getFirstName());
      p.setString(4, athlete.getLastName());
      p.setInt(5, athlete.getNumber());
      p.setInt(6, athlete.getAge());
      p.setString(7, athlete.getPos());
      p.setInt(8, athlete.getHeightFeet());
      p.setInt(9, athlete.getHeightInches());
      p.setInt(10, athlete.getWeightPounds());
      p.setString(11, athlete.getAgentFirstName());
      p.setString(12, athlete.getAgentLastName());
      p.setString(13, athlete.getNationality());
      p.setString(14, athlete.getDateOfBirth());
      p.execute();
    }
  }

  private void addContract(Contract contract, Connection con)
      throws SQLException {
    try (PreparedStatement p = con.prepareStatement(INSERT_CONTRACT_SQL)) {

      p.setString(1, contract.getContractId().toString());
      p.setString(2, contract.getAthleteId().toString());
      p.setInt(3, contract.getFirstSeason());
      p.setString(4, contract.getAgentName());
      p.setString(5, contract.getTeamName().toString());
      p.setInt(6, contract.getTerm());
      p.setBigDecimal(7, contract.getValue());
      p.setBigDecimal(8, contract.getCapHit());
      p.setBigDecimal(9, contract.getPercent());
      p.setString(10, contract.getStatus());

      p.execute();
    }

  }

  public Athlete getAthlete(String athleteId, Connection con)
      throws SQLException {
    try {

      try (PreparedStatement p = con.prepareStatement(GET_ATHLETE_SQL)) {
        p.setString(1, athleteId);
        logger.info(GET_ATHLETE_SQL);
        logger.info("ok, no error here");
        try (ResultSet rs = p.executeQuery()) {
          logger.info("query should work");
          if (rs.next()) {
            return createAthlete(rs, con);
          }
          return null;
        }
      }
    }
    // used for select
    finally {
      con.rollback();
    }
  }

  public List<Athlete> getAllAthletes(Connection con) throws SQLException {
    try {

      try (PreparedStatement p = con.prepareStatement(GET_ATHLETE_LIST_SQL)) {
        logger.info("ok, no error here");
        try (ResultSet rs = p.executeQuery()) {
          logger.info("query should work");
          List<Athlete> athletes = new ArrayList<>();
          while (rs.next()) {
            athletes.add(createAthlete(rs, con));
          }
          return athletes;
        }
      }
    }
    // used for select
    finally {
      con.rollback();
    }
  }

  public List<Athlete> getAthletes(String teamId, Connection con)
      throws SQLException {
    try {

      try (PreparedStatement p = con
          .prepareStatement(GET_ATHLETES_FROM_TEAM_SQL)) {
        p.setString(1, teamId);
        logger.info(GET_ATHLETES_FROM_TEAM_SQL);
        logger.info("ok, no error here");
        List<Athlete> athletes = new ArrayList<>();
        try (ResultSet rs = p.executeQuery()) {
          logger.info("query should work");
          while (rs.next()) {
            athletes.add(createAthlete(rs, con));
          }
          return athletes;
        }
      }
    } finally {
      con.rollback();
    }
  }

  private Athlete createAthlete(ResultSet rs, Connection con)
      throws SQLException {
    String id = rs.getString("athlete_id");
    String teamId = rs.getString("current_team_id");
    String firstName = rs.getString("firstName");
    String lastName = rs.getString("lastName");
    int number = rs.getInt("jNumber");
    int age = rs.getInt("age");
    String pos = rs.getString("pos");
    int heightFeet = rs.getInt("heightFeet");
    int heightInches = rs.getInt("heightInches");
    int weightPounds = rs.getInt("weightPounds");
    String agentFirst = rs.getString("agentFirst");
    String agentLast = rs.getString("agentLast");
    String nation = rs.getString("nation");
    String birth = rs.getString("dob");
    List<Contract> contracts = new ArrayList<>();
    try (PreparedStatement p = con
        .prepareStatement(GET_CONTRACT_FROM_ATHLETE_SQL)) {
      p.setString(1, id);
      logger.info(GET_CONTRACT_FROM_ATHLETE_SQL);
      logger.info("ok, no error here");
      try (ResultSet rsp = p.executeQuery()) {
        logger.info("query should work");
        while (rsp.next()) {
          contracts.add(createContract(rsp));
        }
      }
    }
    return Athlete
        .builder()
          .withUuid(UUID.fromString(id))
          .withTeamID(UUID.fromString(teamId))
          .withFirstName(firstName)
          .withLastName(lastName)
          .withNumber(number)
          .withAge(age)
          .withPos(pos)
          .withHeightFeet(heightFeet)
          .withHeightInches(heightInches)
          .withWeightPounds(weightPounds)
          .withAgentFirstName(agentFirst)
          .withAgentLastName(agentLast)
          .withNationality(nation)
          .withDateOfBirth(birth)
          .withContracts(contracts)
          .build();

  }

  private Contract createContract(ResultSet rs) throws SQLException {
    String contract_id = rs.getString("contract_id");
    String athlete_id = rs.getString("player_id");
    int season = rs.getInt("first_season");
    String agent = rs.getString("agent");
    String team_id = rs.getString("team");
    int term = rs.getInt("term");
    BigDecimal value = rs.getBigDecimal("value");
    BigDecimal capHit = rs.getBigDecimal("capHit");
    BigDecimal percent = rs.getBigDecimal("percent_at_start");
    String status = rs.getString("status");
    return Contract
        .builder()
          .withAgentName(agent)
          .withAthleteId(UUID.fromString(athlete_id))
          .withCapHit(capHit)
          .withContractId(UUID.fromString(contract_id))
          .withFirstSeason(season)
          .withPercent(percent)
          .withStatus(status)
          .withTeamName(UUID.fromString(team_id))
          .withTerm(term)
          .withValue(value)
          .build();

  }

  public Athlete deleteAthlete(Connection con, String athleteId)
      throws SQLException {
    try {
      Athlete athlete = getAthlete(athleteId, con);
      try (PreparedStatement p = con.prepareStatement(DELETE_ATHLETE_SQL)) {
        p.setString(1, athleteId);
        p.execute();
      }
      return athlete;
    } finally {
      con.commit();
    }

  }

}
