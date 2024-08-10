/*
 * Copyright (C) 2024 James Richardson
 *  - Originally Copyright (C) 2007 Amin Ahmad.
 * Licenced under GPL
 */
package dev.forkhandles.ropes4k.test.bench

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.Random

class BenchmarkFiles {

    data class Insert(val location: Int, val offset: Int, val length: Int)

    companion object {
        private var seed = 342342
        val random = Random(seed.toLong())

        const val PLAN_LENGTH = 500

        private fun readpath(path: String): CharArray = File(path).readText().toCharArray()

        val aChristmasCarolRaw = readpath("test-files/AChristmasCarol_CharlesDickens.txt")
        val bensAutoRaw = readpath("test-files/AutobiographyOfBenjaminFranklin_BenjaminFranklin.txt")
        val aChristmasCarol = String(aChristmasCarolRaw)
        val bensAuto = String(bensAutoRaw)
    }
}
