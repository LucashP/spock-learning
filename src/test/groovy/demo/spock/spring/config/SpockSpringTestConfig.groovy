package demo.spock.spring.config

import demo.spock.bonus.BonusService
import demo.spock.player.PlayerRepository
import demo.spock.player.PlayerService
import demo.spock.player.PlayerServiceImpl
import demo.spock.session.SessionService
import org.spockframework.spring.xml.SpockMockFactoryBean
import org.springframework.beans.factory.FactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spock.mock.DetachedMockFactory

@Configuration
class SpockSpringTestConfig {
    def mockFactory = new DetachedMockFactory()

    @Bean
    PlayerRepository playerRepository() {
        println "initialize stub for PlayerRepository"
        mockFactory.Stub(PlayerRepository)
    }

    @Bean
    BonusService bonusService() {
        println "initialize mock for BonusService"
        mockFactory.Mock(BonusService)
    }

    @Bean
    FactoryBean<BonusService> alternativeBonusService() {
        println "initialize alternative mock for BonusService"
        new SpockMockFactoryBean(BonusService)
    }

    @Bean
    SessionService sessionService() {
        println "initialize mock for SessionService"
        mockFactory.Mock(SessionService)
    }

    @Bean
    PlayerService playerService(PlayerRepository playerRepository, SessionService sessionService, BonusService bonusService) {
        new PlayerServiceImpl(playerRepository, sessionService, bonusService)
    }
}

