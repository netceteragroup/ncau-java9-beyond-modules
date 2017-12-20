package com.netcetera.ncau.java9beyondmodules;

import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.Arrays;

/**
 * Finds all thread safe {@link SecureRandomSpi}s.
 */
public final class ThreadSafeSecureRandom {

  private ThreadSafeSecureRandom() {
    throw new AssertionError("not instantiable");
  }

  /**
   * Main method, finds all thread safe {@link SecureRandomSpi}s.
   *
   * @param args ignored
   */
  public static void main(String[] args) {
    Arrays.stream(Security.getProviders())
      .flatMap(p -> p.entrySet().stream())
      .filter(e -> ((String) e.getKey()).startsWith("SecureRandom."))
      .filter(e -> ((String) e.getKey()).endsWith(" ThreadSafe"))
      .filter(e -> e.getValue().equals("true"))
      .map(e -> (String) e.getKey())
      .map(e -> e.substring("SecureRandom.".length(), e.length() - " ThreadSafe".length()))
      .forEach(System.out::println);

  }

}
