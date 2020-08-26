CREATE TABLE if not exists default.titanicS3sha (
Survived string,
Pclass string,
Name string,
Namechanged string,
Namesha512 string,
Sex string,
Age string,
SibSpo string,
ParChil string,
Fare string )
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS
INPUTFORMAT
  'com.amazonaws.emr.s3select.hive.S3SelectableTextInputFormat'
OUTPUTFORMAT
  'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION 's3://s3aawstest-testawss3-1dg0hwjszy9l6/output'
TBLPROPERTIES (
  "s3select.format" = "csv",
  "s3select.headerInfo" = "ignore"
);
ADD JAR hdfs:///user/hadoop/testaws-1.0-SNAPSHOT.jar;
ADD JAR hdfs:///user/hadoop/scala-library-2.12.2.jar;

INSERT INTO TABLE default.titanicS3sha
SELECT Survived, Pclass, Name, CHANGELETTERS(Name) as Namechanged, sha2(concat(Name,Age),512) as Namesha512,Sex, Age, SibSpo, ParChil, Fare string
FROM default.titanicS3 ;


