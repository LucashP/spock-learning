package demo.spock.spring

import demo.spock.spring.config.SpockSpringTestConfig
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = SpockSpringTestConfig)
class BaseWithSpockSpringTestConfigSpec extends Specification {

}
