#set an environment variable for the classpath
java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2server_RPCServer

#RUN
java -cp $CP _2server_RPCServer

#DISPLAY MESSAGES IN QUEUE
rabbitmqctl list_queues