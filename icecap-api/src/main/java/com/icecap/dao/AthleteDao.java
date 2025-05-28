package com.icecap.dao;

import java.util.HashMap;
import java.util.Map;

import com.icecap.dto.Athlete;

//TODO: make map
public class AthleteDao {
	private final static Map<Integer, Athlete> mapper = new HashMap<>();
	private  int id;

	public AthleteDao() {

		id = 1;
	}

	public void addAthlete(Athlete athlete) {


		// @formatter:on

		mapper.put(id, athlete);
		id++;
	}

	public Athlete getAthlete(int id) {
		return mapper.get(id);
	}

}
