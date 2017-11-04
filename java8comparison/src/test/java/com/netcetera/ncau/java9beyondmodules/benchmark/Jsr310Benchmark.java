package com.netcetera.ncau.java9beyondmodules.benchmark;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

/**
 * Demonstrates various performance improvements made to the JSR-310
 * implementation in Java 9.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class Jsr310Benchmark {

  private static final LocalDate LOCAL_DATE = LocalDate.of(2017, 11, 30);

  private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(LOCAL_DATE, LocalTime.of(16, 0));

  /**
   * Demonstrates the performance improvements made to
   * {@link ZoneId#systemDefault()}.
   *
   * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8074002">JDK-8074002</a>
   */
  @Benchmark
  public ZonedDateTime atZone() {
    return LOCAL_DATE_TIME.atZone(ZoneId.systemDefault());
  }

  /**
   * Demonstrates the performance improvements made to
   * {@link LocalDate#plusDays(long)}.
   *
   * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8068803">JDK-8068803</a>
   */
  @Benchmark
  public LocalDate plusDays() {
    return LOCAL_DATE.plusDays(1L);
  }

}
