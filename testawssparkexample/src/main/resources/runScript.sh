tableInput="default.titanics3"
tableOutput="default.titanics3spark"

spark-submit --verbose --master yarn-client \
--jars testawssparkexample-1.0-SNAPSHOT.jar,scala-library-2.12.2.jar \
--class com.jorgeawstset.testaws.convert.driver.ConvertDriverTable \
--jars testawssparkexample-1.0-SNAPSHOT.jar,scala-library-2.12.2.jar, /usr/share/aws/aws-java-sdk/aws-java-sdk-emr-1.11.759.jar \
testawssparkexample-1.0-SNAPSHOT.jar \
${tableInput} \
${tableOutput}

