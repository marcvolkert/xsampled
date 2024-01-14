package org.xsampled.samplers.builtin

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.time.ZonedDateTime
import java.util.*
import kotlin.test.assertTrue

class SamplerInterfacesTest {

    @Test
    @DisplayName("IBase64BinarySampler generates valid Base64")
    fun iBase64BinarySamplerTest() {
        val sampler = object: IBase64BinarySampler {}
        val actual = sampler.generateBase64Binary()
        println("actual: $actual")
        assertDoesNotThrow { Base64.getDecoder().decode(actual) }
    }

    @Test
    @DisplayName("IDateSampler generates date with zero time")
    fun iDateSamplerTest() {
        val sampler = object: IDateSampler {}
        val actual = sampler.generateDate()
        println("actual: $actual")
        assertTrue(actual.hour == 0)
        assertTrue(actual.minute == 0)
        assertTrue(actual.second == 0)
        assertTrue(actual.nano == 0)
    }

    @Test
    @DisplayName("ITimeSampler generates time with zero date")
    fun iTimeSamplerTest() {
        val sampler = object : ITimeSampler {}
        val actual = sampler.generateTime()
        println("actual: $actual")
        assertTrue(actual.year == 1970)
        assertTrue(actual.monthValue == 1)
        assertTrue(actual.dayOfMonth == 1)
    }

}