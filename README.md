# Start project with Spock
## Dependencies
Look at example of [pom.xml](pom.xml)
1. Mandatory dependencies to start with Spock
    ``` xml
        ...
        <dependency>
            <groupId>org.spockframework</groupId>
            <artifactId>spock-core</artifactId>
            <scope>test</scope>
        </dependency>
        ...
        <plugin>
            <groupId>org.codehaus.gmavenplus</groupId>
            <artifactId>gmavenplus-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>compile</goal>
                        <goal>compileTests</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        ...
    ```
2. Optional dependencies for working with maven and Spock
    ``` xml
        ...
        <dependency> <!-- use a specific Groovy version rather than the one specified by spock-core -->
            <groupId>org.codehaus.groovy</groupId>
            <artifactId>groovy-all</artifactId>
            <scope>test</scope>
        </dependency>
        ...
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
                <useFile>false</useFile>
                <includes>
                    <include>**/*Test.java</include>
                    <include>**/*Spec.java</include>
                </includes>
            </configuration>
        </plugin>
        ...
    ```

## Specification
Spock lets you write specifications that describe expected features (properties, aspects) exhibited by a system of interest. The system of interest could be anything between a single class and a whole application, and is also called the system under specification or SUS. The description of a feature starts from a specific snapshot of the SUS and its collaborators; this snapshot is called the feature’s fixture.

``` groovy
class MyFirstSpecification extends Specification {
  // fields
  // fixture methods
  // feature methods
  // helper methods
}
```
- Hello World [HelloWorld](src/test/groovy/demo/spock/HelloWorldSpec.groovy)
- Example of naming tests [Example](src/test/groovy/demo/spock/naming/CalculatorSpec.groovy)

# `equals` and Groovy maps
- Example with equals method. 
[Example](src/test/groovy/demo/spock/EqualsSpec.groovy)
- Examples of object creation in groovy. 
[Example](src/test/groovy/demo/spock/map/MapSpec.groovy)

# Fixture methods
Fixture methods are responsible for setting up and cleaning up the environment in which feature methods are run.
 
- Example of using fixture methods. 
[Example](src/test/groovy/demo/spock/fixture/methods/FixtureMethodsSpec.groovy)
- Example of using fixture methods combined with JUnit. 
[Example](src/test/groovy/demo/spock/fixture/methods/junit/FixtureMethodsWithSpec.groovy)

# Field
Initialization of tested class in different way (`@Shared` annotation, `static` fields) 
[Example](src/test/groovy/demo/spock/field/InstanceSpec.groovy)

# Feature methods
By convention, feature methods are named with String literals. Try to choose good names for your feature methods, and feel free to use any characters you like!
Conceptually, a feature method consists of four phases:
1) Set up (`setup`) the feature’s fixture
2) Provide a `stimulus` to the system under specification
3) Describe the `response` expected from the system
4) Clean up (`cleanup`) the feature’s fixture

Whereas the first and last phases are optional, the `stimulus` and `response` phases are always present (except in interacting feature methods), and may occur more than once.

## `blocks` vs `phases`
 There are six kinds of blocks: `given`, `when`, `then`, `expect`, `cleanup`, and `where` blocks.
[Example](src/test/groovy/demo/spock/feature/methods/BlocksWithPhasesSpec.groovy)

## `when`, `then`, `expect`
The `when` and `then` blocks always occur together. They describe a stimulus and the expected response. Whereas when blocks may contain arbitrary code, then blocks are restricted to *conditions*, *exception conditions*, *interactions*, and *variable definitions*. A feature method may contain multiple pairs of when-then blocks.
[Example](src/test/groovy/demo/spock/feature/methods/WhenThenExpectAndSpec.groovy)

## `given`
The `given` block is where you do any setup work for the feature that you are describing.
[Example](src/test/groovy/demo/spock/feature/methods/GivenSetupCleanupBlockSpec.groovy)

## Assertions
However, conditions are written as plain boolean expressions, eliminating the need for an assertion API. (More precisely, a condition may also produce a non-boolean value, which will then be evaluated according to Groovy truth.) 
[Example of Groovy truth](src/test/groovy/demo/spock/helper/methods/GroovyTruthSpec.groovy)

Conditions are an essential ingredient of `then` blocks and `expect` blocks. To use conditions in other places, you need to designate them with Groovy’s `assert` keyword
[Example of assertions](src/test/groovy/demo/spock/feature/methods/AssertionsPositionSpec.groovy)

## Exceptions
Exception conditions are used to describe that a `when` block should throw an exception.
[Example](src/test/groovy/demo/spock/feature/methods/ExceptionsSpec.groovy)

## `where`
A `where` block always comes last in a method, and may not be repeated. It is used to write data-driven feature methods. 
[Example](src/test/groovy/demo/spock/feature/methods/WhereBlockSpec.groovy)

# Helper methods

## `verifyAll`
Normal expectations fail the test on the first failed assertions. Sometimes it is helpful to collect these failures before failing the test to have more information, this behavior is also known as soft assertions.
[Example](src/test/groovy/demo/spock/helper/methods/VerifyAllMethodSpec.groovy)

## `with`
You can use a `with(target, closure)` method to interact on the object being verified. This is especially useful in `then` and `expect` blocks
[Example](src/test/groovy/demo/spock/helper/methods/WithMethodSpec.groovy)

## Custom assertions
Sometimes feature methods grow large and/or contain lots of duplicated code. In such cases it can make sense to introduce one or more helper methods.
[Example](src/test/groovy/demo/spock/helper/methods/CustomAssertionMethodSpec.groovy)

## Extensions (`@Ignore`, `@IgnoreRest`)
Spock provides an interception-based extension mechanism. Extensions are activated by annotations called `directives`.
[Example](src/test/groovy/demo/spock/extensions/ExtensionsSpec.groovy)

## Method unrolling
A method annotated with `@Unroll` will have its iterations reported independently.
[Example](src/test/groovy/demo/spock/method/unrolling/UnrollSpec.groovy)

# Interactions
## Mocking
Mocking is the act of describing (mandatory) interactions between the object under specification and its collaborators. 
- Example of using *Cardinality*, *Target Constraint*, etc. [Example](src/test/groovy/demo/spock/interactions/mock/PublisherMockSpec.groovy)
- Example with param verification [Example](src/test/groovy/demo/spock/interactions/mock/PlayerServiceMockSpec.groovy)

## Stubbing
Stubbing is the act of making collaborators respond to method calls in a certain way. When stubbing a method, you don’t care if and how many times the method is going to be called; you just want it to return some value, or perform some side effect, *whenever* it gets called.
- Example with *default* values [Example](src/test/groovy/demo/spock/interactions/stub/PublisherStubSpec.groovy)
- Example with *chaining* [Example](src/test/groovy/demo/spock/interactions/stub/PlayerRepositoryStubSpec.groovy)

## Combine stubbing and mocking
When mocking and stubbing the same method call, they have to happen in the same interaction. In particular, the following Mockito-style splitting of stubbing and mocking into two separate statements will ***not*** work
[Example](src/test/groovy/demo/spock/player/PlayerServiceSpec.groovy)

## Spies
**Think twice** before using this feature. It might be better to change the design of the code under specification.
[Example](src/test/groovy/demo/spock/interactions/spy/PlayerServiceSpySpec.groovy)

# Missing topics
- Spring context

# Sources
- http://spockframework.org/spock/docs/1.3/all_in_one.html
- https://www.youtube.com/watch?v=KEFskVPwlz8
- https://www.youtube.com/watch?v=jlbJNhmNHKY