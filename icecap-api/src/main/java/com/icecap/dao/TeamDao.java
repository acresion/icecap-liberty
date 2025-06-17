package com.icecap.dao;

import java.util.HashMap;
import java.util.Map;

import com.icecap.dto.Team;

//todo
public class TeamDao {
  Map<String, Team> mapper = new HashMap<>();

  public TeamDao() {

  }
  
  public void addTeam(Team team) {
    mapper.put(team.getUuid().toString(), team);
  }

  public Team getTeam(String teamId) {
    return mapper.get(teamId);
  }


}
