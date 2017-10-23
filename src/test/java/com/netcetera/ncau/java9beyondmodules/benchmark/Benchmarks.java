package com.netcetera.ncau.java9beyondmodules.benchmark;

import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.HotspotMemoryProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Main class running the benchmaks.
 */
public final class Benchmarks {

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
            .include("com.netcetera.ncau.java9beyondmodules.benchmark.*")
            .warmupIterations(10)
            .measurementIterations(10)
            .forks(10)
            .addProfiler(GCProfiler.class)
            .addProfiler(HotspotMemoryProfiler.class)
            .build();
    new Runner(options).run();
  }

}
