#set an environment variable for the classpath
export CP=.:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar

#RUN
java -cp $CP _11producer_Send asda. as..asd

#DISPLAY MESSAGES IN QUEUE
rabbitmqctl list_queues
