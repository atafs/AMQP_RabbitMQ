#!/bin/sh

#set an environment variable for the classpath
export CP=.:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar

#RUN
java -cp $CP _1producer_NewTask "kern.critical" "A critical kernel error and more"

#ARGS
#if [ "$#" -eq 1 ]; then
#	java -cp $CP _1producer_NewTask "kern.critical" "A critical kernel error and more"
#fi
#echo "$1"
#echo "$2"
#java -cp $CP _1producer_NewTask "$1" 

#DISPLAY MESSAGES IN QUEUE
#echo ''
#echo 'list_exchanges ##########'
#sudo rabbitmqctl list_exchanges

#echo ''
#echo 'list_queues ##########'
#sudo rabbitmqctl list_queues name messages_ready messages_unacknowledged

#echo ''
#echo 'list_bindings ##########'
#sudo rabbitmqctl list_bindings