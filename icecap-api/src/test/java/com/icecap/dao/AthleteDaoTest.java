package com.icecap.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.icecap.dto.Athlete;
import com.icecap.sql.MockConnection;
import com.icecap.sql.MockResultSet;

class AthleteDaoTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  public Connection createMockConnection() throws SQLException {
    MockResultSet rs = new MockResultSet();
    // Mock Driver Pattern
    rs
        .addHeaders(
            new String[] { "athlete_id", "current_team_id", "firstName", "lastName",
                "jNumber", "age", "pos", "heightFeet", "heightInches",
                "weightPounds", "agentFirst", "agentLast", "nation", "dob",
                "doesExist" });
    rs
        .addRow(new Object[] { "034240b5-7c15-4fcc-88c7-eac59df00c3e",
            "def7e0d7-7d11-4171-ae49-4f2c4ac7f328", "a", "a", 2, 3, "9", 3, 4,
            5, "x", "y", "USA", "n", 1 });
    Connection con = MockConnection.wireConnection(rs);
    return con;

  }

  public Athlete createAthlete() {
    return Athlete
        .builder()
          .withAge(3)
          .withAgentFirstName("x")
          .withAgentLastName("y")
          .withDateOfBirth("n")
          .withFirstName("a")
          .withHeightFeet(3)
          .withHeightInches(4)
          .withLastName("a")
          .withNationality("USA")
          .withNumber(2)
          .withPos("9")
          .withTeamID(UUID.fromString("def7e0d7-7d11-4171-ae49-4f2c4ac7f328"))
          .withUuid(UUID.fromString("034240b5-7c15-4fcc-88c7-eac59df00c3e"))
          .withWeightPounds(5)

          .build();

  }

  @Test
  void addAthlete() throws SQLException {
    Connection con = mock(Connection.class);
    PreparedStatement p = mock(PreparedStatement.class);
    when(con.prepareStatement(anyString())).thenReturn(p);
    Athlete a = createAthlete();

    // test
    AthleteDao dao = new AthleteDao();
    dao.addAthlete(a, con);

    // verification
    ArgumentCaptor<Integer> indexCapture = ArgumentCaptor
        .forClass(Integer.class);
    ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor
        .forClass(Integer.class);
    ArgumentCaptor<Integer> stringCapture = ArgumentCaptor
        .forClass(Integer.class);
    ArgumentCaptor<String> valueStringCapture = ArgumentCaptor
        .forClass(String.class);

    // The reason why we call the times(7) is that we want it to invoke this
    // verification for as many times as there are integers in the method(which
    // there are 7)
    verify(p, times(5))
        .setInt(indexCapture.capture(), valueIntCapture.capture());
    verify(p, times(9))
        .setString(stringCapture.capture(), valueStringCapture.capture());
    verify(p).execute();
    assertEquals(5, indexCapture.getAllValues().get(0));
    assertEquals(2, valueIntCapture.getAllValues().get(0));
    assertEquals(1, stringCapture.getAllValues().get(0));
    assertEquals("034240b5-7c15-4fcc-88c7-eac59df00c3e",
        valueStringCapture.getAllValues().get(0));

  }


  @Test
  void testGetAthlete() throws SQLException {
    Connection con = createMockConnection();
    Athlete athlete = createAthlete();
    AthleteDao dao = new AthleteDao();
    assertEquals(athlete,
        dao.getAthlete("1c40ae21-f852-4c19-ae3e-7d648fb741d5", con));

  }

  @Test
  void testGetAllAthletesFromTeam() throws SQLException {

    Connection con = createMockConnection();
    Athlete athlete = createAthlete();
    AthleteDao dao = new AthleteDao();
    assertEquals(List.of(athlete),
        dao.getAthletes("def7e0d7-7d11-4171-ae49-4f2c4ac7f328", con));

  }

  @Test
  void testGetAllAthletes() throws SQLException {

    Connection con = createMockConnection();
    Athlete athlete = createAthlete();
    AthleteDao dao = new AthleteDao();
    assertEquals(List.of(athlete),
        dao.getAllAthletes(con, "def7e0d7-7d11-4171-ae49-4f2c4ac7f328"));

  }



  @Test
  void testDeleteAthlete() throws SQLException {
    Connection con = createMockConnection();
    Athlete athlete = createAthlete();
    AthleteDao dao = new AthleteDao();
    assertEquals(athlete,
        dao.deleteAthlete(con, "1c40ae21-f852-4c19-ae3e-7d648fb741d5"));
  }

}
