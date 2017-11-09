package com.netcetera.ncau.java9beyondmodules.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates various performance improvements made to {@link UUID}
 * implementation in Java 9.
 *
 * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8006627">JDK-8006627</a>
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class UuidBenchmark {

  private static final String TEST_UUID_STRING = "ba226cf7-d156-4b18-a78a-094736208cc9";

  private static final UUID TEST_UUID = UUID.fromString(TEST_UUID_STRING);

  /**
   * Demonstrates the performance improvements made to
   * {@link UUID#fromString(String)}.
   * 
   * @return object to black hole
   */
  @Benchmark
  public UUID parse() {
    return UUID.fromString(TEST_UUID_STRING);
  }

  /**
   * Demonstrates the performance improvements made to
   * {@link UUID#toString()}.
   * 
   * @return object to black hole
   */
  @Benchmark
  public String serialize() {
    return TEST_UUID.toString();
  }

}
