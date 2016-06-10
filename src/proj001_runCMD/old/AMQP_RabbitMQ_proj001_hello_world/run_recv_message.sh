#set an environment variable for the classpath
java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar Recv

#RUN
java -cp $CP Recv

#DISPLAY MESSAGES IN QUEUE
rabbitmqctl list_queues
