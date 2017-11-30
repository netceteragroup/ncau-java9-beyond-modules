NCAU Java 9 Beyond Modules
==========================

# Companion code for the NCAU "Java 9 beyond modules".

 * the `java8comparison` module contains code that demonstrates improvements made to existing APIs without changing them
   * `Benchmarks.java` is the launcher for all JMH microbenchmarks
   * `Jsr310Benchmark.java` contains microbenchmarks for Java Date and Time API classes
   * `UuidBenchmark.java` contains microbenchmarks for UUID
   * `StringLayout.java` demonstrates string layout changes in Java 9
   * `Jsr310Test.java` shows bugs in the fixed the Java Date and Time API in Java 9
 * the `newwith9` contains code that demonstrates new APIs with Java 9
   * `jce.jsh` illustrates how to use JShell to check for unlimited strength Java Cryptography Extensions
   * `ObjectsTest.java` illustrates the methods added to the class `Objects` in Java 9
   * `CollectionsTest.java` illustrates the methods added to the classes `Set`, `List` and `Map` in Java 9
   * `InputStreamTest.java` illustrates the `InputStream.transferTo()` method added in Java 9

## References

### Further Reading
 * [Overview of What’s New in JDK 9](https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-C23AFD78-C777-460B-8ACE-58BE5EA681F6)
 * [Java Time (JSR-310) enhancements in Java SE 9](http://blog.joda.org/2017/02/java-time-jsr-310-enhancements-java-9.html)
 * [Attach API cannot be used to attach to the current VM by default, JDK-8180425](http://www.oracle.com/technetwork/java/javase/9-notes-3745703.html#JDK-8178380)
 * [JEP 254: Compact Strings](http://openjdk.java.net/jeps/254)
 * [Relaxed strong encapsulation](http://openjdk.java.net/jeps/261#Relaxed-strong-encapsulation)
 * [VisualVM](https://visualvm.github.io/)
 * [Code Tools: jol](http://openjdk.java.net/projects/code-tools/jol/)
 * [Oracle Labs GraalVM](http://www.oracle.com/technetwork/oracle-labs/program-languages/downloads/index.html)
 * [JavaOne 2017: Changes to the JDK Release Model](https://www.youtube.com/watch?v=UeyyLielXsU)
 * [Installed Directory Structure of JDK and JRE](https://docs.oracle.com/javase/9/install/installed-directory-structure-jdk-and-jre.htm#JSJIG-GUID-F7178F2F-DC92-47E9-8062-CA6B2612D350)
 * [JCMD](https://docs.oracle.com/javase/9/tools/jcmd.htm#JSWOR743)

### GC
 * [Garbage-First Garbage Collector Tuning](https://docs.oracle.com/javase/9/gctuning/garbage-first-garbage-collector-tuning.htm#JSGCT-GUID-90E30ACA-8040-432E-B3A0-1E0440AB556A)
 * [JEP 304: Garbage Collector Interface](http://openjdk.java.net/jeps/304)
 * [JEP 312: Thread-Local Handshakes](http://openjdk.java.net/jeps/312)
 * [JDK 9 is the End of the Road for Some Features](https://marxsoftware.blogspot.ch/2017/01/jdk-9-is-end-of-road-for-some-features.html)
 * [Goodbye PrintGCDetails... and Other JDK 9 Changes!](https://www.infoq.com/presentations/java-9-gc)
 * [Shenandoah GC](https://wiki.openjdk.java.net/display/shenandoah/Main)
 * [CFV: New Project: ZGC](http://mail.openjdk.java.net/pipermail/announce/2017-October/000237.html)

### JMH
 * [OpenJDK: JMH](openjdk.java.net/projects/code-tools/jmh/)
 * [JMH REsources](https://psy-lob-saw.blogspot.ch/p/jmh-related-posts.html)
 * [JMH Visualizer](http://jmh.morethan.io/)
 