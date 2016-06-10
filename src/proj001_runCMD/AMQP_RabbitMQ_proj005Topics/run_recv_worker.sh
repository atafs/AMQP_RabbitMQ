#RUN To receive all the logs:
#java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2consumer_Worker "#"

#RUN To receive all logs from the facility "kern":
#java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2consumer_Worker "kern.*"

#RUN if you want to hear only about "critical" logs:
#java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2consumer_Worker "*.critical"

#RUN multiple bindings:
#java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2consumer_Worker "kern.*" "*.critical"

#RUN emit a log with a routing key "kern.critical" type:
java -cp .:commons-io-1.2.jar:commons-cli-1.1.jar:rabbitmq-client.jar _2consumer_Worker "kern.critical" "A critical kernel error"


