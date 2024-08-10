/*
 * Copyright (C) 2024 James Richardson
 * Licenced under GPL
 */

description = "ForkHandles ropes library"

plugins {
    id("org.jetbrains.kotlinx.benchmark") version "0.4.10"
    id("io.morethan.jmhreport") version "0.9.0"
}

kotlin {
    explicitApi()
}

dependencies {
    testImplementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:_")

    testImplementation(platform("org.junit:junit-bom:_"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("io.strikt:strikt-core:_")
}

tasks.test {
    useJUnitPlatform {
        excludeTags("Performance")
    }
}

// build.gradle.kts
benchmark {
    targets {
        register("test")
    }
    benchmark {
        configurations {
            register("single") {
                include(".*.\\.WriteComplexBenchmark")
            }
        }
    }
}

// currently has to be run by hand after the benchmark,else it picks up previous run :-(
jmhReport {

    fun findMostRecentJmhReportIn(d: File): String? {
        return d.walkBottomUp()
            .filter { it.name == "test.json" }
            .sortedByDescending { it.lastModified() }
            .firstOrNull()
            ?.absolutePath
            ?.also {
                println("Selected JMH Report is $it")
            }
    }

    jmhResultPath = findMostRecentJmhReportIn(project.file("build/reports/benchmarks"))
    jmhReportOutput = project.file("build/reports/benchmarks").absolutePath
}
