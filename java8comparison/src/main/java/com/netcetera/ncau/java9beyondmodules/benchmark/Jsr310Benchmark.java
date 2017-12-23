package com.netcetera.ncau.java9beyondmodules.benchmark;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Demonstrates various performance improvements made to the JSR-310
 * implementation in Java 9.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Jsr310Benchmark {

  private static final LocalDate LOCAL_DATE = LocalDate.of(2017, 11, 30);

  private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(LOCAL_DATE, LocalTime.of(16, 0));

  private Date date;

  private SimpleDateFormat simpleDateFormat;

  /**
   * Set up the benchmark state.
   */
  @Setup
  public void setup() {
    this.date = Date.from(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant());
    this.simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
  }

  /**
   * Demonstrates the performance improvements made to
   * {@link ZoneId#systemDefault()}.
   *
   * @return object to black hole
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
   * @return object to black hole
   * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8068803">JDK-8068803</a>
   */
  @Benchmark
  public LocalDate plusDays() {
    return LOCAL_DATE.plusDays(1L);
  }

  /**
   * Demonstrates the performance of {@link java.util.Calendar#add(int, int)}
   * compared to JSR-310.
   *
   * @return object to black hole
   */
  @Benchmark
  public Date calendarAddDays() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    return calendar.getTime();
  }

  /**
   * Demonstrates formatting performance improvements.
   *
   * @return object to black hole
   */
  @Benchmark
  public String format() {
    return LOCAL_DATE.format(DateTimeFormatter.ISO_DATE);
  }

  /**
   * Demonstrates SimpleDateFormat formatting performance compared to JSR-310
   * performance.
   *
   * @return object to black hole
   */
  @Benchmark
  public String simapleDateFormat() {
    return this.simpleDateFormat.format(this.date);
  }

}
