package demo.spock.interactions.mock

import demo.spock.bonus.BonusService
import demo.spock.player.Player
import demo.spock.player.PlayerRepository
import demo.spock.player.PlayerService
import demo.spock.player.PlayerStatus
import demo.spock.session.SessionService
import spock.lang.Specification

class PlayerServiceMockSpec extends Specification {

    def playerRepository = Mock(PlayerRepository)
    def bonusService = Mock(BonusService)
    def sessionService = Mock(SessionService)

    def playerService = new PlayerService(playerRepository, sessionService, bonusService)

    def "should verify params passed to mock"() {
        given:
        def id = 1l
        def name = "Bob"
        def player = new Player(id: id, name: name, status: PlayerStatus.ACTIVE)

        when:
        playerService.save(player)

        then:
        1 * playerRepository.save({ Player it ->
            assert it.id == id
            assert it.name == name
            it.id == id && it.name == name // closure should return boolean value
//            true
        })
    }

    def "should verify params passed to mock with extracted method"() {
        given:
        def name = "Bob"
        def status = PlayerStatus.ACTIVE
        def player = new Player(id: 1L, name: name, status: status)

        when:
        playerService.save(player)

        then:
        1 * playerRepository.save({ Player it -> verifyPlayer(it, name, status)})
    }

    private def verifyPlayer(Player actual, String expectedName, PlayerStatus expectedStatus) {
        verifyAll(actual) {
            actual.name == expectedName
            actual.status == expectedStatus
        }
        true
    }
}
