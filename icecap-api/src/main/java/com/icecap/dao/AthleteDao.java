package com.icecap.dao;
import java.util.HashMap;
import java.util.Map;

import com.icecap.dto.Athlete;



public class AthleteDao {
	// TODO: This map is temporary. Now, we should manage to make a connection to
	// the database using JDBC (you can interpret code from a separate project)
	private static final String INSERT_LANDLORD_SQL = "insert into Landlord values(?,?,?,?,?)";
	private static final String GET_LANDLORD_SQL = "SELECT  " + "landlordId" + ", buildingName"
			+ ", buildingNumberOfRooms" + ", buildingNumberOfStories" + ", rent"
			+ "FROM rentalDataBase.Landlord WHERE landlordID = ?";
	private final static Map<String, Athlete> mapper = new HashMap<>();

	public AthleteDao() {

	}

	public void addAthlete(Athlete athlete) {


		// @formatter:on

		mapper.put(athlete.getUuid().toString(), athlete);
	}

	public Athlete getAthlete(String athleteId) {
		return mapper.get(athleteId);
	}

}
