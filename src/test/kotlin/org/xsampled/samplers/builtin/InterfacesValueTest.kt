package org.xsampled.samplers.builtin

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.platform.commons.annotation.Testable
import java.util.*
import kotlin.test.assertTrue

@Testable
@DisplayName("Critical interfaces deliver valid values for their respective value spaces")
internal class InterfacesValueTest {

    @Test
    @DisplayName("IBase64BinarySampler generates valid Base64")
    fun iBase64BinarySamplerTest() {
        val sampler = object : IBase64BinarySampler {}
        val actual = sampler.generateBase64Binary()
        println("actual: $actual")
        assertDoesNotThrow { Base64.getDecoder().decode(actual) }
    }

    @Test
    @DisplayName("IDateSampler generates date with zero time")
    fun iDateSamplerTest() {
        val sampler = object : IDateSampler {}
        val actual = sampler.generateDate()
        println("actual: $actual")
        assertTrue(actual.hour == 0)
        assertTrue(actual.minute == 0)
        assertTrue(actual.second == 0)
        assertTrue(actual.nano == 0)
    }

    @Test
    @DisplayName("IGDaySampler generates a day of the month in the format ---dd")
    fun iGDaySamplerTest() {
        val sampler = object : IGDaySampler {}
        val actual = sampler.generateGDay()
        println("actual: $actual")
        assertTrue(actual.matches(Regex("---\\d\\d")))
        assertTrue { actual.substring(3).toInt() in 1..31 }
    }

    @Test
    @DisplayName("IGMonthDaySampler generates a month and day in the format --mm-dd")
    fun iGMonthDaySamplerTest() {
        val sampler = object : IGMonthDaySampler {}
        val actual = sampler.generateGMonthDay()
        println("actual: $actual")
        assertTrue(actual.matches(Regex("--\\d\\d-\\d\\d")))
        assertTrue { actual.substring(2, 4).toInt() in 1..12 }
        assertTrue { actual.substring(5).toInt() in 1..31 }
    }

    @Test
    @DisplayName("IGMonthSampler generates a month in the format --mm")
    fun iGMonthSamplerTest() {
        val sampler = object : IGMonthSampler {}
        val actual = sampler.generateGMonth()
        println("actual: $actual")
        assertTrue(actual.matches(Regex("--\\d\\d")))
        assertTrue { actual.substring(2).toInt() in 1..12 }
    }

    @Test
    @DisplayName("IGYearMonthSampler generates a year and month in the format yyyy-mm")
    fun iGYearMonthSamplerTest() {
        val sampler = object : IGYearMonthSampler {}
        val actual = sampler.generateGYearMonth()
        println("actual: $actual")
        assertTrue(actual.matches(Regex("\\d\\d\\d\\d-\\d\\d")))
        assertTrue { actual.substring(0, 4).toInt() in 1..9999 }
        assertTrue { actual.substring(5).toInt() in 1..12 }
    }

    @Test
    @DisplayName("IGYearSampler generates a year in the format yyyy")
    fun iGYearSamplerTest() {
        val sampler = object : IGYearSampler {}
        val actual = sampler.generateGYear()
        println("actual: $actual")
        assertTrue(actual.matches(Regex("\\d\\d\\d\\d")))
        assertTrue { actual.toInt() in 1..9999 }
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