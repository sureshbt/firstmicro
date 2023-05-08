package com.sureshmicro.notification;
import com.sureshmicro.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (
        scanBasePackages = {
                "com.sureshmicro.notification",
                "com.sureshmicro.amqp",
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
  //@Bean
    //CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
      //  return args -> {
        //  producer.publish(new Person("Gautham",29),
          //        notificationConfig.getInternalExchange(),
            //      notificationConfig.getInternalNotificationRoutingKey());

        //};

   // }
    //record  Person(String name,int age) {}
}