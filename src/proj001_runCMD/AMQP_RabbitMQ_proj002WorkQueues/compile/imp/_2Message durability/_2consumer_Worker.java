/* CONSUMER */
import com.rabbitmq.client.*;

import java.io.IOException;

public class _2consumer_Worker {

  //ATTRIBUTES
  private final static String QUEUE_NAME = "task_queue_v1";

  //MAIN    
  public static void main(String[] argv) throws Exception {
    
    //CONNECTION AND CHANNEL
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    //DECLARE QUEUE  
    boolean durable = true;
    channel.queueDeclare("task_queue_v1", durable, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    //CONSUME RESOURCE
final Consumer consumer = new DefaultConsumer(channel) {
  @Override
  public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
    String message = new String(body, "UTF-8");

    System.out.println(" [x] Received '" + message + "'");
    try {
      doWork(message);
    } catch(Exception e) {
	e.printStackTrace();
    }finally {
      System.out.println(" [x] Done");
    }
  }
};
channel.basicConsume(QUEUE_NAME, true, consumer);
  }

	private static void doWork(String task) throws InterruptedException {
	    for (char ch: task.toCharArray()) {
		if (ch == '.') Thread.sleep(1000);
	    }
	}
}