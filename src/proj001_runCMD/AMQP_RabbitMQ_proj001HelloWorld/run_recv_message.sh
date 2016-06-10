#set an environment variable for the classpath
java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2consumer_Recv

#RUN
java -cp $CP _2consumer_Recv

#DISPLAY MESSAGES IN QUEUE
rabbitmqctl list_queues
