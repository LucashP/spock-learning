package demo.spock.spring.config;

import demo.spock.bonus.BonusService;
import demo.spock.bonus.BonusServiceImpl;
import demo.spock.player.PlayerRepository;
import demo.spock.player.PlayerRepositoryImpl;
import demo.spock.player.PlayerService;
import demo.spock.player.PlayerServiceImpl;
import demo.spock.session.SessionService;
import demo.spock.session.SessionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    PlayerRepository playerRepository() {
        return new PlayerRepositoryImpl();
    }

    @Bean
    BonusService bonusService() {
        return new BonusServiceImpl();
    }

    @Bean
    SessionService sessionService() {
        return new SessionServiceImpl();
    }

    @Bean
    PlayerService playerService(PlayerRepository playerRepository, SessionService sessionService, BonusService bonusService) {
        return new PlayerServiceImpl(playerRepository, sessionService, bonusService);
    }
}
