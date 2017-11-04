package com.netcetera.ncau.java9beyondmodules.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

/**
 * Validates bug fixes made to the JSR-310 implementation in Java 9.
 */
public class Jsr310Test {

  /**
   * Validates parsing the ZoneOffset around the DST fall transition.
   *
   * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8066982">JDK-8066982</a>
   */
  @Test
  public void zonedDateTimeParse() {
    ZonedDateTime a = ZonedDateTime.parse("2017-10-29T02:05+02:00[Europe/Zurich]");
    ZonedDateTime b = ZonedDateTime.parse("2017-10-29T02:05+01:00[Europe/Zurich]");
    assertTrue(a.isBefore(b));

    Duration oneHour = Duration.ofHours(1L);
    assertEquals(oneHour, Duration.between(a, b));
  }

}
