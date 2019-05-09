package demo.spock.interactions.spy

import demo.spock.bonus.BonusService
import demo.spock.player.Player
import demo.spock.player.PlayerRepository
import demo.spock.player.PlayerRepositoryImpl
import demo.spock.player.PlayerService
import demo.spock.player.PlayerStatus
import demo.spock.session.SessionService
import spock.lang.Specification

class PlayerServiceSpySpec extends Specification {

//    PlayerRepositoryImpl playerRepository = Spy(constructorArgs: ["Fred"])
    def playerRepository = Spy(PlayerRepositoryImpl)
    def bonusService = Stub(BonusService)
    def sessionService = Mock(SessionService)
    def playerService = new PlayerService(playerRepository, sessionService, bonusService)

    def "should throw exception when using real findAll repository method"() {
        when:
        playerService.findAll()

        then:
        1 * playerRepository.findAll()

        def ex = thrown(RuntimeException)
        ex.message == "Not implemented yet"
    }

    def "should throw exception when using real repository method"() {
        given:
        def playerId = 1L
        bonusService.checkIfBonusAreAvailableForPlayer(playerId) >> true // stub

        when:
        playerService.login(playerId)

        then:
        1 * playerRepository.findOne(playerId)
        0 * sessionService.login(playerId)

        def ex = thrown(RuntimeException)
        ex.message == "Not implemented yet"
    }

    def "should pass test when override findAll repository method"() {
        given:
        playerRepository.findAll() >> [new Player()]

        when:
        def result = playerService.findAll()

        then:
        result.size() == 1
    }

    def "should pass test because when override repository findAll (looks like stub and mock)"() {
        when:
        def result = playerService.findAll()

        then:
        1 * playerRepository.findAll() >> [new Player()]
        result.size() == 1
    }
}
