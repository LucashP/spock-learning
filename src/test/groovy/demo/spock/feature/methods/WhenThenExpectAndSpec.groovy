package demo.spock.feature.methods

import demo.spock.calculator.Calculator
import demo.spock.player.PlayerDTO
import demo.spock.player.PlayerStatus
import spock.lang.Specification

class WhenThenExpectAndSpec extends Specification {

    def calculator = new Calculator()

    def "should check 'expect' block behaviour"() {
        expect:
        calculator
        calculator.plus(1, 3)
        calculator.plus(1, 3) == 4
    }

    def "should check 'when' and 'then' block behaviour"() {
        when:
        def result = calculator.minus(1, -4)

        then:
        calculator
        result
        result == 5
    }

    def "should 'when' and 'then' block live together"() {
        when:
        1 + 1

        then:
        1 == 1
    }

    def "should show 'and' block"() {
        given:
        def id = 1L

        and: 'set name'
        def name = "Bob"

        and: 'set status for player'
        def status = PlayerStatus.ACTIVE

        when:
        def player = new PlayerDTO(id: id, name: name, status: status)

        then: 'check if ids are equal'
        player.id == id

        and: 'etc.'
        player.name == name
        player.status == status
    }

    def "it is not a test #1"() {
        println "it is not a test #1"
    }

    def "it is not a test #2"() {
        given:
        println "it is not a test #2"
    }
}
