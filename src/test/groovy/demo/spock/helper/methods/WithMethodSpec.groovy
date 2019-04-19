package demo.spock.helper.methods


import demo.spock.player.PlayerDTO
import demo.spock.player.PlayerStatus
import spock.lang.Specification

class WithMethodSpec extends Specification {

    def "should show simple assertions in 'then' block"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE

        when:
        def player = new PlayerDTO(id: id, name: name, status: status)

        then:
        player.id == id
        player.name == name //mess up test
        player.status == status
    }

    def "should show 'with' method"() {
        given:
        def providedId = 1L
        def providedName = "Bob"
        def providedStatus = PlayerStatus.ACTIVE

        when:
        def player = new PlayerDTO(id: providedId, name: providedName, status: providedStatus)

        then:
        with(player) {
            id == providedId
            name == providedName
            status == providedStatus
        }
    }
}
