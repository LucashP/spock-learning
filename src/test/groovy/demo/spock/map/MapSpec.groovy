package demo.spock.map

import demo.spock.player.Card
import demo.spock.player.Player
import demo.spock.player.PlayerStatus
import spock.lang.Specification

import static demo.spock.player.PlayerStatus.ACTIVE
import static demo.spock.player.PlayerStatus.LOCKED

class MapSpec extends Specification {


    def "should show how 'equal' method works in assertions block"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = ACTIVE
        def cardNumber = "4321432143214321"

        and:
        def player1 = createPlayerJavaLike(id, name, status, cardNumber)
        def player2 = new Player(id: id, name: name, status: status, cards: new HashSet<>(Arrays.asList(new Card(cardNumber: cardNumber))))

        def playerMap = [id    : id,
                         name  : name,
                         status: status,
                         cards : [[cardNumber: cardNumber] as Card]]
        def player3 = playerMap as Player
        Player player4 = playerMap
        def player5 = new Player(playerMap)

        def player6 = playerMap << [status: LOCKED, cards: []] as Player // left shift operator

        expect:
        player1 == player2
        player1 == player3

        player4 instanceof Player
        player1 == player4

        player1 == player5

        player6.cards.size() == 0
        player6.status == LOCKED
    }

    private static def createPlayerJavaLike(long id, String name, PlayerStatus playerStatus, String cardNumber) {
        def cardDTO = new Card()
        cardDTO.setCardNumber(cardNumber)

        def cards = new HashSet()
        cards.add(cardDTO)

        def playerDTO = new Player()
        playerDTO.setId(id)
        playerDTO.setName(name)
        playerDTO.setStatus(playerStatus)
        playerDTO.setCards(cards)
        playerDTO
    }
}
