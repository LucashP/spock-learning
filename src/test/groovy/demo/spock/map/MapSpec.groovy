package demo.spock.map

import demo.spock.player.CardDTO
import demo.spock.player.PlayerDTO
import demo.spock.player.PlayerStatus
import spock.lang.Specification

class MapSpec extends Specification {

    def id = 1L
    def name = "Bob"
    def status = PlayerStatus.ACTIVE
    def cardNumber = "4321432143214321"

    def "should show how 'equal' method works in assertions block"() {
        given:
        def player1 = createPlayerJavaLike(id, name, status, cardNumber)
        def player2 = new PlayerDTO(id: id, name: name, status: status, cards: [new CardDTO(cardNumber: cardNumber)])
        def player3 = createPlayerDTOWithMap(id, name, status, cardNumber)
        def player4 = createPlayerMap(id, name, status, cardNumber) as PlayerDTO
        PlayerDTO player5 = createPlayerMap(id, name, status, cardNumber)
        def map = createPlayerMap(id, name, status, cardNumber)
        def player6 = new PlayerDTO(map)

        expect:
        player1 == player2
        player1 == player3
        player1 == player4
        player1 == player5
        player1 == player6
    }

    private static def createPlayerJavaLike(long id, String name, PlayerStatus playerStatus, String cardNumber) {
        def cardDTO = new CardDTO()
        cardDTO.setCardNumber(cardNumber)

        def cards = new HashSet()
        cards.add(cardDTO)

        def playerDTO = new PlayerDTO()
        playerDTO.setId(id)
        playerDTO.setName(name)
        playerDTO.setStatus(playerStatus)
        playerDTO.setCards(cards)
        playerDTO
    }

    private static def createPlayerDTOWithMap(long id, String name, PlayerStatus playerStatus, String cardNumber) {
        [id    : id,
         name  : name,
         status: playerStatus,
         cards : [[cardNumber: cardNumber] as CardDTO]] as PlayerDTO
    }

    private static def createPlayerMap(long id, String name, PlayerStatus playerStatus, String cardNumber) {
        CardDTO cardMap = createCardMap(cardNumber)
//        def cardMap = createCardMap(cardNumber)
        [id    : id,
         name  : name,
         status: playerStatus,
         cards : [cardMap]]
    }

    private static def createCardMap(String cardNumber) {
        [cardNumber: cardNumber]
    }
}
