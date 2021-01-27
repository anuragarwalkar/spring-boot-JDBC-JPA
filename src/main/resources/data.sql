CREATE TABLE `Person` (
    `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
     `name` VARCHAR(250) NOT NULL,
     `location`   VARCHAR(250),
     `birth_date` TIMESTAMP
);

INSERT INTO PERSON (name, location, birth_date) values ('anurag', 'hydrabad', sysdate());
INSERT INTO PERSON (name, location, birth_date) values ('rahul', 'pune', sysdate());
INSERT INTO PERSON (name, location, birth_date) values ('shivaji', 'nagpur', sysdate());