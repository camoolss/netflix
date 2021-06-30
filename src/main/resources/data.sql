INSERT INTO CATEGORIES(ID, NAME) VALUES 
	(1, 'TERROR'), 
	(2, 'COMEDIA'), 
	(3, 'ACCIÓN');
    
INSERT INTO TV_SHOWS(ID, NAME, SHORT_DESC, LONG_DESC, YEAR, RECOMMENDED_AGE, CATEGORY_ID) VALUES 
	(1, 'Juego de tronos', 'Descripción corta', 'Descripción larga', '2012', 16, 3), 
	(2, 'American horror Story', NULL, NULL, '2010', 16, 1), 
	(3, 'Big Bang', NULL, NULL, '2008', 7, 2);
    
INSERT INTO SEASONS(ID, NUMBER, NAME, TV_SHOW_ID) VALUES 
	(1, 1, 'One', 1), 
	(2, 2, 'Two', 1), 
	(3, 1, 'One', 2), 
	(4, 2, 'Two', 2), 
	(5, 3, 'Three', 2), 
	(6, 1, 'One', 3);

INSERT INTO CHAPTERS(ID, NUMBER, NAME, DURATION, SEASON_ID) VALUES 
	(1, 1, 'Chapter 1', 43, 1), 
	(2, 2, 'Chapter 2', 45, 1), 
	(3, 3, 'Chapter 3', 44, 1),
	(4, 1, 'Chapter 0', 50, 2);
	
INSERT INTO ACTORS(ID, NAME, YEAR) VALUES 
	(1, 'Actor 1', 1991), 
	(2, 'Actor 2', 1982), 
	(3, 'Actor 3', 2000),
	(4, 'Actor 4', 1999);
	
INSERT INTO ACTORS_TVSHOWS(ID, TVSHOW_ID, ACTOR_ID) VALUES
    (1,1,1),
    (2,2,2),
    (3,3,3);

INSERT INTO AWARDS(ID, NAME, YEAR, tv_show_id) VALUES
	(1, 'Premio 1', 1991, 1), 
	(2, 'Premio 2', 1982, 2), 
	(3, 'Premio 3', 2000, 3),
	(4, 'Premio 4', 1999, 1);
    