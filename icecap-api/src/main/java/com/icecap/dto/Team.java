package com.icecap.dto;

import java.util.Objects;
import java.util.UUID;

public class Team {
  private UUID uuid;
  private String teamName;
  private int yearFounded;
  private String conference;
  private String division;
  private String gmName;
  private String coachName;
  private String captain;
  private int capHit;
  private int capSpace;
  private int active;

  private Team(Builder builder) {
    this.uuid = builder.uuid;
    this.teamName = builder.teamName;
    this.yearFounded = builder.yearFounded;
    this.conference = builder.conference;
    this.division = builder.division;
    this.gmName = builder.gmName;
    this.coachName = builder.coachName;
    this.captain = builder.captain;
    this.capHit = builder.capHit;
    this.capSpace = builder.capSpace;
    this.active = builder.active;
  }

  public Team() {
    super();
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public int getYearFounded() {
    return yearFounded;
  }

  public void setYearFounded(int yearFounded) {
    this.yearFounded = yearFounded;
  }

  public String getConference() {
    return conference;
  }

  public void setConference(String conference) {
    this.conference = conference;
  }

  public String getDivision() {
    return division;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  public String getGmName() {
    return gmName;
  }

  public void setGmName(String gmName) {
    this.gmName = gmName;
  }

  public String getCoachName() {
    return coachName;
  }

  public void setCoachName(String coachName) {
    this.coachName = coachName;
  }

  public String getCaptain() {
    return captain;
  }

  public void setCaptain(String captain) {
    this.captain = captain;
  }

  public int getCapHit() {
    return capHit;
  }

  public void setCapHit(int capHit) {
    this.capHit = capHit;
  }

  public int getCapSpace() {
    return capSpace;
  }

  public void setCapSpace(int capSpace) {
    this.capSpace = capSpace;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, capHit, capSpace, captain, coachName, conference, division, gmName, teamName, uuid,
        yearFounded);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Team other = (Team) obj;
    return active == other.active && capHit == other.capHit && capSpace == other.capSpace
        && Objects.equals(captain, other.captain) && Objects.equals(coachName, other.coachName)
        && Objects.equals(conference, other.conference) && Objects.equals(division, other.division)
        && Objects.equals(gmName, other.gmName) && Objects.equals(teamName, other.teamName)
        && Objects.equals(uuid, other.uuid) && yearFounded == other.yearFounded;
  }

  @Override
  public String toString() {
    return "Team [uuid=" + uuid + ", teamName=" + teamName + ", yearFounded=" + yearFounded + ", conference="
        + conference + ", division=" + division + ", gmName=" + gmName + ", coachName=" + coachName + ", captain="
        + captain + ", capHit=" + capHit + ", capSpace=" + capSpace + ", active=" + active + "]";
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID uuid;
    private String teamName;
    private int yearFounded;
    private String conference;
    private String division;
    private String gmName;
    private String coachName;
    private String captain;
    private int capHit;
    private int capSpace;
    private int active;

    private Builder() {
    }

    public Builder withUuid(UUID uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder withTeamName(String teamName) {
      this.teamName = teamName;
      return this;
    }

    public Builder withYearFounded(int yearFounded) {
      this.yearFounded = yearFounded;
      return this;
    }

    public Builder withConference(String conference) {
      this.conference = conference;
      return this;
    }

    public Builder withDivision(String division) {
      this.division = division;
      return this;
    }

    public Builder withGmName(String gmName) {
      this.gmName = gmName;
      return this;
    }

    public Builder withCoachName(String coachName) {
      this.coachName = coachName;
      return this;
    }

    public Builder withCaptain(String captain) {
      this.captain = captain;
      return this;
    }

    public Builder withCapHit(int capHit) {
      this.capHit = capHit;
      return this;
    }

    public Builder withCapSpace(int capSpace) {
      this.capSpace = capSpace;
      return this;
    }

    public Builder withActive(int active) {
      this.active = active;
      return this;
    }

    public Team build() {
      return new Team(this);
    }
  }


}
