INSERT INTO PERSON (id, name, location, birth_date) values (111, 'anurag', 'hydrabad', sysdate());
INSERT INTO PERSON (id, name, location, birth_date) values (112, 'rahul', 'pune', sysdate());
INSERT INTO PERSON (id, name, location, birth_date) values (113, 'shivaji', 'nagpur', sysdate());

INSERT INTO PASSPORT (id, number) values(456, 'bikpa0743f');
INSERT INTO PASSPORT (id, number) values(457, 'bikpa0743f');
INSERT INTO PASSPORT (id, number) values(458, 'bikpa0743f');

INSERT INTO STUDENT (id, name, passport_id) values(111, 'Anurag', 456);
INSERT INTO STUDENT (id, name, passport_id) values(112, 'Swapnil', 457);
INSERT INTO STUDENT (id, name, passport_id) values(113, 'Shantanu', 458);

INSERT INTO COURSE (id, name, created_date, last_updated_date) values(111, 'React Native', sysdate(), sysdate());
INSERT INTO COURSE (id, name, created_date, last_updated_date) values(112, 'Angular', sysdate(), sysdate());
INSERT INTO COURSE (id, name, created_date, last_updated_date) values(113, 'Fuject', sysdate(), sysdate()); 

INSERT INTO REVIEW (id, description, rating) values(111, 'this is deno', 'good');
INSERT INTO REVIEW (id, description, rating) values(112, 'this is jlkasd', 'bad');
INSERT INTO REVIEW (id, description, rating) values(113, 'this is jfk', 'fk');