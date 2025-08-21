use icecap;

delete from skater_stats;
delete from contract_info;
delete from athlete;
delete from team;
delete from league;


-- insert league data
insert into league values('ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'NHL', 'Ice Hockey', 1917, 'Gary Bettman', 32, 23, 95.0,50,3);
-- insert team data
insert into team values('def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Montreal Canadiens', 1917, 'Eastern', 'Atlantic','Kent Hughes', 'Martin St Louis', 'Nick Suzuki', 89394166.0, 6105834.0, 20, 3, 'Molson family', 'https://www.nhl.com/canadiens/' );
-- other teams in the Atlantic Division
insert into team values('1f3d1687-877b-47de-bf04-f2ed203d7c70', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Boston Bruins', 1924, 'Eastern', 'Atlantic','Don Sweeney', 'Marco Strum', 'Brad Marchand', 69231667.0, 26268333.0, 14, 2, 'Jeremy Jacobs', 'https://www.nhl.com/bruins/' );
insert into team values('5e1ffb92-ddc4-4203-9499-c008134fb112', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Buffalo Sabres', 1970, 'Eastern', 'Atlantic','Kevyn Adams', 'Lindy Ruff', 'Rasmus Dahlin', 72293014.0, 23206986.0, 16, 3, 'Terry Pegula', 'https://www.nhl.com/sabres/' );
insert into team values('d128c169-5918-402e-9f9c-11b2f112af66', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Detroit Red Wings', 1926, 'Eastern', 'Atlantic','Steve Yzerman', 'Todd McLellan', 'Dylan Larkin', 74163372.0, 21336628.0, 17, 3, 'Illitch Holdings', 'https://www.nhl.com/redwings/' );
insert into team values('287d8532-d6d5-4975-a882-4aae613c3a03', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Florida Panthers', 1993, 'Eastern', 'Atlantic','Bill Zito', 'Paul Maurice', 'Aleksander Barkov', 76500000.0, 19000000.0, 16, 3, 'Sunrise Sports', 'https://www.nhl.com/panthers/' );
insert into team values('fe5e3433-dc38-4fb3-8311-e3bbc2ddbf0e', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Ottawa Senators', 1992, 'Eastern', 'Atlantic','Steve Staios', 'Travis Green', 'Brady Tkachuck', 80473214.0, 15026786.0, 16, 2, 'Micheal Andlauer', 'https://www.nhl.com/senators/' );
insert into team values('abf45179-d6d4-48a0-93cc-4da7e4316217', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Tampa Bay Lightning', 1992, 'Eastern', 'Atlantic','Julien BriseBois', 'Jon Cooper', 'Victor Headman', 92019999.0, 3480001.0, 20, 3, 'Jeffery Vinik', 'https://www.nhl.com/lightning/' );
insert into team values('36122ad7-a88c-4e07-b1a6-c66e23987ada', 'ee1b2aca-1cf1-41a7-8896-d0bf856bdf38', 'Toronto Maple Leafs', 1917, 'Eastern', 'Atlantic','Brad Treliving', 'Craig Berube', 'Auston Matthews', 69790999.0, 25709001.0, 17, 3, 'MLSE', 'https://www.nhl.com/mapleleafs/' );

-- player data
-- Patrick Laine
insert into athlete values('e9bfc5dc-8075-4bc5-a39a-2115a07610d2','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Patrick', 'Laine', 92, 27, 'RW', 6,5,216, 'Andy', 'Scott', 'Finland', 'Apr 19, 1998' );
insert into contract_info values('e9bfc5dc-8075-4bc5-a39a-2115a07610e2','e9bfc5dc-8075-4bc5-a39a-2115a07610d2', 2022, 'Andy Scott',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 4, 8700000.0, 34800000.0, 10.55, 'RFA');
insert into skater_stats values('e9bfc5dc-8075-4bc5-a39a-2115a07610a2', 'e9bfc5dc-8075-4bc5-a39a-2115a07610d2', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 52, 20, 13, 33, -14, 14,5,14,15,19,116);

-- Nick Suzuki
insert into athlete values('54702d5a-2a80-4aa2-a7e6-0ac5b3695c35','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Nick', 'Suzuki', 14, 25, 'C', 5,11,207, 'David', 'Gagner', 'Canada', 'Aug 10, 1999' );
insert into contract_info values('5b5844d3-24fc-49f9-bb24-9346f0e894c0','54702d5a-2a80-4aa2-a7e6-0ac5b3695c35', 2022, 'David Gagner',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 8, 63000000.0, 7880000.0, 9.55, 'RFA');
insert into skater_stats values('111e2548-aef9-4171-ac29-46d007a625dc', '54702d5a-2a80-4aa2-a7e6-0ac5b3695c35', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 30, 59, 89, 19, 9,24,60,4,27,172);

-- Cole Caufield
insert into athlete values('034240b5-7c15-4fcc-88c7-eac59df00c3e','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Cole', 'Caufield', 13, 24, 'RW', 5,8,174, 'Pat', 'Brisson', 'USA', 'Jan 2, 2001' );
insert into contract_info values('89f09666-1af3-4f99-a46c-cc989b4d5c05','034240b5-7c15-4fcc-88c7-eac59df00c3e', 2022, 'Pat Brisson',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 8, 62800000.0, 7850000.0, 9.4, 'RFA');
insert into skater_stats values('2b55301f-ca85-4a50-9c59-91a29c307baa', '034240b5-7c15-4fcc-88c7-eac59df00c3e', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 30, 37, 70, 9, 14,27,53,10,19,240);

-- Lane Hudson
insert into athlete values('db593be5-f27a-47ba-bd77-e9cf1d0136b7','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Lane', 'Hudson', 48, 21, 'D', 5,10,165, 'Sean', 'Coffey', 'USA', 'Feb 14, 2004' );
insert into contract_info values('8f9d46b6-8924-4d48-84f2-a043ebb68310','db593be5-f27a-47ba-bd77-e9cf1d0136b7', 2022, 'Sean Coffey',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 3, 2875000.0, 950000.0, 1.44, 'ELC');
insert into skater_stats values('d531163b-1450-4469-8624-b7f37bbf823c', 'db593be5-f27a-47ba-bd77-e9cf1d0136b7', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 6, 60, 66, -2, 32,5,40,1,26,91);

-- Brendan Gallagher
insert into athlete values('ae587fae-937b-4979-8afa-af7c3ec8afaa','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Brendan', 'Gallagher', 11, 33, 'RW', 5,9,183, 'Gerry', 'Johannson', 'Canada', 'May 6, 1992' );
insert into contract_info values('ae587fae-937b-4979-8afa-af7c3ec8afba','ae587fae-937b-4979-8afa-af7c3ec8afaa', 2021, 'Gerry Johannson',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 6, 39000000.0, 6500000.0, 7.98, 'UFA');
insert into skater_stats values('ae587fae-937b-4979-8afa-af7c3ec8afbc', 'ae587fae-937b-4979-8afa-af7c3ec8afaa', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 21, 17, 38, -6, 39,16,31,5,7,148);


-- Jake Evans
insert into athlete values('ee09d0e5-a294-4edf-bcee-1dc277a9d16f','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Jake', 'Evans', 71, 29, 'C', 6,0,185, 'Brian', 'MacDonald', 'Canada', 'Jun 2, 1996' );
insert into contract_info values('ee09d0e5-a294-4edf-bcee-1dc277a9d16e','ee09d0e5-a294-4edf-bcee-1dc277a9d16f', 2025, 'Brian MacDonald',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 4, 11400000.0, 2850000.0, 2.98, 'UFA');
insert into skater_stats values('ee09d0e5-a294-4edf-bcee-1dc277a9d16c', 'ee09d0e5-a294-4edf-bcee-1dc277a9d16f', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 13, 23, 36, 1, 10,10,30,0,0,80);

-- Christain Dvorak
insert into athlete values('bbcb4630-1e7d-4783-a850-0cdd8e909a0b','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Christian', 'Dvorak', 28, 29, 'C', 6,1,201, 'Kevin', 'Magnuson', 'USA', 'Feb 2, 1996' );
insert into contract_info values('f5302339-ee12-4b65-9700-365d8e010308','bbcb4630-1e7d-4783-a850-0cdd8e909a0b', 2025, 'Kevin Magnuson',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 6, 26700000.0, 4450000.0, 5.46, 'UFA');
insert into skater_stats values('f5302339-ee12-4b65-9700-365d8e010908', 'bbcb4630-1e7d-4783-a850-0cdd8e909a0b', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 12, 21, 33, -14, 14,5,14,15,19,104);

-- Mike Matheson
insert into athlete values('80fec019-d366-4605-952f-6001cefdd48f','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Mike', 'Matheson', 8, 31, 'D', 6,2,187, 'Phillipe', 'Lecavlier', 'Canada', 'Feb 27, 1994' );
insert into contract_info values('80fec019-d366-4605-952f-6001cefdd48a','80fec019-d366-4605-952f-6001cefdd48f', 2025, 'Philippe Lecavalier',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 8, 39000000.0, 4880000.0, 6.13, 'RFA');
insert into skater_stats values('80fec019-d366-4605-952f-6001cefdd48b', '80fec019-d366-4605-952f-6001cefdd48f', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 80, 6, 35, 31, -6, 51,5,20,1,10,149);

-- Joel Armia
insert into athlete values('bbcb4630-1e7d-4783-a850-0cdd8e90900b','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Joel', 'Armia', 40, 32, 'RW', 6,3,216, 'Mike', 'Rautakallio', 'Finland', 'May 31, 1993' );
insert into contract_info values('b5302339-ee12-4b65-9700-365d8e010308','bbcb4630-1e7d-4783-a850-0cdd8e90900b', 2021, 'Mike Rautakallio',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328',8, 13600000.0, 3400000.0, 4.17, 'UFA');
insert into skater_stats values('b5302339-ee12-4b65-9700-365d8e010908', 'bbcb4630-1e7d-4783-a850-0cdd8e90900b', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 81, 11, 18, 29, -2, 16,8,23,0,3,104);

-- Josh Anderson
insert into athlete values('bbcb4630-1e7d-4783-a850-0cdd8e91900b','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Josh', 'Anderson', 17, 31, 'LW', 6,3,227, 'Darren', 'Ferris', 'Canada', 'May 7, 1994' );
insert into contract_info values('b5302339-ee12-4b65-9700-365d9e010308','bbcb4630-1e7d-4783-a850-0cdd8e91900b', 2020, 'Darren Ferris ',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 7, 38500000.0, 5500000.0, 6.75, 'RFA');
insert into skater_stats values('b5302339-ee12-4b65-9700-365d9e010908', 'bbcb4630-1e7d-4783-a850-0cdd8e91900b', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 81, 15, 12, 27, -2, 90,14,26,0,0,109);

-- Alex Newhook
insert into athlete values('36121d36-668b-4a72-962f-b0f7bc27b65c','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Alex', 'Newhook', 15, 24, 'C', 5,10,190, 'Paul', 'Capizzano', 'Canada', 'Jan 28, 2001' );
insert into contract_info values('36121d36-668b-4a72-962f-b0f7bc27b65e','36121d36-668b-4a72-962f-b0f7bc27b65c', 2023, 'Paul Capizzano',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 4, 11600000.0, 2900000.0, 3.47, 'RFA');
insert into skater_stats values('36121d36-668b-4a72-962f-b0f7bc27b65f', '36121d36-668b-4a72-962f-b0f7bc27b65c', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 82, 15, 11, 26, -21, 24,14,22,1,4,118);

-- Kirby Dach
insert into athlete values('dbc5f015-bf4c-4aed-bb91-5827958cc656','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Kirby', 'Dach', 77, 24, 'C', 6,4,216, 'Gerry', 'Johannson', 'Canada', 'Jan 21, 2001' );
insert into contract_info values('dbc5f015-bf4c-4aed-bb91-5827958cc6c6','dbc5f015-bf4c-4aed-bb91-5827958cc656', 2023, 'Gerry Johannson',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 4, 13450000.0, 3360000.0, 4.08, 'RFA');
insert into skater_stats values('dbc5f015-bf4c-4aed-bb91-5827958cc6d6', 'dbc5f015-bf4c-4aed-bb91-5827958cc656', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 57, 10, 12, 22, -29, 40,9,15,1,7,84);

-- Kaiden Guhle
insert into athlete values('454704f2-c904-4db4-8f78-49d2c248afc9','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Kaiden', 'Guhle', 21, 23, 'D', 6,2,205, 'Allain', 'Roy', 'Canada', 'Jan 18, 2002' );
insert into contract_info values('454704f2-c904-4db4-8f78-49d2c248afb9','454704f2-c904-4db4-8f78-49d2c248afc9', 2021, 'Allain Roy',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328',6, 33300000.0, 5550000.0, 5.81, 'RFA');
insert into skater_stats values('454704f2-c904-4db4-8f78-49d2c248afa9', '454704f2-c904-4db4-8f78-49d2c248afc9', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 55, 6, 12, 18, 6, 47,6,17,0,0,71);

-- Alexandre Carrier
insert into athlete values('bbcb4630-1e7d-4783-a850-0cdd8e91909b','def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 'Alexandre', 'Carrier', 45, 28, 'D', 5,11,174, 'Phillipe', 'Lecavalier', 'Canada', 'Oct 8, 1996' );
insert into contract_info values('b5302339-ee12-4b65-9700-365d9e010309','bbcb4630-1e7d-4783-a850-0cdd8e91909b', 2024, 'Philippe Lecavalier',  'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 3, 11250000.0, 3750000.0, 4.26, 'UFA');
insert into skater_stats values('b5302339-ee12-4b65-9700-365d9e010909', 'bbcb4630-1e7d-4783-a850-0cdd8e91909b', 2025, 'def7e0d7-7d11-4171-ae49-4f2c4ac7f328', 51, 2, 16, 18, 4, 28,2,18,0,0,59);


-- Go to Arber Xhekaj, and then add the two goalies (Sam Montembeault, Jakub Dobes)