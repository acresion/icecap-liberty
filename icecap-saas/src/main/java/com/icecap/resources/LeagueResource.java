package com.icecap.resources;

import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.icecap.dao.LeagueDao;
import com.icecap.dto.League;
import com.icecap.dto.Team;

@Path("/v2/leagues")
public class LeagueResource {
  private final IceCapConfig config;
  private final ConnectionToSQL con;

// TODO: Update code for league
  public LeagueResource(@Context IcecapApplication app) {
    this.config = app.getConfig();
    this.con = new ConnectionToSQL(this.config.getMySqlConfig());
  }

  private LeagueDao leagueDao = new LeagueDao();

  private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());


  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void addLeague(League league) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding league here");
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public List<League> getLeagues() throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("adding league here");
    return new ArrayList<>();
  }

  @GET
  @Path("/{league_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public League getLeagueByID(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId)
      throws SQLException {
    return null;
  }

  @DELETE
  @Path("/{league_id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public League deletegetLeagueByID(
      @Parameter(required = true, description = "league identifier", name = "league_id", in = ParameterIn.PATH) @PathParam("league_id") String leagueId)
      throws SQLException {
    return null;
  }

  @PUT
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  // end::produces[]
  public void upsertLeague(League league) throws SQLException {
    // TODO: figure out how expections become REST payloads
    logger.info("upsert league here");
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
    logger.info("adding league here");
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
    return new ArrayList<>();
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
    return null;
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
    return null;
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
    logger.info("upsert team here");
  }

}
