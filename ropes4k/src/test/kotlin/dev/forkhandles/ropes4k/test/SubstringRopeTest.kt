/*
 * Copyright (C) 2024 James Richardson
 *  - Originally Copyright (C) 2007 Amin Ahmad.
 * Licenced under GPL
 */

package dev.forkhandles.ropes4k.test

import dev.forkhandles.ropes4k.Rope
import dev.forkhandles.ropes4k.impl.FlatCharSequenceRope
import dev.forkhandles.ropes4k.impl.SubstringRope

class SubstringRopeTest : RopeContract() {
    override fun make(s: String): Rope {
        return SubstringRope(
            FlatCharSequenceRope(s),
            0,
            s.length
        )
    }
}