hadoop fs -copyFromLocal -f hiveaction.hql
hadoop fs -copyFromLocal -f workflow.xml
oozie jobs
oozie job -config job.properties -run
oozie jobs
#oozie job -verbose -info XXX