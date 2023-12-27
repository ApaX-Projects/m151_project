INSERT INTO Teams (name, country, created_at, updated_at)
VALUES
    ( 'G2 Esports', 'Germany', '2013-11-01', NULL),
    ( 'Natus Vincere', 'Ukraine', '2009-12-17', NULL),
    ( '9INE', 'Sweden', '2015-11-19', '2019-02-27');

-- Players G2 Esports
INSERT INTO Players (  name, nickname, country, age, created_at, updated_at)
VALUES
    ('Nemanja Kovac', 'huNter-', 'Bosnia and Herzegovina', 27, '1996-01-03', NULL),
    ('Nemanja Isakovic', 'nexa', 'Serbia', 26, '1997-4-25', NULL),
    ( 'Nikola Kovac', 'NiKo', 'Bosnia and Herzegovina', 26, '1997-02-16', NULL),
    ( 'Ilya Osipov', 'm0NESY', 'Russia', 18, '2005-05-01', NULL),
    ( 'Rasmus Pallisgaard Nielsen', 'HooXi', 'Denmark', 28, '1995-05-21', NULL);

-- Players Natus Vincere
INSERT INTO Players ( name, nickname, country, age, created_at, updated_at)
VALUES
    ('Ihor Zhdanov', 'w0nderful', 'Ukraine', 18, '2004-12-14', NULL),
    ( 'Valerij Jevghenijovych Vakhovsjkyj', 'B1T', 'Ukraine', 20, '2003-01-05', NULL),
    ('Aleksi Antti Kaarlo Virolainen', 'Aleksib', 'Finland', 26, '1997-04-30', NULL),
    (  'Justinas Lekavicius', 'jL', 'Lithuania', 24, '1999-09-29', NULL),
    ( 'Ivan Mihai', 'iM', 'Romania', 24, '1999-7-29', NULL);

-- Players 9INE
INSERT INTO Players (name, nickname, country, age, created_at, updated_at)
VALUES
    ('Aleksander Miskiewicz', 'hades', 'Poland', 23, '2000-01-01', NULL),
    (  'Kacper Walukiewicz', 'Kylar', 'Poland', 24, '1999-09-22', NULL),
    ('Kamil Pietkun', 'KEi', 'Poland', 22, '2001-04-06', NULL),
    (  'Krzysztof Górski', 'Goofy', 'Poland', 23, '2000-08-29', NULL),
    ( 'Jakub Pietruszewski', 'jcobbb', 'Poland', 19, NULL, NULL);
