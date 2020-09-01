hadoop fs -copyFromLocal -f hiveaction.hql
hadoop fs -copyFromLocal -f workflow.xml
hadoop fs -copyFromLocal -f testaws-1.0-SNAPSHOT.jar
hadoop fs -copyFromLocal -f scala-library-2.12.2.jar
oozie jobs
oozie job -config job.properties -run
oozie jobs
#oozie job -verbose -info XXX