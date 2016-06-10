/* PRODUCER 

Bindings:
- Bindings can take an extra routingKey parameter.
- O avoid the confusion with a basic_publish parameter
    - ex: channel.queueBind(queueName, EXCHANGE_NAME, "black");

- Fanout exchanges, which we used previously, simply ignored its value.

Direct exchange:
- We want to extend that to allow filtering messages based on their severity.
- direct exchange improved our system, it still has limitations:
    - it can't do routing based on multiple criteria.

*/

public class _11producer_EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws java.io.IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String severity = getSeverity(argv);
        String message = getMessage(argv);

        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

        channel.close();
        connection.close();
    }
    //..
}


