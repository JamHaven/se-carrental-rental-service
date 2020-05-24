package pacApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import pacApp.pacData.RentalRepository;

public class CarReceiver {

    private static final Logger log = LoggerFactory.getLogger(CarReceiver.class);
    @Autowired
    private RentalRepository repository;

    public CarReceiver() { }

    @RabbitListener(queues = "#{autoDeleteCarQueue.name}")
    public void receive(String input) throws InterruptedException {
        log.info("receive: " + input);
    }
}
