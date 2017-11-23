package com.netcetera.ncau.java9beyondmodules.newwith9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * Tests showing the new methods on {@link java.lang.Object}.
 */
class ObjectsTest {
  
  @Test
  void requireNonNullElse() {
    assertEquals("default", Objects.requireNonNullElse(null, "default"));
    assertEquals("value", Objects.requireNonNullElse("value", "default"));
  }
  
  @Test
  void requireNonNullElseGet() {
    assertEquals("default", Objects.requireNonNullElseGet(null, () -> "default"));
    assertEquals("value", Objects.requireNonNullElseGet("value", () -> "default"));
  }
  
  @Test
  void checkIndex() {
    assertEquals(0, Objects.checkIndex(0, 10));
    assertEquals(5, Objects.checkIndex(5, 10));
    assertEquals(9, Objects.checkIndex(9, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> Objects.checkIndex(10, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> Objects.checkIndex(-1, 10));
  }

  @Test
  void checkFromToIndex() {
    assertEquals(0, Objects.checkFromToIndex(0, 9, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> Objects.checkFromToIndex(9, 11, 10));
  }
  
  @Test
  void checkFromIndexSize() {
    assertEquals(0, Objects.checkFromIndexSize(0, 10, 10));
    assertThrows(IndexOutOfBoundsException.class, () -> Objects.checkFromIndexSize(9, 2, 10));
  }

}
