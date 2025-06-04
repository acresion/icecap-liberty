// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2017, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
// end::copyright[]
package com.icecap.resources;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import com.icecap.app.IcecapApplication;
import com.icecap.config.IceCapConfig;
import com.icecap.dao.AthleteDao;
import com.icecap.dao.ConnectionToSQL;
import com.icecap.dto.Athlete;
// tag::path[]
@Path("/v2/athletes")
// end::path[]
public class AthleteResource {


	private final IceCapConfig config;
	private final ConnectionToSQL con;

	public AthleteResource(@Context IcecapApplication app) {
		this.config = app.getConfig();
		this.con = new ConnectionToSQL(this.config.getMySqlConfig());
	}


	private AthleteDao athleteDao = new AthleteDao();

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	// tag::get[]
	@GET
	@Path("/getProperties")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	public Properties getPropertiesAthlete() {
		logger.info(config.getMySqlConfig().toString());
		return System.getProperties();
	}

	@GET
	@Path("/getEnv")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	public Map<String, String> getEnvironmentAthlete() {
		logger.info(config.getMySqlConfig().toString());
		return System.getenv();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	public void addAthlete(Athlete athlete) throws SQLException {
		logger.info("moment before disaster");
		try (Connection connect = con.connect()) {
			logger.info("connection to server done");
			athleteDao.addAthlete(athlete, connect);
		}


	}

	@GET
	@Path("/{athlete_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	// TODO change this to Athlete (make up ob
	public Athlete getAthleteByID(
			@Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId)
			throws SQLException {
		try (Connection connect = con.connect()) {
			logger.info("get athlete by ID");
			Athlete athlete = athleteDao.getAthlete(athleteId, connect);
			return athlete;
		}

	}

}
