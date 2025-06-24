package com.icecap.resources;

import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import com.icecap.app.IcecapApplication;
import com.icecap.config.IceCapConfig;
import com.icecap.dao.ConnectionToSQL;
import com.icecap.dao.IcecapController;
import com.icecap.dao.LeagueDao;
import com.icecap.dto.Athlete;
import com.icecap.dto.Contract;
import com.icecap.dto.League;
import com.icecap.dto.Team;


@Path("/v2/leagues")
public class LeagueResource {
  private final IceCapConfig config;
  private final ConnectionToSQL con;
  private final IcecapController controller;

// TODO: Update code for league
  public LeagueResource(@Context IcecapApplication app) {
    this.config = app.getConfig();
    this.con = new ConnectionToSQL(this.config.getMySqlConfig());
    this.controller = new IcecapController(config);
  }

  private LeagueDao leagueDao = new LeagueDao();

  private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

  @GET
  @Path("/exceptionTest")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void testException() throws SQLException {
    // TODO: figure out how expections become REST payloads

    controller.testForException();

  }


  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void addLeague(League league) throws SQLException {
    // TODO: figure out how expections become REST payloads

    controller.addLeague(league);


  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public List<League> getLeagues() throws SQLException {
    // TODO: figure out how expections become REST payloads
    return controller.getLeagues();
  }

  @GET
  @Path("/{league_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public League getLeagueByID(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId)
      throws SQLException {
    return controller.getLeagueByID(leagueId);
  }

  // might need to investigate this, as with no league comes no teams, athletes or
  // contracts.
  @DELETE
  @Path("/{league_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public League deleteLeagueByID(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId)
      throws SQLException {
    return controller.deleteLeagueByID(leagueId);
  }

  @PUT
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void upsertLeague(League league) throws SQLException {
    // TODO: figure out how expections become REST payloads
    controller.upsertLeague(league);
  }

//--
  @POST
  @Path("/{league_id}/teams")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void addTeam(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      Team team) throws SQLException {
    // TODO: figure out how expections become REST payloads
    controller.addTeam(leagueId, team);
  }

  @GET
  @Path("/{league_id}/teams")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public List<Team> getTeams(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding league here");
    return controller.getTeams(leagueId);
  }

  @GET
  @Path("/{league_id}/teams/{team_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public Team getTeamByID(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId)
      throws SQLException {
    return controller.getTeamByID(leagueId, teamId);
  }

  @DELETE
  @Path("/{league_id}/teams/{team_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public Team deleteTeamByID(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId)
      throws SQLException {
    return controller.deleteTeamByID(leagueId, teamId);
  }

  @PUT
  @Path("/{league_id}/teams")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void upsertTeam(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      Team team) throws SQLException {
    // TODO: figure out how expections become REST payloads
    controller.upsertTeam(leagueId, team);
  }

  @POST
  @Path("/{league_id}/teams/{team_id}/athlete")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void addAthlete(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      Athlete athlete)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    controller.addAthlete(leagueId, teamId, athlete);
  }

  @GET
  @Path("/{league_id}/teams/{team_id}/athlete")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public List<Athlete> getAthletes(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId
)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding athlete here");
    return controller.getAthletes(leagueId, teamId);
  }

  @GET
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public Athlete getAthlete(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("get athlete here");
    return controller.getAthlete(leagueId, teamId, athleteId);
  }

  @DELETE
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public Athlete deleteAthlete(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("delete athlete here");
    return controller.deleteAthlete(leagueId, teamId, athleteId);
  }

  @PUT
  @Path("/{league_id}/teams/{team_id}/athlete")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void upsertAthlete(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      Athlete athlete) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("upsert athlete here");
    controller.upsertAthlete(leagueId, teamId, athlete);
  }

  @POST
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}/contract")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void addContract(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId,

      Contract contract) throws SQLException {
    // TODO: figure out how expections become REST payloads
    controller.addContract(leagueId, teamId, athleteId, contract);
  }

  @GET
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}/contract")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public List<Contract> getContracts(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("get list of contracts here");
    return controller.getContracts(leagueId, teamId, athleteId);
  }

  @GET
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}/contract/{contract_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public Contract getContract(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId,
      @Parameter(required = true, description = "contract identifier", name = "contract_id", in = ParameterIn.PATH) @PathParam("contract_id") String contractId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("get contract here");
    return controller.getContract(leagueId, teamId, athleteId, contractId);
  }

  @DELETE
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}/contract/{contract_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public Contract deleteContract(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId,
      @Parameter(required = true, description = "contract identifier", name = "contract_id", in = ParameterIn.PATH) @PathParam("contract_id") String contractId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("delete contract here");
    return controller.deleteContract(leagueId, teamId, athleteId, contractId);

  }

  @PUT
  @Path("/{league_id}/teams/{team_id}/athlete/{athlete_id}/contract")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void upsertContract(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId,
      @Parameter(required = true, description = "team identifier", name = "team_id", in = ParameterIn.PATH) @PathParam("team_id") String teamId,
      @Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId)
      throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("upsert contract here");
    controller.upsertContract(leagueId, teamId, athleteId);
  }

}
