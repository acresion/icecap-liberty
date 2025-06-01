package com.icecap.dto;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

//TODO: add properties to here and add features where you get athlete from DAO, and return json
//TODO: how to download liberty manually and restart project (readme)
@JsonDeserialize(builder = Athlete.Builder.class)
public class Athlete {
	private UUID uuid;
	private String firstName;
	private String lastName;
	private int number;
	private int age;
	private String pos;
	private int heightFeet;
	private int heightInches;
	private int weightPounds;

	private Athlete(Builder builder) {
		this.uuid = builder.uuid;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.number = builder.number;
		this.age = builder.age;
		this.pos = builder.pos;
		this.heightFeet = builder.heightFeet;
		this.heightInches = builder.heightInches;
		this.weightPounds = builder.weightPounds;
	}

	public Athlete() {
		super();
	}

	public UUID getUuid() {
		return uuid;
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

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, heightFeet, heightInches, lastName, number, pos, uuid, weightPounds);
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
		return age == other.age && Objects.equals(firstName, other.firstName) && heightFeet == other.heightFeet
				&& heightInches == other.heightInches && Objects.equals(lastName, other.lastName)
				&& number == other.number && Objects.equals(pos, other.pos) && Objects.equals(uuid, other.uuid)
				&& weightPounds == other.weightPounds;
	}

	@Override
	public String toString() {
		return "Athlete [uuid=" + uuid + ", firstName=" + firstName + ", lastName=" + lastName + ", number=" + number
				+ ", age=" + age + ", pos=" + pos + ", heightFeet=" + heightFeet + ", heightInches=" + heightInches
				+ ", weightPounds=" + weightPounds + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
	public static final class Builder {
		private UUID uuid;
		private String firstName;
		private String lastName;
		private int number;
		private int age;
		private String pos;
		private int heightFeet;
		private int heightInches;
		private int weightPounds;

		private Builder() {
		}

		public Builder withUuid(UUID uuid) {
			this.uuid = uuid;
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

		public Athlete build() {
			return new Athlete(this);
		}
	}

}