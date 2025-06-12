package com.icecap.dto;

import java.util.Objects;
import java.util.UUID;

public class League {
  private UUID uuid;
  private String name;
  private String sport;
  private int founded;
  private String commissioner;
  private int teams;
  private int roster_limit;
  private double salary_cap;
  private int contract_limit;
  private int retained_limit;

  private League(Builder builder) {
    this.uuid = builder.uuid;
    this.name = builder.name;
    this.sport = builder.sport;
    this.founded = builder.founded;
    this.commissioner = builder.commissioner;
    this.teams = builder.teams;
    this.roster_limit = builder.roster_limit;
    this.salary_cap = builder.salary_cap;
    this.contract_limit = builder.contract_limit;
    this.retained_limit = builder.retained_limit;
  }

  public League() {

  }

  public UUID getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public String getSport() {
    return sport;
  }

  public int getFounded() {
    return founded;
  }

  public String getCommissioner() {
    return commissioner;
  }

  public int getTeams() {
    return teams;
  }

  public int getRoster_limit() {
    return roster_limit;
  }

  public double getSalary_cap() {
    return salary_cap;
  }

  public int getContract_limit() {
    return contract_limit;
  }

  public int getRetained_limit() {
    return retained_limit;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public int hashCode() {
    return Objects.hash(commissioner, contract_limit, founded, name, retained_limit, roster_limit, salary_cap, sport,
        teams, uuid);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    League other = (League) obj;
    return Objects.equals(commissioner, other.commissioner) && contract_limit == other.contract_limit
        && founded == other.founded && Objects.equals(name, other.name) && retained_limit == other.retained_limit
        && roster_limit == other.roster_limit
        && Double.doubleToLongBits(salary_cap) == Double.doubleToLongBits(other.salary_cap)
        && Objects.equals(sport, other.sport) && teams == other.teams && Objects.equals(uuid, other.uuid);
  }

  @Override
  public String toString() {
    return "League [uuid=" + uuid + ", name=" + name + ", sport=" + sport + ", founded=" + founded + ", commissioner="
        + commissioner + ", teams=" + teams + ", roster_limit=" + roster_limit + ", salary_cap=" + salary_cap
        + ", contract_limit=" + contract_limit + ", retained_limit=" + retained_limit + "]";
  }

  public static final class Builder {
    private UUID uuid;
    private String name;
    private String sport;
    private int founded;
    private String commissioner;
    private int teams;
    private int roster_limit;
    private double salary_cap;
    private int contract_limit;
    private int retained_limit;

    private Builder() {
    }

    public Builder withUuid(UUID uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withSport(String sport) {
      this.sport = sport;
      return this;
    }

    public Builder withFounded(int founded) {
      this.founded = founded;
      return this;
    }

    public Builder withCommissioner(String commissioner) {
      this.commissioner = commissioner;
      return this;
    }

    public Builder withTeams(int teams) {
      this.teams = teams;
      return this;
    }

    public Builder withRoster_limit(int roster_limit) {
      this.roster_limit = roster_limit;
      return this;
    }

    public Builder withSalary_cap(double salary_cap) {
      this.salary_cap = salary_cap;
      return this;
    }

    public Builder withContract_limit(int contract_limit) {
      this.contract_limit = contract_limit;
      return this;
    }

    public Builder withRetained_limit(int retained_limit) {
      this.retained_limit = retained_limit;
      return this;
    }

    public League build() {
      return new League(this);
    }
  }

}
