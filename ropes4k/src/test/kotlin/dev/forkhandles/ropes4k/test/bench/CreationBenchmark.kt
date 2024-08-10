/*
 * Copyright (C) 2024 James Richardson
 *  - Originally Copyright (C) 2007 Amin Ahmad.
 * Licenced under GPL
 */

package dev.forkhandles.ropes4k.test.bench

import dev.forkhandles.ropes4k.Rope
import dev.forkhandles.ropes4k.test.bench.BenchmarkFiles.Companion.aChristmasCarol
import dev.forkhandles.ropes4k.test.bench.BenchmarkFiles.Companion.aChristmasCarolRaw
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup
import java.util.concurrent.TimeUnit
import kotlin.text.StringBuilder

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
open class CreationBenchmark {


    @Benchmark
    fun string(): Any {
        return String(aChristmasCarolRaw)
    }

    @Benchmark
    fun stringbuilder(): Any {
        return StringBuilder(aChristmasCarol)
    }

    @Benchmark
    fun rope_charsequence(): Any {
        return Rope.of(aChristmasCarol)
    }

    @Benchmark
    fun rope_chararray(): Any {
        return Rope.ofCopy(aChristmasCarolRaw)
    }
}
