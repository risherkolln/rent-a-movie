create table stars (
    id int(11) not null AUTO_INCREMENT,
    name varchar(50) not null,
    rating int(8) not null,
    primary key (id)
);

CREATE TABLE rentals (
    id INT AUTO_INCREMENT  PRIMARY KEY,
--    customer_id INT NOT NULL,
 --   movie_copy_id INT NOT NULL,
    rent_date timestamp,
    return_date timestamp,
    returned INT(1)--,
 --   CONSTRAINT customer_id_fk
  --      FOREIGN KEY (customer_id)
 --       REFERENCES customers (id)
 --       ON DELETE NO ACTION
 --       ON UPDATE NO ACTION,
  --  CONSTRAINT movie_copy_id_fk
 --       FOREIGN KEY (movie_copy_id)
  --      REFERENCES movie_copies (id)
  --      ON DELETE NO ACTION
  --      ON UPDATE NO ACTION
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    address VARCHAR(256) NOT NULL,
    dni INT NOT NULL
);

CREATE TABLE movie_copies (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    serial_number VARCHAR(256) NOT NULL--,
  --  movie_id INT NOT NULL,
 --   format_id INT NOT NULL,
  --  CONSTRAINT movie_id_fk
    --    FOREIGN KEY (movie_id)
   --     REFERENCES movies (id)
   --     ON DELETE NO ACTION
   --     ON UPDATE NO ACTION,
   -- CONSTRAINT format_id_fk
   --     FOREIGN KEY (format_id)
   --     REFERENCES formats (id)
    --    ON DELETE NO ACTION
    --    ON UPDATE NO ACTION
);

CREATE TABLE directors (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

CREATE TABLE writers (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

CREATE TABLE formats (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

CREATE TABLE genres (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

CREATE TABLE movies (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
  --  genres INT NOT NULL,
  --  director_id INT NOT NULL,
  --  writers INT NOT NULL,
  --  stars INT NOT NULL,
    formal_rating INT(8) NOT NULL,
    popular_rating INT(8) NOT NULL--,
  --  CONSTRAINT director_id_fk
  --      FOREIGN KEY (director_id)
   --     REFERENCES directors (id)
  --      ON DELETE NO ACTION
   --     ON UPDATE NO ACTION
);






