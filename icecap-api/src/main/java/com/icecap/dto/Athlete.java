package com.icecap.dto;

import java.util.Objects;

//TODO: add properties to here and add features where you get athlete from DAO, and return json
//TODO: how to download liberty manually and restart project (readme)
public class Athlete {
	private String firstName;
	private String lastName;
	private int number;
	private int age;
	private String pos;
	private int heightFeet;
	private int heightInches;
	private int weightPounds;

	private Athlete(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.number = builder.number;
		this.age = builder.age;
		this.pos = builder.pos;
		this.heightFeet = builder.heightFeet;
		this.heightInches = builder.heightInches;
		this.weightPounds = builder.weightPounds;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}

	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	public void setWeightPounds(int weightPounds) {
		this.weightPounds = weightPounds;
	}

	public Athlete() {
		super();
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
		return Objects.hash(age, firstName, heightFeet, heightInches, lastName, number, pos, weightPounds);
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
				&& number == other.number && Objects.equals(pos, other.pos) && weightPounds == other.weightPounds;
	}

	
	

	@Override
	public String toString() {
		return "Athlete [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number + ", age=" + age
				+ ", pos=" + pos + ", heightFeet=" + heightFeet + ", heightInches=" + heightInches + ", weightPounds="
				+ weightPounds + "]";
	}


	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
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
