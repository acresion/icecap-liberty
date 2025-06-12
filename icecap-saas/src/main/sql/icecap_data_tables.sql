use icecap;
drop table if exists athlete;
drop table if exists team;
drop table if exists contract_info;
drop table if exists league;
drop table if exists skater_stats;
drop table if exists goalie_stats;
-- defines the table for a league

-- change date of birth to date data type
create table league(
  league_id char(36)
, name varchar(20)
, sport varchar(25)
, founded int
, commissioner varchar(50)
, teams int
, roster_limit int
, salary_cap decimal
, contracts_limit int
, retained_limit int
, primary key(league_id));
-- defines the table for each of the 32 teams in the NHL

create table team(
   team_id char (36) 
 , in_league_id char(36)
 , teamName varchar(255)
 , yearFounded int
 , conference varchar(20)
 , division varchar(20)
 , gmName varchar(20)
 , coachName varchar(20)
 , captain varchar(255)
 , capHit decimal
 , capSpace decimal
 , active int
 , retained int
 , owner varchar(50)
 , website varchar(255)
 , primary key(team_id)
 , foreign key(in_league_id) references league(league_id));

-- defines general info about an athlete in a specific league
create table athlete(
   athlete_id varchar(255)
 , current_team_id char(36)
 , status varchar(10)
 , firstName varchar(255)
 , lastName varchar(20)
 , jNumber int
 , age int
 , position varchar(20)
 , heightFeet int
 , heightInches int
 , weightPounds int
 , agentFirst varchar(20)
 , agentLast varchar(20)
 , nation varchar(20)
 , dob varchar(100)
 , primary key(athlete_id)
 , foreign key(current_team_id) references team(team_id));


-- defines info about a contract signed by an athlete
create table contract_info(
  contract_id  char(36) primary key
, player_id char(36)
, first_season int
, agent varchar(20)
, team char(36)
, term int
, value decimal
, capHit decimal
, percent_at_start decimal
, status varchar(255)
, foreign key(player_id) references athlete(athlete_id)
, foreign key(team) references team(team_id));

-- defines specific stats for a skater (this remains strictly for hockey databases)
create table skater_stats(
  unique_season_id char(36) primary key
, skater_id char(36)
, yearSkate int
, team_id char(36)
, gamesPlayed int
, goals int
, assists int
, points int
, plusMinus int
, pentaltyMin int
, evenStrengthGoals int
, evenStrengthPoints int
, powerPlayGoals int
, powerPlayPoints int
, shots int
, foreign key(skater_id) references athlete(athlete_id)
, foreign key(team_id) references team(team_id));

-- defines specific stats for a goalie
create table goalie_stats(
  unique_season_id char(36) primary key
, goalie_id char(36)
, yearSkate int
, team_id char(36)
, gamesPlayed int
, gamesStarted int
, wins int
, losses int
, overtimeLosses int
, shotsAgainst int
, saves int
, goalsAgainst int
, gaa decimal
, savePercent decimal
, shutouts int
, foreign key(goalie_id) references athlete(athlete_id)
, foreign key(team_id) references team(team_id));




 
