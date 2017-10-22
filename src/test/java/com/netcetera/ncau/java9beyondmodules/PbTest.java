package com.netcetera.ncau.java9beyondmodules;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class PbTest {

  @Test
  public void besserJetztAlsSpaeter() {
    ZonedDateTime a = ZonedDateTime.parse("2017-10-29T02:05+02:00[Europe/Zurich]");
    ZonedDateTime b = ZonedDateTime.parse("2017-10-29T02:05+01:00[Europe/Zurich]");
    assertTrue(a.isBefore(b));

    Duration oneHour = Duration.ofHours(1L);
    assertEquals(oneHour, Duration.between(a, b));
  }

}
