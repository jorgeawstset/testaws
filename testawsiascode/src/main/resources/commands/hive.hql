CREATE TABLE default.titanicS3 (
Survived string,
Pclass string,
Name string,
Sex string,
Age string,
SibSpo string,
ParChil string,
Fare string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS
INPUTFORMAT
  'com.amazonaws.emr.s3select.hive.S3SelectableTextInputFormat'
OUTPUTFORMAT
  'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION 's3://s3titanicstack-s3titanic-18oef9fw4bsqk/input'
TBLPROPERTIES (
  "s3select.format" = "csv",
  "s3select.headerInfo" = "ignore"
);

CREATE TABLE if not exists default.titanicS3spark (
Survived string,
Pclass string,
Name string,
Sex string,
Age string,
SibSpo string,
ParChil string,
Fare string,
Namechanged string,
Namesha512 string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS
INPUTFORMAT
  'com.amazonaws.emr.s3select.hive.S3SelectableTextInputFormat'
OUTPUTFORMAT
  'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION 's3://s3titanicstack-s3titanic-18oef9fw4bsqk/outputspark'
TBLPROPERTIES (
  "s3select.format" = "csv",
  "s3select.headerInfo" = "ignore"
);

create table default.mytablej (
field1 string,
field2 string)
;

INSERT INTO TABLE default.mytablej
VALUES
('A1B','DNS'),
('DND','LUY');


ADD JAR hdfs:///user/hadoop/testaws-1.0-SNAPSHOT.jar;
ADD JAR hdfs:///user/hadoop/scala-library-2.12.2.jar;
CREATE FUNCTION CHANGELETTERS AS 'com.jorgeawstset.testaws.udf.hive.ChangeLetters';

select field1, CHANGELETTERS(field1) as chg1, field2 from default.mytablej;
select sha2("A",512);