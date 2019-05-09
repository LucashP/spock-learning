package demo.spock

import demo.spock.player.CardDTO
import demo.spock.player.PlayerDTO
import demo.spock.player.PlayerStatus
import spock.lang.Specification

class EqualsSpec extends Specification {

    def "should show how 'equal' method works in assertions block"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE
        def cardNumber = "4321432143214321"

        def player1 = new PlayerDTO(id: id, name: name, status: status, cards: [new CardDTO(cardNumber: cardNumber)])
        def player2 = new PlayerDTO(id: id, name: name, status: status, cards: [new CardDTO(cardNumber: cardNumber)])

        expect:
        player1 == player2
        1 == 1L
        status.equals(PlayerStatus.ACTIVE)
        assert cardNumber == "4321432143214321"
    }
}
