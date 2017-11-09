package com.netcetera.ncau.java9beyondmodules.benchmark;

import static org.openjdk.jmh.results.format.ResultFormatType.TEXT;

import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Main class running the benchmarks.
 */
public final class Benchmarks {
  
  private Benchmarks() {
    throw new AssertionError("not instantiable");
  }

  /**
   * Main method, runs the benchmarks.
   *
   * @param args first element contains the file name
   * @throws RunnerException  if something goes wrong during execution
   */
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
            .include("com.netcetera.ncau.java9beyondmodules.benchmark.*")
            .warmupIterations(10)
            .measurementIterations(10)
            .forks(10)
            .addProfiler(GCProfiler.class)
            .resultFormat(TEXT)
            .output(args[0])
            .build();
    new Runner(options).run();
  }

}
