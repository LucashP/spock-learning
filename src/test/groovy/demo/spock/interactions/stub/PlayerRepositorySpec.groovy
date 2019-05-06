package demo.spock.interactions.stub

import demo.spock.player.PlayerDTO
import demo.spock.player.PlayerRepository
import spock.lang.Specification
import spock.lang.Unroll

class PlayerRepositorySpec extends Specification {

    def repository = Stub(PlayerRepository)

    @Unroll
    def "should return stub value (params to stub) [param=#param]"() {
        given:
        repository.findOne(40L) >> new PlayerDTO(id: 220)           // repository.findOne(40L) >> new PlayerDTO(id: 220)
        repository.findOne(50) >> new PlayerDTO(id: 250)            // repository.findOne(50L) >> new PlayerDTO(id: 250)
        repository.findOne(50L) >> new PlayerDTO(id: 270)
        repository.findOne(_ as Integer) >> new PlayerDTO(id: 200)      // completely omit
        repository.findOne(_ as Long) >> new PlayerDTO(id: 100)         // works because findOne method has declared Long param
        repository.findOne(_) >> new PlayerDTO(id: 300)

        when:
        def result = repository.findOne(param)

        then:
        result.id == expectedPlayerId

        where:
        param           | expectedPlayerId
        new Integer(40) | 220
        new Integer(50) | 250
        new Long(50)    | 250
        new Integer(20) | 100
        100L            | 100
        10              | 100 // Param type in repository
        1000l           | 100
        null            | 300
    }


    def "should return different stub values (chaining)"() {
        given:
        def id = 1L
        def player = new PlayerDTO(id: id)

        repository.findOne(_ as Long) >> player >> null >> {
            throw new RuntimeException("exception during retrieving player")
        }

        when:
        def first = repository.findOne(id)
        def second = repository.findOne(id)

        then:
        first == player
        second == null

        when:
        repository.findOne(id)

        then:
        thrown(RuntimeException)
    }
}