package demo.spock.spring

import demo.spock.bonus.BonusService
import demo.spock.spring.config.AppConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = AppConfig)
class SpringContextSpec extends Specification {

    @Autowired
    ApplicationContext context

    def "should initialize spring context"() {
        expect:
        context
        context.getBean(BonusService)
    }
}
