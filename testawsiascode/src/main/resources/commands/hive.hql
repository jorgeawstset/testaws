CREATE TABLE default.titanics3 (
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
  "skip.header.line.count" = "1"
);

CREATE TABLE if not exists default.titanics3spark (
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

