package demo.spock.player

import spock.lang.Specification

class PlayerRepositorySpec extends Specification {

    def "should return different stub values"() {
        given:
        [:]
        def id = 1L
        def player = new PlayerDTO(id: id)
        def repository = Mock(PlayerRepository)

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
