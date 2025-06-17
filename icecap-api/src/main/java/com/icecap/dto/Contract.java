package com.icecap.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Contract {
  private UUID contractId;
  private UUID athleteId;
  private int firstSeason;
  private String agentName;
  private UUID teamName;
  private int term;
  private BigDecimal value;
  private BigDecimal capHit;
  private BigDecimal percent;
  private String status;

  private Contract(Builder builder) {
    this.contractId = builder.contractId;
    this.athleteId = builder.athleteId;
    this.firstSeason = builder.firstSeason;
    this.agentName = builder.agentName;
    this.teamName = builder.teamName;
    this.term = builder.term;
    this.value = builder.value;
    this.capHit = builder.capHit;
    this.percent = builder.percent;
    this.status = builder.status;
  }

  public Contract() {
    super();
  }

  public UUID getContractId() {
    return contractId;
  }

  public UUID getAthleteId() {
    return athleteId;
  }

  public int getFirstSeason() {
    return firstSeason;
  }

  public String getAgentName() {
    return agentName;
  }

  public UUID getTeamName() {
    return teamName;
  }

  public int getTerm() {
    return term;
  }

  public BigDecimal getValue() {
    return value;
  }

  public BigDecimal getCapHit() {
    return capHit;
  }

  public BigDecimal getPercent() {
    return percent;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(agentName, athleteId, capHit, contractId, firstSeason, percent, status, teamName, term, value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Contract other = (Contract) obj;
    return Objects.equals(agentName, other.agentName) && Objects.equals(athleteId, other.athleteId)
        && Objects.equals(capHit, other.capHit) && Objects.equals(contractId, other.contractId)
        && firstSeason == other.firstSeason && Objects.equals(percent, other.percent)
        && Objects.equals(status, other.status) && Objects.equals(teamName, other.teamName) && term == other.term
        && Objects.equals(value, other.value);
  }

  @Override
  public String toString() {
    return "Contract [contractId=" + contractId + ", athleteId=" + athleteId + ", firstSeason=" + firstSeason
        + ", agentName=" + agentName + ", teamName=" + teamName + ", term=" + term + ", value=" + value + ", capHit="
        + capHit + ", percent=" + percent + ", status=" + status + "]";
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID contractId;
    private UUID athleteId;
    private int firstSeason;
    private String agentName;
    private UUID teamName;
    private int term;
    private BigDecimal value;
    private BigDecimal capHit;
    private BigDecimal percent;
    private String status;

    private Builder() {
    }

    public Builder withContractId(UUID contractId) {
      this.contractId = contractId;
      return this;
    }

    public Builder withAthleteId(UUID athleteId) {
      this.athleteId = athleteId;
      return this;
    }

    public Builder withFirstSeason(int firstSeason) {
      this.firstSeason = firstSeason;
      return this;
    }

    public Builder withAgentName(String agentName) {
      this.agentName = agentName;
      return this;
    }

    public Builder withTeamName(UUID teamName) {
      this.teamName = teamName;
      return this;
    }

    public Builder withTerm(int term) {
      this.term = term;
      return this;
    }

    public Builder withValue(BigDecimal value) {
      this.value = value;
      return this;
    }

    public Builder withCapHit(BigDecimal capHit) {
      this.capHit = capHit;
      return this;
    }

    public Builder withPercent(BigDecimal percent) {
      this.percent = percent;
      return this;
    }

    public Builder withStatus(String status) {
      this.status = status;
      return this;
    }

    public Contract build() {
      return new Contract(this);
    }
  }

}