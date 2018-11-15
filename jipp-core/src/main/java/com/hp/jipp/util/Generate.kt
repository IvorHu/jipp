// Copyright 2017 HP Development Company, L.P.
// SPDX-License-Identifier: MIT

package com.hp.jipp.util

/** Return a sequence representing all values returned by a block until it returns `null` */
fun <T> (() -> T?).repeatUntilNull(): Sequence<T> {
    val block = this
    return object : Sequence<T> {
        override fun iterator() = block.iterateUntilNull()
    }
}

/** Return an iterator that returns values generated by the block until it returns `null` */
fun <T> (() -> T?).iterateUntilNull(): Iterator<T> {
    val block = this
    return object : Iterator<T> {
        var current = block()

        override fun next(): T {
            val last = current ?: throw IllegalArgumentException("next() called on empty iterator")
            current = block()
            return last
        }

        override fun hasNext() = current != null
    }
}