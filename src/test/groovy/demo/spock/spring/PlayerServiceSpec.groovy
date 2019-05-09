package demo.spock.spring

import demo.spock.bonus.BonusService
import demo.spock.player.Player
import demo.spock.player.PlayerRepository
import demo.spock.player.PlayerService
import demo.spock.session.SessionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class PlayerServiceSpec extends BaseWithSpockSpringTestConfigSpec {

    @Autowired
    PlayerRepository playerRepository

    @Autowired
    BonusService bonusService

    @Autowired
    SessionService sessionService

    @Autowired
    PlayerService playerService

    @Autowired
    ApplicationContext context

    @Autowired
    BonusService alternativeBonusService

    def "should add bonuses when available for player and login in"() {
        given:
        def playerId = 1
        playerRepository.findOne(playerId) >> new Player(id: playerId) // stub

        when:
        playerService.login(playerId)

        then:
        1 * bonusService.checkIfBonusAreAvailableForPlayer(playerId) >> true // mock + stub
        1 * bonusService.addBonusForPlayer(playerId)
        1 * sessionService.login(playerId)
    }

    def "should add bonuses when available for player and login in (with order)"() {
        given:
        def playerId = 1
        playerRepository.findOne(playerId) >> new Player(id: playerId) // stub

        when:
        playerService.login(playerId)

        then:
        1 * bonusService.addBonusForPlayer(playerId)
        1 * bonusService.checkIfBonusAreAvailableForPlayer(playerId) >> true // mock + stub

        then:
        1 * sessionService.login(playerId)
    }

    def "should add bonuses when available for player and login in ('with' method)"() {
        given:
        def playerId = 1
        playerRepository.findOne(playerId) >> new Player(id: playerId) // stub

        when:
        playerService.login(playerId)

        then:
        with(bonusService) {
            1 * addBonusForPlayer(playerId)
            1 * checkIfBonusAreAvailableForPlayer(playerId) >> true
        }

        then:
        1 * sessionService.login(playerId)
    }

    def "should inject alternative BonusService bean"() {
        expect:
        alternativeBonusService == context.getBean("alternativeBonusService")
    }
}
