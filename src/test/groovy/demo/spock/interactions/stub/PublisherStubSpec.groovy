package demo.spock.interactions.stub

import demo.spock.message.Message
import demo.spock.message.Publisher
import demo.spock.message.Subscriber
import spock.lang.Specification

class PublisherStubSpec extends Specification {

    def subscriber = Stub(Subscriber)
    def publisher = new Publisher([subscriber])

    def "should throw Spock exception when using cardinality section"() {
        when:
        publisher.send("hello")

        then:
        1 == 1
        //1 * subscriber.receive("hello") // Remove the cardinality (e.g. '1 *'), or turn the stub into a mock.
    }

    def "should show default values for stub"() {
        expect:
        def verify = publisher.verify()
        !verify
        println verify

        def list = publisher.list()
        list.size() == 0
        println list

        def find = publisher.find(1L)
        find
        println find.content
    }

    def "should show how stub works"() {
        given:
        subscriber.verify() >> true
        subscriber.list() >> [new Message("message1"), new Message("message2")]

        def id = 1L
        subscriber.find(id) >> new Message("concrete message")
        subscriber.find(_ as Long) >> new Message("message")
        subscriber.find(_) >> new Message("general message")

        expect:
        def verify = publisher.verify()
        verify
        println verify

        def list = publisher.list()
        list.size() == 2
        println list

        def find = publisher.find(id)
        find
        find.content == "concrete message"
        println find.content

        def find2 = publisher.find(2L)
        find2
        find2.content == "message"
        println find2.content
    }

}
