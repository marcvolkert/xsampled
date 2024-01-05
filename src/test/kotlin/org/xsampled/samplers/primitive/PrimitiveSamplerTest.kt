package org.xsampled.samplers.primitive

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import java.net.URI

abstract class PrimitiveSamplerTest {

    abstract val sampler: PrimitiveSampler

    @RepeatedTest(100)
    @DisplayName("anyURI")
    fun testGenerateURI() {
        val uri = sampler.generateURI()
        println("actual: $uri")
        assertDoesNotThrow { URI(uri) }
        assertTrue(URI(uri).isAbsolute)
    }

    @RepeatedTest(100)
    @DisplayName("base64Binary")
    fun testGenerateBase64Binary() {
        val base64Binary = sampler.generateBase64Binary()
        println("actual: $base64Binary")
        assertTrue(base64Binary.matches(Regex("((([A-Za-z0-9+/] ?){4})*(([A-Za-z0-9+/] ?){3}[A-Za-z0-9+/]|([A-Za-z0-9+/] ?){2}[AEIMQUYcgkosw048] ?=|[A-Za-z0-9+/] ?[AQgw] ?= ?=))?")))
    }

    @RepeatedTest(100)
    @DisplayName("boolean")
    fun testGenerateBoolean() {
        val boolean = sampler.generateBoolean()
        println("actual: $boolean")
        assertTrue(boolean.matches(Regex("true|false|1|0")))
    }

    @RepeatedTest(100)
    @DisplayName("date")
    fun testGenerateDate() {
        val date = sampler.generateDate()
        println("actual: $date")
        assertTrue(date.matches(Regex("-?([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("dateTime")
    fun testGenerateDateTime() {
        val dateTime = sampler.generateDateTime()
        println("actual: $dateTime")
        assertTrue(dateTime.matches(Regex("-?([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?|(24:00:00(\\.0+)?))(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("decimal")
    fun testGenerateDecimal() {
        val decimal = sampler.generateDecimal()
        println("actual: $decimal")
        assertTrue(decimal.matches(Regex("(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)")))
    }

    @RepeatedTest(100)
    @DisplayName("double")
    fun testGenerateDouble() {
        val double = sampler.generateDouble()
        println("actual: $double")
        assertTrue(double.matches(Regex("(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([Ee](\\+|-)?[0-9]+)?|(\\+|-)?INF|NaN")))
    }

    @RepeatedTest(100)
    @DisplayName("duration")
    fun testGenerateDuration() {
        val duration = sampler.generateDuration()
        println("actual: $duration")
        assertTrue(duration.matches(Regex("-?P((([0-9]+Y([0-9]+M)?([0-9]+D)?|([0-9]+M)([0-9]+D)?|([0-9]+D))(T(([0-9]+H)([0-9]+M)?([0-9]+(\\.[0-9]+)?S)?|([0-9]+M)([0-9]+(\\.[0-9]+)?S)?|([0-9]+(\\.[0-9]+)?S)))?)|(T(([0-9]+H)([0-9]+M)?([0-9]+(\\.[0-9]+)?S)?|([0-9]+M)([0-9]+(\\.[0-9]+)?S)?|([0-9]+(\\.[0-9]+)?S))))")))
    }


}