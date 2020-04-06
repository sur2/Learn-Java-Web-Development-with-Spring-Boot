use jpub;
CREATE OR REPLACE TABLE TBL_USER (
  id varchar(40) NOT NULL,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL
);

DROP TABLE IF EXISTS FREE_BOARD;
CREATE TABLE FREE_BOARD(
	BOARD_ID VARCHAR(20) NOT NULL,
	UNAME VARCHAR(20) NOT NULL,
	TITLE VARCHAR(20) NOT NULL,
	CATEGORY VARCHAR(6),
	CONTENT TEXT,
	VIEWCOUNT INT DEFAULT 0,
	WDATE DATETIME,
	PRIMARY KEY(BOARD_ID)
) charset utf8;