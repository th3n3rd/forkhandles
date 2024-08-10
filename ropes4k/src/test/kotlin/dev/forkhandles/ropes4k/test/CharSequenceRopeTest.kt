/*
 * Copyright (C) 2024 James Richardson
 *  - Originally Copyright (C) 2007 Amin Ahmad.
 * Licenced under GPL
 */

package dev.forkhandles.ropes4k.test

import dev.forkhandles.ropes4k.Rope

class CharSequenceRopeTest : RopeContract() {
    override fun make(s: String): Rope {
        return Rope.of(s)
    }
}