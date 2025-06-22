package com.icecap.dto;

import java.util.Objects;
import java.util.UUID;

public class SkaterStats {
  private UUID season_id;
  private UUID athlete_id;
  private int year;
  private UUID team_id;
  private int games;
  private int goals;
  private int assists;
  private int points;
  private int plusMinus;
  private int penaltyMinutes;
  private int evenStrengthGoals;
  private int evenStrengthPoints;
  private int powerPlayGoals;
  private int powerPlayPoints;
  private int shots;

  private SkaterStats(Builder builder) {
    this.season_id = builder.season_id;
    this.athlete_id = builder.athlete_id;
    this.year = builder.year;
    this.team_id = builder.team_id;
    this.games = builder.games;
    this.goals = builder.goals;
    this.assists = builder.assists;
    this.points = builder.points;
    this.plusMinus = builder.plusMinus;
    this.penaltyMinutes = builder.penaltyMinutes;
    this.evenStrengthGoals = builder.evenStrengthGoals;
    this.evenStrengthPoints = builder.evenStrengthPoints;
    this.powerPlayGoals = builder.powerPlayGoals;
    this.powerPlayPoints = builder.powerPlayPoints;
    this.shots = builder.shots;
  }

  public SkaterStats() {
    super();
  }

  public UUID getSeason_id() {
    return season_id;
  }

  public UUID getAthlete_id() {
    return athlete_id;
  }

  public int getYear() {
    return year;
  }

  public UUID getTeam_id() {
    return team_id;
  }

  public int getGames() {
    return games;
  }

  public int getGoals() {
    return goals;
  }

  public int getAssists() {
    return assists;
  }

  public int getPoints() {
    return points;
  }

  public int getPlusMinus() {
    return plusMinus;
  }

  public int getPenaltyMinutes() {
    return penaltyMinutes;
  }

  public int getEvenStrengthGoals() {
    return evenStrengthGoals;
  }

  public int getEvenStrengthPoints() {
    return evenStrengthPoints;
  }

  public int getPowerPlayGoals() {
    return powerPlayGoals;
  }

  public int getPowerPlayPoints() {
    return powerPlayPoints;
  }

  public int getShots() {
    return shots;
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(assists, athlete_id, evenStrengthGoals, evenStrengthPoints, games,
            goals, penaltyMinutes, plusMinus, points, powerPlayGoals,
            powerPlayPoints, season_id, shots, team_id, year);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SkaterStats other = (SkaterStats) obj;
    return assists == other.assists
        && Objects.equals(athlete_id, other.athlete_id)
        && evenStrengthGoals == other.evenStrengthGoals
        && evenStrengthPoints == other.evenStrengthPoints
        && games == other.games && goals == other.goals
        && penaltyMinutes == other.penaltyMinutes
        && plusMinus == other.plusMinus && points == other.points
        && powerPlayGoals == other.powerPlayGoals
        && powerPlayPoints == other.powerPlayPoints
        && Objects.equals(season_id, other.season_id) && shots == other.shots
        && Objects.equals(team_id, other.team_id) && year == other.year;
  }

  @Override
  public String toString() {
    return "SkaterStats [season_id=" + season_id + ", athlete_id=" + athlete_id
        + ", year=" + year + ", team_id=" + team_id + ", games=" + games
        + ", goals=" + goals + ", assists=" + assists + ", points=" + points
        + ", plusMinus=" + plusMinus + ", penaltyMinutes=" + penaltyMinutes
        + ", evenStrengthGoals=" + evenStrengthGoals + ", evenStrengthPoints="
        + evenStrengthPoints + ", powerPlayGoals=" + powerPlayGoals
        + ", powerPlayPoints=" + powerPlayPoints + ", shots=" + shots + "]";
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID season_id;
    private UUID athlete_id;
    private int year;
    private UUID team_id;
    private int games;
    private int goals;
    private int assists;
    private int points;
    private int plusMinus;
    private int penaltyMinutes;
    private int evenStrengthGoals;
    private int evenStrengthPoints;
    private int powerPlayGoals;
    private int powerPlayPoints;
    private int shots;

    private Builder() {
    }

    public Builder withSeason_id(UUID season_id) {
      this.season_id = season_id;
      return this;
    }

    public Builder withAthlete_id(UUID athlete_id) {
      this.athlete_id = athlete_id;
      return this;
    }

    public Builder withYear(int year) {
      this.year = year;
      return this;
    }

    public Builder withTeam_id(UUID team_id) {
      this.team_id = team_id;
      return this;
    }

    public Builder withGames(int games) {
      this.games = games;
      return this;
    }

    public Builder withGoals(int goals) {
      this.goals = goals;
      return this;
    }

    public Builder withAssists(int assists) {
      this.assists = assists;
      return this;
    }

    public Builder withPoints(int points) {
      this.points = points;
      return this;
    }

    public Builder withPlusMinus(int plusMinus) {
      this.plusMinus = plusMinus;
      return this;
    }

    public Builder withPenaltyMinutes(int penaltyMinutes) {
      this.penaltyMinutes = penaltyMinutes;
      return this;
    }

    public Builder withEvenStrengthGoals(int evenStrengthGoals) {
      this.evenStrengthGoals = evenStrengthGoals;
      return this;
    }

    public Builder withEvenStrengthPoints(int evenStrengthPoints) {
      this.evenStrengthPoints = evenStrengthPoints;
      return this;
    }

    public Builder withPowerPlayGoals(int powerPlayGoals) {
      this.powerPlayGoals = powerPlayGoals;
      return this;
    }

    public Builder withPowerPlayPoints(int powerPlayPoints) {
      this.powerPlayPoints = powerPlayPoints;
      return this;
    }

    public Builder withShots(int shots) {
      this.shots = shots;
      return this;
    }

    public SkaterStats build() {
      return new SkaterStats(this);
    }
  }

}
