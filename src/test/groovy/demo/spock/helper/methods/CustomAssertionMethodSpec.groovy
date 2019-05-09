package demo.spock.helper.methods

import demo.spock.calculator.Calculator
import demo.spock.player.Player
import demo.spock.player.PlayerStatus
import spock.lang.Specification

class CustomAssertionMethodSpec extends Specification {

    def calculator = new Calculator()

    def "should show simple assertions in 'then' block"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE
        def player = new Player(id: id, name: name, status: status)

        expect:
        player.id == id
        player.name == name
        player.status == status
    }

    def "should show custom assertion method"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE
        def player = new Player(id: id, name: name, status: status)
//        def player = new Player(id: id, name: name + "Changed", status: status)

        expect:
//        customAssertionWrong(player, id, name, status) // mess up test change setup
//        customAssertionWitBoolean(player, id, name, status)
        customAssertion(player, id, name, status)
    }

    def "should show custom assertion method with verifyAll"() {
        given:
        def id = 1L
        def name = "Bob"
        def status = PlayerStatus.ACTIVE
        def player = new Player(id: id, name: name, status: status)
//        def player = new Player(id: id, name: name + " ", status: status)

        expect:
//        verifyAll {
//            customAssertion(player, id, name, status)
//        }
//        customAssertionWithVerifyAllWithAssert(player, id, name, status)
        customAssertionWithVerifyAll(player, id, name, status)
    }

    def customAssertionWrong(player, id, name, status) {
        player.id == id
        player.name == name
        player.status == status //return result of last expression
    }

    def customAssertionWitBoolean(player, id, name, status) { //returns boolean - report not readable
        player.id == id && player.name == name && player.status == status
    }

    void customAssertion(player, id, name, status) {
        assert player.id == id
        assert player.name == name
        assert player.status == status
    }

    void customAssertionWithVerifyAllWithAssert(player, id, name, status) {
        verifyAll {
            assert player.id == id
            assert player.name == name
            assert player.status == status
        }
    }

    void customAssertionWithVerifyAll(player, id, name, status) { // report is much more complex
        verifyAll {
            player.id == id
            player.name == name
            player.status == status
        }
    }
}
