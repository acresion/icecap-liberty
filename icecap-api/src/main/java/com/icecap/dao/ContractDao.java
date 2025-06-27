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

import com.icecap.dto.Contract;

public class ContractDao {
  private static final String INSERT_CONTRACT_SQL = "insert into contract_info values(?,?,?,?,?,?,?,?,?,?)";
  private static final Logger logger = Logger
      .getLogger(MethodHandles.lookup().lookupClass().getName());
  private static final String GET_ALL_CONTRACTS_SQL = """
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
            """;

  private static final String GET_CONTRACT_SQL = """
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
        where contract_id = ?
            """;
  private static final String DELETE_CONTRACT_SQL = """
      delete from icecap.contract_info where contract_id = ?
            """;

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

  public List<Contract> getContractList(Connection con) throws SQLException {

    try {
      try (PreparedStatement p = con.prepareStatement(GET_ALL_CONTRACTS_SQL)) {
        try (ResultSet rs = p.executeQuery()) {
          List<Contract> contract = new ArrayList<>();
          while (rs.next()) {
            contract.add(createContract(rs));
          }
          return contract;
        }
      }
    }
    // used for select
    finally {
      con.rollback();
    }

  }

  public Contract getContract(String contractId, Connection con)
      throws SQLException {
    try {

      try (PreparedStatement p = con.prepareStatement(GET_CONTRACT_SQL)) {
        p.setString(1, contractId);
        logger.info(GET_CONTRACT_SQL);
        try (ResultSet rs = p.executeQuery()) {
          if (rs.next()) {
            return createContract(rs);
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

  public Contract deleteContract(Connection con, String contractId)
      throws SQLException {
    try {
      Contract contract = getContract(contractId, con);
      try (PreparedStatement p = con.prepareStatement(DELETE_CONTRACT_SQL)) {
        p.setString(1, contractId);
        p.execute();
      }
      return contract;
    } finally {
      con.commit();
    }

  }
}
