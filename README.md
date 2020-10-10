# Java Concurrent Data Structures - Analysis

This project analyses the performance of different implementations of Java Concurrent Data structures.

This repository contains

```
$ tree -L 1
.
├── LICENSE
├── README.md
├── code         --> the Java data structure code to test
├── report       --> the technical report
└── results      --> the test results & the plotting code
```

# Prepare your testing environment

```
$ cd code
```

## JMH instance

To start, create your own instance of JMH :

```
$ hg clone http://hg.openjdk.java.net/code-tools/jmh/ openjdk-jmh
[...]
$ cd openjdk-jmh
$ mvn clean install -DskipTests
[...]
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for Java Microbenchmark Harness Parent 1.24-SNAPSHOT:
[INFO] 
[INFO] Java Microbenchmark Harness Parent ................. SUCCESS [  1.363 s]
[INFO] JMH Core ........................................... SUCCESS [  8.269 s]
[INFO] JMH Generators: Annotation Processors .............. SUCCESS [  2.428 s]
[INFO] JMH Core Integration Tests ......................... SUCCESS [ 11.566 s]
[INFO] JMH Generators: Reflection ......................... SUCCESS [  1.132 s]
[INFO] JMH Generators: ASM ................................ SUCCESS [  1.165 s]
[INFO] JMH Core Compilation Tests ......................... SUCCESS [  0.811 s]
[INFO] JMH Core Benchmarks ................................ SUCCESS [  6.149 s]
[INFO] JMH Samples ........................................ SUCCESS [  6.828 s]
[INFO] JMH Generators: Bytecode ........................... SUCCESS [  1.273 s]
[INFO] JMH Archetypes ..................................... SUCCESS [  0.011 s]
[INFO] JMH Benchmark Archetype: Java ...................... SUCCESS [  0.688 s]
[INFO] JMH Benchmark Archetype: Scala ..................... SUCCESS [  0.049 s]
[INFO] JMH Benchmark Archetype: Groovy .................... SUCCESS [  0.050 s]
[INFO] JMH Benchmark Archetype: Kotlin .................... SUCCESS [  0.048 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  42.192 s
[INFO] Finished at: 2020-05-24T16:53:25+02:00
[INFO] ------------------------------------------------------------------------
```
This step is not mandatory, but allow you to work on a stable local version of JMH. You only need to do this once, and Maven deploy it into your Maven repo on your local machine.

# Maven project

The Maven project to test the code has been created like this :

```
$ mvn archetype:generate \
     -DinteractiveMode=false \
     -DarchetypeGroupId=org.openjdk.jmh \
     -DarchetypeArtifactId=jmh-java-benchmark-archetype \  --> Java code testing
     -DgroupId=fr.insalyon.telecom.concurrent \            --> Packages structure
     -DartifactId=benchmarks \                             --> Local repository
     -Dversion=1.24-SNAPSHOT                               --> Current version of JMH previously deployed 
[...]
[INFO] Generating project in Batch mode
[INFO] Archetype [org.openjdk.jmh:jmh-java-benchmark-archetype:1.23] found in catalog remote
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: jmh-java-benchmark-archetype:1.23
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: fr.insalyon.telecom.concurrent
[INFO] Parameter: artifactId, Value: benchmarks
[INFO] Parameter: version, Value: 1.24-SNAPSHOT
[INFO] Parameter: package, Value: fr.insalyon.telecom.concurrent
[INFO] Parameter: packageInPathFormat, Value: fr/insalyon/telecom/concurrent
[INFO] Parameter: package, Value: fr.insalyon.telecom.concurrent
[INFO] Parameter: groupId, Value: fr.insalyon.telecom.concurrent
[INFO] Parameter: artifactId, Value: benchmarks
[INFO] Parameter: version, Value: 1.24-SNAPSHOT
[INFO] Project created from Archetype in dir: /[MyPath]/code/benchmarks
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.436 s
[INFO] Finished at: 2020-05-24T16:58:54+02:00
[INFO] ------------------------------------------------------------------------
```

This structure is already present in the repository.

## Testing the code 

```
$ cd benchmarks
$ mvn clean install
$ java -jar target/benchmarks.jar
```

