DROP DATABASE IF EXISTS blog;

CREATE DATABASE blog  default character set=utf8 COLLATE=utf8_general_ci;

USE blog;

SET NAMES 'utf8';
SET NAMES utf8;
SET NAMES utf8 COLLATE utf8_general_ci ;

CREATE TABLE user (
	
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(20) NOT NULL UNIQUE,
	email varchar(45) NOT NULL UNIQUE,
	password varchar(64) NOT NULL,
	sex enum('MALE', 'FEMALE') NOT NULL,
	birthday date NOT NULL,
	kind_of_sport varchar(255),
	experience varchar(255),
	city varchar(45),
	country varchar(45),
	avatar_path varchar(255),
	registration_date date NOT NULL,
	role enum('ROLE_ADMIN', 'ROLE_ANONYMOUS', 'ROLE_USER') NOT NULL,
	enabled TINYINT NOT NULL DEFAULT 1,

	PRIMARY KEY (id)
);

CREATE TABLE statistic (
	
	id bigint NOT NULL AUTO_INCREMENT,
	date_visiting datetime NOT NULL,
	user_id bigint NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES user (id)  
);

CREATE TABLE music (
	
	id bigint NOT NULL AUTO_INCREMENT,
	song_name varchar(255) NOT NULL,
	singer_name varchar(255),
	path text NOT NULL,
	
	PRIMARY KEY (id)
);

CREATE TABLE article (
	
	id bigint NOT NULL AUTO_INCREMENT,
	title text NOT NULL,
	content text NOT NULL,
	creation_date date NOT NULL,
	
	PRIMARY KEY (id)
);

CREATE TABLE favorite (
	
	id bigint NOT NULL AUTO_INCREMENT,
	user_id bigint NOT NULL,
	article_id bigint NOT NULL,
	music_id bigint NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES user (id),
	FOREIGN KEY (article_id) REFERENCES article (id),
	FOREIGN KEY (music_id) REFERENCES music (id)
);

-- TODO: Delete the field path if it is not need !
CREATE TABLE image (
	
	id bigint NOT NULL AUTO_INCREMENT,
	path text NOT NULL,
	name varchar(255) NOT NULL UNIQUE,
	
	PRIMARY KEY (id)
);

CREATE TABLE article_image (
	
	id bigint NOT NULL AUTO_INCREMENT,
	article_id bigint NOT NULL,
	image_id bigint NOT NULL,
	paragraph tinyint NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (article_id) REFERENCES article (id),
	FOREIGN KEY (image_id) REFERENCES image (id)
);

CREATE TABLE forum (
	
	id bigint NOT NULL AUTO_INCREMENT,
	message text NOT NULL,
	image_path text NOT NULL,
	message_date datetime NOT NULL,
	user_id bigint NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE forum_image (
	
	id bigint NOT NULL AUTO_INCREMENT,
	forum_id bigint NOT NULL,
	image_id bigint NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY (forum_id) REFERENCES forum (id),
	FOREIGN KEY (image_id) REFERENCES image (id)
);
