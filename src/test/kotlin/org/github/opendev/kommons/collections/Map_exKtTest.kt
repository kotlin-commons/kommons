package org.github.opendev.kommons.collections

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class Map_exKtTest {

    @Test
    fun getIntOrDefault() {
        val m = mapOf("a" to "1")
        assertEquals(m.getIntOrDefault("a"), 1)
        assertEquals(m.getIntOrDefault("b"), 0)
        assertEquals(m.getIntOrDefault("c", 100), 100)
    }

    @Test
    fun getInt() {
    }

    @Test
    fun getStringOrDefault() {
    }

    @Test
    fun getString() {
    }
}