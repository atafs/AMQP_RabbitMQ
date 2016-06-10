/* PRODUCER 
Pattern "publish/subscribe":
- work queue is that each task is delivered to more than one worker queue

Exchanges:
- time to introduce the full messaging model in Rabbit
    - A producer is a user application that sends messages.
    - A queue is a buffer that stores messages.
    - A consumer is a user application that receives messages.
- In RabbitMQ is that the producer never sends any messages directly to a queue
- Instead, the producer can only send messages to an exchange.
- The rules for that are defined by the exchange type.
    - fanout: broadcasts all the messages it receives to all the queues it knows
    - direct: a message goes to the queues whose binding key exactly matches the routing key of the message.
    - topic
    - headers
- default exchange
    - ex: channel.basicPublish("", "hello", null, message.getBytes());
    
Temporary queues:
- String queueName = channel.queueDeclare().getQueue();

Bindings:
- Now we need to tell the exchange to send messages to our queue:
    - ex: channel.queueBind(queueName, "logs", "");

*/
    
import java.io.IOException;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class _11producer_EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv)
                  throws java.io.IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String message = getMessage(argv);

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
    //...
}
