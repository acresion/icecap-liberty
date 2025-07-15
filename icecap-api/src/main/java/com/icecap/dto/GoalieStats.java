package com.icecap.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

// develop the two classes, though don't do anything with them yet
public class GoalieStats {
  public UUID season_id;
  public UUID athlete_id;
  public int yearSkate;
  public UUID team_id;
  private int gamesPlayed;
  private int gamesStarted;
  private int wins;
  private int losses;
  private int overtimeLosses;
  private int shotsAgainst;
  private int saves;
  private int goalsAgainst;
  private BigDecimal gaa;
  private BigDecimal savePercent;
  private int shutouts;

  private GoalieStats(Builder builder) {
    this.season_id = builder.season_id;
    this.athlete_id = builder.athlete_id;
    this.yearSkate = builder.yearSkate;
    this.team_id = builder.team_id;
    this.gamesPlayed = builder.gamesPlayed;
    this.gamesStarted = builder.gamesStarted;
    this.wins = builder.wins;
    this.losses = builder.losses;
    this.overtimeLosses = builder.overtimeLosses;
    this.shotsAgainst = builder.shotsAgainst;
    this.saves = builder.saves;
    this.goalsAgainst = builder.goalsAgainst;
    this.gaa = builder.gaa;
    this.savePercent = builder.savePercent;
    this.shutouts = builder.shutouts;
  }

  public GoalieStats() {
    super();
  }

  public UUID getSeason_id() {
    return season_id;
  }

  public UUID getAthlete_id() {
    return athlete_id;
  }

  public int getYearSkate() {
    return yearSkate;
  }

  public UUID getTeam_id() {
    return team_id;
  }

  public int getGamesPlayed() {
    return gamesPlayed;
  }

  public int getGamesStarted() {
    return gamesStarted;
  }

  public int getWins() {
    return wins;
  }

  public int getLosses() {
    return losses;
  }

  public int getOvertimeLosses() {
    return overtimeLosses;
  }

  public int getShotsAgainst() {
    return shotsAgainst;
  }

  public int getSaves() {
    return saves;
  }

  public int getGoalsAgainst() {
    return goalsAgainst;
  }

  public BigDecimal getGaa() {
    return gaa;
  }

  public BigDecimal getSavePercent() {
    return savePercent;
  }

  public int getShutouts() {
    return shutouts;
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(athlete_id, gaa, gamesPlayed, gamesStarted, goalsAgainst, losses,
            overtimeLosses, savePercent, saves, season_id, shotsAgainst,
            shutouts, team_id, wins, yearSkate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GoalieStats other = (GoalieStats) obj;
    return Objects.equals(athlete_id, other.athlete_id)
        && Objects.equals(gaa, other.gaa) && gamesPlayed == other.gamesPlayed
        && gamesStarted == other.gamesStarted
        && goalsAgainst == other.goalsAgainst && losses == other.losses
        && overtimeLosses == other.overtimeLosses
        && Objects.equals(savePercent, other.savePercent)
        && saves == other.saves && Objects.equals(season_id, other.season_id)
        && shotsAgainst == other.shotsAgainst && shutouts == other.shutouts
        && Objects.equals(team_id, other.team_id) && wins == other.wins
        && yearSkate == other.yearSkate;
  }

  @Override
  public String toString() {
    return "GoalieStats [season_id=" + season_id + ", athlete_id=" + athlete_id
        + ", yearSkate=" + yearSkate + ", team_id=" + team_id + ", gamesPlayed="
        + gamesPlayed + ", gamesStarted=" + gamesStarted + ", wins=" + wins
        + ", losses=" + losses + ", overtimeLosses=" + overtimeLosses
        + ", shotsAgainst=" + shotsAgainst + ", saves=" + saves
        + ", goalsAgainst=" + goalsAgainst + ", gaa=" + gaa + ", savePercent="
        + savePercent + ", shutouts=" + shutouts + "]";
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID season_id;
    private UUID athlete_id;
    private int yearSkate;
    private UUID team_id;
    private int gamesPlayed;
    private int gamesStarted;
    private int wins;
    private int losses;
    private int overtimeLosses;
    private int shotsAgainst;
    private int saves;
    private int goalsAgainst;
    private BigDecimal gaa;
    private BigDecimal savePercent;
    private int shutouts;

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

    public Builder withYearSkate(int yearSkate) {
      this.yearSkate = yearSkate;
      return this;
    }

    public Builder withTeam_id(UUID team_id) {
      this.team_id = team_id;
      return this;
    }

    public Builder withGamesPlayed(int gamesPlayed) {
      this.gamesPlayed = gamesPlayed;
      return this;
    }

    public Builder withGamesStarted(int gamesStarted) {
      this.gamesStarted = gamesStarted;
      return this;
    }

    public Builder withWins(int wins) {
      this.wins = wins;
      return this;
    }

    public Builder withLosses(int losses) {
      this.losses = losses;
      return this;
    }

    public Builder withOvertimeLosses(int overtimeLosses) {
      this.overtimeLosses = overtimeLosses;
      return this;
    }

    public Builder withShotsAgainst(int shotsAgainst) {
      this.shotsAgainst = shotsAgainst;
      return this;
    }

    public Builder withSaves(int saves) {
      this.saves = saves;
      return this;
    }

    public Builder withGoalsAgainst(int goalsAgainst) {
      this.goalsAgainst = goalsAgainst;
      return this;
    }

    public Builder withGaa(BigDecimal gaa) {
      this.gaa = gaa;
      return this;
    }

    public Builder withSavePercent(BigDecimal savePercent) {
      this.savePercent = savePercent;
      return this;
    }

    public Builder withShutouts(int shutouts) {
      this.shutouts = shutouts;
      return this;
    }

    public GoalieStats build() {
      return new GoalieStats(this);
    }
  }

}
