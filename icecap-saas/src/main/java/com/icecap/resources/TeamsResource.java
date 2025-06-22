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
import java.util.Properties;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// tag::path[]
@Path("/v2/teams")
// end::path[]
// TODO: Write code to get and update information for a team
public class TeamsResource {

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	// tag::get[]
	@GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    // end::produces[]
    public Properties getPropertiesTeam() {
    	logger.info("get properties");
        return System.getProperties();
    }

//	@POST
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    // end::produces[]
//    public Properties addTeam() {
//    	logger.info("add team");
//        return System.getProperties();
//    }
//
//	@GET
//    @Path("/{team_id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    // end::produces[]
//    public Properties getTeamByID(@Parameter(required = true, description = "team identifier", name="team_id", in=ParameterIn.PATH) @PathParam("team_id") String teamId)
// {
//    	logger.info("get team by ID");
//        return System.getProperties();
//    }
//  

}
