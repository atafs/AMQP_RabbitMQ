#set an environment variable for the classpath
export CP=.:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar

#RUN
java -cp $CP _1producer_NewTask

#DISPLAY MESSAGES IN QUEUE
sudo rabbitmqctl list_queues name messages_ready messages_unacknowledged
