package demo.spock.fixture.methods.junit

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import spock.lang.Specification

class BaseWithSpec extends Specification {

    @BeforeClass
    def junitSetupSpec() {
        println "base setupSpec" // runs once -  before the first feature method
    }

    @Before
    def junitSetup() {
        println "base setup" // runs before every feature method
    }

    @After
    def junitCleanup() {
        println "base cleanup ##########################" // runs after every feature method
    }

    @AfterClass
    def junitCleanupSpec() {
        println "base cleanupSpec" // runs once -  after the last feature method
    }
}
