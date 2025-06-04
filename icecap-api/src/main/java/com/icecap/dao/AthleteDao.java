package com.icecap.dao;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import com.icecap.dto.Athlete;

public class AthleteDao {
	// TODO: This map is temporary. Now, we should manage to make a connection to
	// the database using JDBC (you can interpret code from a separate project)
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
	private static final String INSERT_ATHLETE_SQL = "insert into athlete values(?,?,?,?,?,?,?,?,?)";

	private static final String GET_ATHLETE_SQL = "select " + " id " + ", firstName" + ", lastName" + ", jNumber"
			+ ", age" + ", pos" + ", heightFeet " + ", heightInches" + ", weightPounds"
			+ " from icecap.athlete where id = ?";

	private final static Map<String, Athlete> mapper = new HashMap<>();

	public AthleteDao() {

	}

	public void addAthlete(Athlete athlete, Connection con) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(INSERT_ATHLETE_SQL)) {

			p.setString(1, athlete.getUuid().toString());
			p.setString(2, athlete.getFirstName());
			p.setString(3, athlete.getLastName());
			p.setInt(4, athlete.getNumber());
			p.setInt(5, athlete.getAge());
			p.setString(6, athlete.getPos());
			p.setInt(7, athlete.getHeightFeet());
			p.setInt(8, athlete.getHeightInches());
			p.setInt(9, athlete.getWeightPounds());
			p.execute();

		}

	}

	public Athlete getAthlete(String athleteId, Connection con) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(GET_ATHLETE_SQL)) {
			p.setString(1, athleteId);
			logger.info(GET_ATHLETE_SQL);
			logger.info("ok, no error here");
			try (ResultSet rs = p.executeQuery()) {
				logger.info("query should work");
				if (rs.next()) {
					return createAthlete(rs);
				}
				return null;

			}

		}
	}

	private Athlete createAthlete(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		int number = rs.getInt("jNumber");
		int age = rs.getInt("age");
		String pos = rs.getString("pos");
		int heightFeet = rs.getInt("heightFeet");
		int heightInches = rs.getInt("heightInches");
		int weightPounds = rs.getInt("weightPounds");
		return Athlete.builder().withUuid(UUID.fromString(id)).withFirstName(firstName).withLastName(lastName)
				.withNumber(number).withAge(age).withPos(pos).withHeightFeet(heightFeet).withHeightInches(heightInches)
				.withWeightPounds(weightPounds).build();

	}

}
