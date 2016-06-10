#set an environment variable for the classpath
java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _12consumer_Recv

#RUN
java -cp $CP _12consumer_Recv

#DISPLAY MESSAGES IN QUEUE
rabbitmqctl list_queues
