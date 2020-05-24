package pacApp;

import com.netflix.discovery.converters.Auto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import pacApp.pacModel.Rental;

public class RentalSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    //@Autowired
    //private Queue queue;

    public void send(Rental rental) {
        this.template.convertAndSend(topic.getName(), Long.toString(rental.getCarId()));
    }
}
