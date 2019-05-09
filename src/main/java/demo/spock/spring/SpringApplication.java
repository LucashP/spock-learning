package demo.spock.spring;

import demo.spock.bonus.BonusService;
import demo.spock.player.PlayerRepository;
import demo.spock.player.PlayerService;
import demo.spock.session.SessionService;
import demo.spock.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context);
        System.out.println("######################################################################################");

        PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
        System.out.println(playerRepository);

        BonusService bonusService = context.getBean(BonusService.class);
        System.out.println(bonusService);

        SessionService sessionService = context.getBean(SessionService.class);
        System.out.println(sessionService);

        PlayerService playerService = context.getBean(PlayerService.class);
        System.out.println(playerService);
    }
}
