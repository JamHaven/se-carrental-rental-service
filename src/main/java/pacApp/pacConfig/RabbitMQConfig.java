package pacApp.pacConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pacApp.CarReceiver;
import pacApp.RentalSender;

@Configuration
public class RabbitMQConfig {

    /*
    @Bean
    public Queue rentalsQueue() {
        return new Queue("rentals");
    } */

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("rentals");
    }

    @Bean
    public CarReceiver carReceiver() {
        return new CarReceiver();
    }

    @Bean
    public RentalSender rentalSender() {
        return new RentalSender();
    }

    @Bean
    public Queue autoDeleteCarQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding carBinding(TopicExchange topic, Queue autoDeleteCarQueue){
        return BindingBuilder.bind(autoDeleteCarQueue).to(topic).with("rental");
    }
}
