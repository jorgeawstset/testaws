create table default.mytablej (
field1 string,
field2 string)
;

INSERT INTO TABLE default.mytablej
VALUES
('A1B','DNS'),
('DND','LUY');

ADD JAR /home/hadoop/testaws-1.0-SNAPSHOT.jar;
ADD JAR /home/hadoop/scala-library-2.12.2.jar;
CREATE TEMPORARY FUNCTION CHANGELETTERS AS 'com.jorgeawstset.testaws.udf.hive.ChangeLetters';

select field1, CHANGELETTERS(field1) as chg1, field2 from default.mytablej;
select sha2("A",512);