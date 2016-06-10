#javac -cp rabbitmq-client.jar _11producer_Send.java _12consumer_Recv.java _21producer_NewTask.java _22consumer_Worker.java 
javac -cp rabbitmq-client.jar _12consumer_Recv.java _11producer_Send.java
