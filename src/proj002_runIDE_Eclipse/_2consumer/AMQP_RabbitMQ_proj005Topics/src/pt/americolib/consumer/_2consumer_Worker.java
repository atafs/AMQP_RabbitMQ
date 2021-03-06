package pt.americolib.consumer;

/* CONSUMER */
import com.rabbitmq.client.*;

import java.io.IOException;

public class _2consumer_Worker {

  //ATTRIBUTES
   private static final String EXCHANGE_NAME = "topic_logs";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    final Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();

    //Exchanges
    channel.exchangeDeclare(EXCHANGE_NAME, "topic");
    String queueName = channel.queueDeclare().getQueue();

    //Subscribing
    if (argv.length < 1){
      System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
      System.exit(1);
    }

    for(String bindingKey : argv){
      channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
    }

    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    //INNER 
    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope,
                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
      }
    };
    channel.basicConsume(queueName, true, consumer);
  }
}
