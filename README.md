# Grasp unit testing

- Unit testing is one of the major pillars in any modern automated testing strategy. They are small isolated tests that
  run really fast and provide good feedback on if our business logic is implemented well.
- They also enable a TDD like style of development and are an essential refactoring toolbox since you can comfortably
  change application code while resting assured that unit tests would break and catch any errors.
- This repo provides a simple Kotlin JVM based project to showcase and learn unit testing concepts.

## Pre-requisites

- I'll use an Apple M1 Pro machine with mac OS ventura 13.1 with Java 17.0.6 and Kotlin 1.8.10.
  The configuration in your machine might differ but rest assured the principles remain largely the same.
- You can find tests written in path: `src/test/java/io/automationhacks`