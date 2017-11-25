package com.netcetera.ncau.java9beyondmodules.newwith9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  
  /**
   * The {@code isNull(Object object)} method was added in Java 1.8 and it is 
   * repeated here because its usage is not as high as the author wishes it to be.
   */
  @Test
  void isNull() {
    assertTrue(Objects.isNull(null));
    assertFalse(Objects.isNull(""));
  }

  /**
   * The {@code nonNull(Object object)} method was added in Java 1.8 and it is 
   * repeated here because its usage is not as high as the author wishes it to be.
   */
  @Test
  void nonNull() {
    assertFalse(Objects.nonNull(null));
    assertTrue(Objects.nonNull(""));
  }
  
  /**
   * The {@code requireNonNull(Object object, Supplier<String> supplier)} method was added in 
   * Java 1.8 and it is repeated here because its usage is not as high as the author wishes it to be.
   */
  @Test
  void requireNonNull() {
    assertThrows(NullPointerException.class, () -> Objects.requireNonNull(null, () -> "message"), "message");
    assertEquals("value", Objects.requireNonNull("value", () -> "message"));
  }
  
}
