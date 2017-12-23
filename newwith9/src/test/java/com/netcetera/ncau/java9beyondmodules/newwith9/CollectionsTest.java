package com.netcetera.ncau.java9beyondmodules.newwith9;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Tests showing the new collection factory methods in Java 9.
 */
class CollectionsTest {

  @Test
  void setOf() {
    assertThat(Set.of(1, 2, 3), containsInAnyOrder(1, 2, 3));
    assertThrows(UnsupportedOperationException.class, () -> Set.of(1).add(2));
  }

  @Test
  void listOf() {
    assertThat(List.of(1, 2, 3), contains(1, 2, 3));
    assertThrows(UnsupportedOperationException.class, () -> List.of(1).add(2));
  }

  @Test
  void mapOf() {
    assertThat(Map.of(1, 'A', 2, 'B'), hasEntry(1, 'A'));
    assertThrows(UnsupportedOperationException.class, () -> Map.of(1, 'A').put(2, 'B'));
  }

  @Test
  void mapOfEntries() {
    assertThat(Map.ofEntries(Map.entry(1, 'A'), Map.entry(2, 'B')), hasEntry(1, 'A'));
    assertThrows(UnsupportedOperationException.class, () -> Map.ofEntries(Map.entry(1, 'A')).put(2, 'B'));
  }
}
