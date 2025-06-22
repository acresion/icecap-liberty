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
package com.icecap.app;



import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import com.icecap.config.IceCapConfig;
import com.icecap.resources.LeagueResource;


@OpenAPIDefinition(
		info = @Info(title = "Icecap API", version="1.0.0"))
@ApplicationPath("/*")
public class IcecapApplication extends Application {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	private final IceCapConfig config;

	// dont link integration tests to check
	public IcecapApplication() {
		super();
		logger.info("icecap app init");
		this.config = new IceCapConfig(System.getenv());
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		logger.info("icecap get classes");
    // classes.add(TeamsResource.class);
    // classes.add(AthleteResource.class);
    classes.add(LeagueResource.class);
		return classes;
	}

	public IceCapConfig getConfig() {
		return config;
	}

}
