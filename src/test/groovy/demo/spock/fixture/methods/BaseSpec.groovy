package demo.spock.fixture.methods

import spock.lang.Specification

class BaseSpec extends Specification {

    def setupSpec() {
        println "base setupSpec" // runs once -  before the first feature method
    }

    def setup() {
        println "base setup" // runs before every feature method
    }

    def cleanup() {
        println "base cleanup ##########################" // runs after every feature method
    }

    def cleanupSpec() {
        println "base cleanupSpec" // runs once -  after the last feature method
    }
}
