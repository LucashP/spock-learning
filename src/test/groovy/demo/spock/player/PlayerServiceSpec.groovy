package demo.spock.player

import demo.spock.bonus.BonusService
import demo.spock.session.SessionService
import spock.lang.Specification

class PlayerServiceSpec extends Specification {

    def playerRepository = Stub(PlayerRepository)
    def bonusService = Mock(BonusService)           // Mock play Stub role
    def sessionService = Mock(SessionService)       // check pom.xml -> enables mocking of classes

    def playerService = new PlayerService(playerRepository, sessionService, bonusService)

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
}
