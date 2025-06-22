package com.icecap.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

//TODO: add properties to here and add features where you get athlete from DAO, and return json
//TODO: how to download liberty manually and restart project (readme)
@JsonDeserialize(builder = Athlete.Builder.class)
public class Athlete {
	private UUID uuid;
  private UUID teamID;
	private String firstName;
	private String lastName;
	private int number;
	private int age;
	private String pos;
	private int heightFeet;
	private int heightInches;
	private int weightPounds;
  private String agentFirstName;
  private String agentLastName;
  private String nationality;
  private String dateOfBirth;
  private List<Contract> contracts;

  private Athlete(Builder builder) {
    this.uuid = builder.uuid;
    this.teamID = builder.teamID;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.number = builder.number;
    this.age = builder.age;
    this.pos = builder.pos;
    this.heightFeet = builder.heightFeet;
    this.heightInches = builder.heightInches;
    this.weightPounds = builder.weightPounds;
    this.agentFirstName = builder.agentFirstName;
    this.agentLastName = builder.agentLastName;
    this.nationality = builder.nationality;
    this.dateOfBirth = builder.dateOfBirth;
    this.contracts = builder.contracts;
  }

  public Athlete() {
    contracts = new ArrayList<>();
  }

  public UUID getUuid() {
    return uuid;
  }

  public UUID getTeamID() {
    return teamID;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getNumber() {
    return number;
  }

  public int getAge() {
    return age;
  }

  public String getPos() {
    return pos;
  }

  public int getHeightFeet() {
    return heightFeet;
  }

  public int getHeightInches() {
    return heightInches;
  }

  public int getWeightPounds() {
    return weightPounds;
  }

  public String getAgentFirstName() {
    return agentFirstName;
  }

  public String getAgentLastName() {
    return agentLastName;
  }

  public String getNationality() {
    return nationality;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, agentFirstName, agentLastName, contracts, dateOfBirth, firstName, heightFeet, heightInches,
        lastName, nationality, number, pos, teamID, uuid, weightPounds);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Athlete other = (Athlete) obj;
    return age == other.age && Objects.equals(agentFirstName, other.agentFirstName)
        && Objects.equals(agentLastName, other.agentLastName) && Objects.equals(contracts, other.contracts)
        && Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
        && heightFeet == other.heightFeet && heightInches == other.heightInches
        && Objects.equals(lastName, other.lastName) && Objects.equals(nationality, other.nationality)
        && number == other.number && Objects.equals(pos, other.pos) && Objects.equals(teamID, other.teamID)
        && Objects.equals(uuid, other.uuid) && weightPounds == other.weightPounds;
  }

  @Override
  public String toString() {
    return "Athlete [uuid=" + uuid + ", teamID=" + teamID + ", firstName=" + firstName + ", lastName=" + lastName
        + ", number=" + number + ", age=" + age + ", pos=" + pos + ", heightFeet=" + heightFeet + ", heightInches="
        + heightInches + ", weightPounds=" + weightPounds + ", agentFirstName=" + agentFirstName + ", agentLastName="
        + agentLastName + ", nationality=" + nationality + ", dateOfBirth=" + dateOfBirth + ", contracts=" + contracts
        + "]";
  }


  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
  public static final class Builder {

    private UUID uuid;
    private UUID teamID;
    private String firstName;
    private String lastName;
    private int number;
    private int age;
    private String pos;
    private int heightFeet;
    private int heightInches;
    private int weightPounds;
    private String agentFirstName;
    private String agentLastName;
    private String nationality;
    private String dateOfBirth;
    private List<Contract> contracts = new ArrayList<>();


    private Builder() {
    }

    public Builder withUuid(UUID uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder withTeamID(UUID teamID) {
      this.teamID = teamID;
      return this;
    }

    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder withNumber(int number) {
      this.number = number;
      return this;
    }

    public Builder withAge(int age) {
      this.age = age;
      return this;
    }

    public Builder withPos(String pos) {
      this.pos = pos;
      return this;
    }

    public Builder withHeightFeet(int heightFeet) {
      this.heightFeet = heightFeet;
      return this;
    }

    public Builder withHeightInches(int heightInches) {
      this.heightInches = heightInches;
      return this;
    }

    public Builder withWeightPounds(int weightPounds) {
      this.weightPounds = weightPounds;
      return this;
    }

    public Builder withAgentFirstName(String agentFirstName) {
      this.agentFirstName = agentFirstName;
      return this;
    }

    public Builder withAgentLastName(String agentLastName) {
      this.agentLastName = agentLastName;
      return this;
    }

    public Builder withNationality(String nationality) {
      this.nationality = nationality;
      return this;
    }

    public Builder withDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder withContracts(List<Contract> contracts) {
      this.contracts = contracts;
      return this;
    }

    public Athlete build() {
      return new Athlete(this);
    }
  }



}