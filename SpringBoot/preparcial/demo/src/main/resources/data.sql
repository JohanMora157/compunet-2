-- ====================================================================
-- DATOS DE PRUEBA (data.sql)
-- ====================================================================

-- 1. PAÍSES (country)
INSERT INTO country (id, name, code, confederation) VALUES 
(1, 'Colombia', 'COL', 'CONMEBOL'),
(2, 'Argentina', 'ARG', 'CONMEBOL'),
(3, 'España', 'ESP', 'UEFA'),
(4, 'Francia', 'FRA', 'UEFA'),
(5, 'Brasil', 'BRA', 'CONMEBOL');

-- 2. CLUBES (club)
INSERT INTO club (id, name, city, founded, country_id) VALUES 
(1, 'Real Madrid', 'Madrid', '1902-03-06 00:00:00', 3),
(2, 'FC Barcelona', 'Barcelona', '1899-11-29 00:00:00', 3),
(3, 'Liverpool FC', 'Liverpool', '1892-06-03 00:00:00', 4), -- representando liga europea
(4, 'River Plate', 'Buenos Aires', '1901-05-25 00:00:00', 2),
(5, 'Bayern Munich', 'Múnich', '1900-02-27 00:00:00', 4);

-- 3. JUGADORES (player)
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES 
(1, 'Luis Díaz', '1997-01-13 00:00:00', 'LW', 84, 1),
(2, 'James Rodríguez', '1991-07-12 00:00:00', 'CAM', 81, 1),
(3, 'Radamel Falcao', '1986-02-10 00:00:00', 'ST', 83, 1),
(4, 'Lionel Messi', '1987-06-24 00:00:00', 'RW', 93, 2),
(5, 'Vinicius Jr', '2000-07-12 00:00:00', 'LW', 89, 5),
(6, 'Kylian Mbappé', '1998-12-20 00:00:00', 'ST', 91, 4),
(7, 'Pedri', '2002-11-25 00:00:00', 'CM', 86, 3);

-- 4. HISTORIAL JUGADOR - CLUB (player_club)
-- PK compuesta: (player_id, club_id, start_date)
-- end_date = NULL significa que actualmente juega en ese club
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES 
-- Luis Díaz: Porto -> Liverpool
(1, 3, '2022-01-30 00:00:00', NULL),

-- James Rodríguez: Porto -> Real Madrid -> Bayern -> Rayo/etc
(2, 4, '2011-01-01 00:00:00', '2013-06-30 00:00:00'),
(2, 1, '2014-07-22 00:00:00', '2020-09-07 00:00:00'),
(2, 5, '2017-07-11 00:00:00', '2019-06-30 00:00:00'),

-- Falcao: River Plate -> Porto -> Atletico -> etc.
(3, 4, '2005-01-01 00:00:00', '2009-07-15 00:00:00'),

-- Lionel Messi: Barcelona -> PSG -> Inter Miami
(4, 2, '2004-10-16 00:00:00', '2021-08-10 00:00:00'),

-- Vinicius Jr: Real Madrid (actual)
(5, 1, '2018-07-12 00:00:00', NULL),

-- Mbappé: Real Madrid (actual)
(6, 1, '2024-07-01 00:00:00', NULL),

-- Pedri: Barcelona (actual)
(7, 2, '2020-09-01 00:00:00', NULL);

-- 5. PARTIDOS INTERNACIONALES (match)
INSERT INTO "MATCH" (id, match_date, stadium, home_country_id, away_country_id) VALUES 
(1, '2024-07-14 20:00:00', 'Hard Rock Stadium (Miami)', 1, 2), -- Colombia vs Argentina (Final Copa América)
(2, '2024-03-26 21:00:00', 'Santiago Bernabéu (Madrid)', 3, 5), -- España vs Brasil
(3, '2022-12-18 16:00:00', 'Lusail Stadium (Qatar)', 2, 4);     -- Argentina vs Francia (Final Mundial)
