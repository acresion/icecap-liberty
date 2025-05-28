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
package io.openliberty.guides.rest;

import java.lang.invoke.MethodHandles;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import com.icecap.dao.AthleteDao;
import com.icecap.dto.Athlete;

// tag::path[]
@Path("/v2/athletes")
// end::path[]
public class AthleteResource {
	private AthleteDao athleteDao = new AthleteDao();

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	// tag::get[]
	@GET
	@Path("/getProperties")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	public Properties getPropertiesAthlete() {
		logger.info("get properties");
		return System.getProperties();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	public void addAthlete(Athlete athlete) {

		athleteDao.addAthlete(athlete);

	}

	@GET
	@Path("/{athlete_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// end::produces[]
	// TODO change this to Athlete (make up ob
	public Athlete getAthleteByID(
			@Parameter(required = true, description = "athlete identifier", name = "athlete_id", in = ParameterIn.PATH) @PathParam("athlete_id") String athleteId) {
		logger.info("get athlete by ID");
		Athlete athlete = athleteDao.getAthlete(Integer.parseInt(athleteId));
		return athlete;

	}

}
