// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2017, 2024 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.hello.it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.icecap.dto.Athlete;
// end::import[]

// tag::endpointit[]
public class EndpointIT {
	private static String webURL;

	@BeforeAll
	// tag::init[]
	public static void init() {
		String port = System.getProperty("http.port");
		String context = System.getProperty("context.root");
		webURL = "http://localhost:" + port + "/" + context + "/" + "v2/athletes";
		System.out.println("URL: " + webURL);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testAPI() throws Exception {
		

		HttpClient client = HttpClient.newHttpClient();
		// @formatter:off
		UUID athleteID = UUID.randomUUID();
		Athlete athlete = Athlete.builder()
				.withUuid(athleteID)
				.withFirstName("Test")
				.withLastName("Athlete")
				.withNumber(1)
				.withAge(2)
				.withPos("55")
				.withHeightFeet(5)
				.withHeightInches(5)
				.withWeightPounds(5)
				.build();
		

		Gson gson = new Gson();
		String athleteJson = gson.toJson(athlete);
		// @formatter:on
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:9080/icecap/v2/athletes"))
				.POST(BodyPublishers.ofString(athleteJson)).setHeader("accept", "*/*")
				.setHeader("Content-Type", "application/json").build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		assertEquals(204, response.statusCode());
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:9080/icecap/v2/athletes/" + athleteID.toString()))
				.GET().setHeader("accept", "application/json").build();

		HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
		assertEquals(athleteJson, response2.body());



		// tag::try[]
		try {

		} finally {
			System.out.println("All done");
		}
		// end::try[]
	}
}
//end::endpointit[]
