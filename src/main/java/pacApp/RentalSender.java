package pacApp;

import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import pacApp.pacModel.Rental;

public class RentalSender {

    private static final Logger log = LoggerFactory.getLogger(RentalSender.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    //@Autowired
    //private Queue queue;

    public void send(Rental rental) {
        log.info("send " + rental.toString());
        this.template.convertAndSend(topic.getName(), "car", Long.toString(rental.getCarId()));
    }
}
