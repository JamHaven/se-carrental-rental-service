package pacApp;

import pacApp.pacData.RentalRepository;
import pacApp.pacData.UserRepository;
import pacApp.pacLogic.Constants;
import pacApp.pacModel.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartup.class);
    private RentalRepository repository;
    private PasswordEncoder passwordEncoder;

    public ApplicationStartup(RentalRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event){
        log.info(event.toString());
        //this.repository.deleteAll();
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(event.toString());
    }
}
