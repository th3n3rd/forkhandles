/*
 * Copyright (C) 2024 James Richardson
 *  - Originally Copyright (C) 2007 Amin Ahmad.
 * Licenced under GPL
 */

package dev.forkhandles.ropes4k.impl

import dev.forkhandles.ropes4k.Rope

internal interface InternalRope : Rope {
    val depth: Int
    fun rebalance(): Rope
    override fun reverse(): InternalRope
    override fun subSequence(startIndex: Int, endIndex: Int): InternalRope
}