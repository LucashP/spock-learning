# Start project with Spock
## Dependencies
Check [pom.xml](pom.xml)

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
[Example - HelloWorld](src/test/groovy/demo/spock/HelloWorldSpec.groovy)

# 'Equals' method and object creation with maps
- Example with equals method. [Example](src/test/groovy/demo/spock/EqualsSpec.groovy)
- Examples of object creation in groovy [Example](src/test/groovy/demo/spock/map/MapSpec.groovy)

# Fixture methods
Fixture methods are responsible for setting up and cleaning up the environment in which feature methods are run. 

- interaction with JUnit

# Field
Initialization of tested class in different way
[Example](src/test/groovy/demo/spock/field/InstanceSpec.groovy)

# Feature methods
By convention, feature methods are named with String literals. Try to choose good names for your feature methods, and feel free to use any characters you like!
Conceptually, a feature method consists of four phases:
1) Set up the feature’s fixture
2) Provide a stimulus to the system under specification
3) Describe the response expected from the system
4) Clean up the feature’s fixture

## Blocks vs Phases
 There are six kinds of blocks: given, when, then, expect, cleanup, and where blocks.
[Example](src/test/groovy/demo/spock/feature/methods/BlocksWithPhasesSpec.groovy)

## Given
## When Then Expect
## Assertions
## Exceptions
## Where

# Helper methods
- `verifyAll`
- `with`
- Custom assertions
- `Groovy Truth`
- Extensions
- Method unrolling

# Mocks, Stubs
- PlayerServiceSpec
- PublisherSpec
- PlayerRepositorySpec - Chaining stubs/mocks

# Missing topics
- Spies
- Spring context

# Sources
- http://spockframework.org/spock/docs/1.3/all_in_one.html
- https://www.youtube.com/watch?v=KEFskVPwlz8
- https://www.youtube.com/watch?v=jlbJNhmNHKY