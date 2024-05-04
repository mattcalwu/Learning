# Notes

## Gradlew

Gradle Wrapper is the preferred way of starting a Gradle build. 

The wrapper downloads and then invokes a specific version of Gradle declared in
the build.

It's as easy as calling

```
./gradlew build
```

## Part 2: Running Tasks

Click on the elephant in the right to look at the tasks provided by gradle!

You can double-click on the cog to run the task!
Tutorial > app > build > build

Additionally, look in build.gradle to see custom defined tasks written that also have dependencies.

If a task depends on another one, then when you run it, gradle will automatically run the other task before it.

## Part 3: Dependency Management

### Maven Central

[Maven Central](https://mvnrepository.com/repos/central) is backed by [Sonatype](https://central.sonatype.org/)
Given:

`com.google.guava:guava:32:1.2-jre`
`org.junit.jupiter:junit-jupiter-api:5.9.1`

Maven needs the group (identifier of an organization), the name (dependency
identifier) and version (version # to import).

### Project Dependencies

Run:

`./gradlew :app:dependencies`

Or 

`./gradlew build --scan`

## Part 4: Applying Plugins

Look at the build.gradle file. 

Generally, plugins use the Gradle API to provide additional functionality and
extend Gradle's core features. 

Lastly, they are used to extend build capability and customize Gradle.

Plugins are distributed in three ways:

1. Core plugins - Gradle develops and maintains a set of Core Plugins
2. Community plugins - Gradle community shared plugins via Gradle Plugin Portal
3. Custom plugins - Gradle enables users to create custom plugins using APIs

Convention plugins are plugins used to share build logic between subprojects.
Users can wrap common logic in a convention plugin. For example, a code coverage
plugin used as a convention plugin can survey code coverage for the entire
project and not just a specific subproject. 


## Part 5: Exploring Incremental Builds

Incremental builds are builds that avoid running tasks whose inputs didn't
change since the previous build, making the execution of such tasks unnecessary.

In order for them to work, tasks must define their inputs and outputs. At build
time, Gradle will determine whether the inputs or outputs have changed. If they
have changed, Gradle will execute the task. Otherwise it will skip execution.

In order to see this in action, create in the root folder of the project
(tutorial) a `gradle.properties` file

```
$ touch gradle.properties
```

And in it add

`org.gradle.console=verbose`

__Labels__

- UP-TO-DATE    ::    Task that hasn't changed(incremental build)
- SKIPPED       ::    Task explicitly prevented from running 
- FROM-CACHE    ::    Task output has been copied from build cache
- NO-SOURCE     ::    Task was not executed because required input not available

If there is no label, then task was executed by Gradle

## Part 6: Enabling the Gradle Build Cache































