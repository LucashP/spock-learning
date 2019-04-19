package demo.spock.helper.methods


import demo.spock.player.Player
import demo.spock.player.PlayerStatus
import spock.lang.Specification

class VerifyAllMethodSpec extends Specification {

    def "should show simple assertions in 'then' block"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE

        when:
        def player = new Player(id: id, name: name, status: status)

        then:
        player.id == id
        player.name == name //mess up test
        player.status == status
    }

    def "should show 'verifyAll' method"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE

        when:
        def player = new Player(id: id, name: name, status: status)

        then:
        verifyAll {
            player.id == id
            player.name == name //mess up test
            player.status == status //mess up test
        }
    }

    def "should show combination of 'with' and 'verifyAll' methods"() {
        given:
        def providedId = 1L
        def providedName = "Bob"
        def providedStatus = PlayerStatus.ACTIVE

        when:
        def player = new Player(id: providedId, name: providedName, status: providedStatus)

        then:
        with(player) {
            verifyAll {
                id == providedId
                name == providedName
                status == providedStatus
            }
        }
    }
}
