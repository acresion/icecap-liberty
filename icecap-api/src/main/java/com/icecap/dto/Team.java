package com.icecap.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Team {
  private UUID uuid;
  private UUID team_id;
  private String teamName;
  private int yearFounded;
  private String conference;
  private String division;
  private String gmName;
  private String coachName;
  private String captain;
  private BigDecimal capHit;
  private BigDecimal capSpace;
  private int active;
  private int retained;
  private String owner;
  private String website;
  private Team(Builder builder) {
    this.uuid = builder.uuid;
    this.team_id = builder.team_id;
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
    this.retained = builder.retained;
    this.owner = builder.owner;
    this.website = builder.website;
  }

  public Team() {
  };

  public UUID getUuid() {
    return uuid;
  }

  public UUID getTeam_id() {
    return team_id;
  }

  public String getTeamName() {
    return teamName;
  }

  public int getYearFounded() {
    return yearFounded;
  }

  public String getConference() {
    return conference;
  }

  public String getDivision() {
    return division;
  }

  public String getGmName() {
    return gmName;
  }

  public String getCoachName() {
    return coachName;
  }

  public String getCaptain() {
    return captain;
  }

  public BigDecimal getCapHit() {
    return capHit;
  }

  public BigDecimal getCapSpace() {
    return capSpace;
  }

  public int getActive() {
    return active;
  }

  public int getRetained() {
    return retained;
  }

  public String getOwner() {
    return owner;
  }

  public String getWebsite() {
    return website;
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, capHit, capSpace, captain, coachName, conference, division, gmName, owner, retained,
        teamName, team_id, uuid, website, yearFounded);
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
    return active == other.active && Objects.equals(capHit, other.capHit) && Objects.equals(capSpace, other.capSpace)
        && Objects.equals(captain, other.captain) && Objects.equals(coachName, other.coachName)
        && Objects.equals(conference, other.conference) && Objects.equals(division, other.division)
        && Objects.equals(gmName, other.gmName) && Objects.equals(owner, other.owner) && retained == other.retained
        && Objects.equals(teamName, other.teamName) && Objects.equals(team_id, other.team_id)
        && Objects.equals(uuid, other.uuid) && Objects.equals(website, other.website)
        && yearFounded == other.yearFounded;
  }

  @Override
  public String toString() {
    return "Team [uuid=" + uuid + ", team_id=" + team_id + ", teamName=" + teamName + ", yearFounded=" + yearFounded
        + ", conference=" + conference + ", division=" + division + ", gmName=" + gmName + ", coachName=" + coachName
        + ", captain=" + captain + ", capHit=" + capHit + ", capSpace=" + capSpace + ", active=" + active
        + ", retained=" + retained + ", owner=" + owner + ", website=" + website + "]";
  }

  public static Builder builder() {
    return new Builder();
  }
  public static final class Builder {
    private UUID uuid;
    private UUID team_id;
    private String teamName;
    private int yearFounded;
    private String conference;
    private String division;
    private String gmName;
    private String coachName;
    private String captain;
    private BigDecimal capHit;
    private BigDecimal capSpace;
    private int active;
    private int retained;
    private String owner;
    private String website;

    private Builder() {
    }

    public Builder withUuid(UUID uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder withTeam_id(UUID team_id) {
      this.team_id = team_id;
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

    public Builder withCapHit(BigDecimal capHit) {
      this.capHit = capHit;
      return this;
    }

    public Builder withCapSpace(BigDecimal capSpace) {
      this.capSpace = capSpace;
      return this;
    }

    public Builder withActive(int active) {
      this.active = active;
      return this;
    }

    public Builder withRetained(int retained) {
      this.retained = retained;
      return this;
    }

    public Builder withOwner(String owner) {
      this.owner = owner;
      return this;
    }

    public Builder withWebsite(String website) {
      this.website = website;
      return this;
    }

    public Team build() {
      return new Team(this);
    }
  }
  
  




}
