package org.xsampled.test.blueprints

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.platform.commons.annotation.Testable
import org.xsampled.samplers.builtin.AbstractPrimitiveSampler
import java.net.URI

@Testable
@DisplayName("Generated primitive values match their respective lexical spaces")
abstract class SamplerPrimitiveLexicalTest {

    abstract val sampler: AbstractPrimitiveSampler

    @RepeatedTest(100)
    @DisplayName("anyURI")
    fun testGenerateURI() {
        val uri = sampler.generateAnyURI()
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

    @RepeatedTest(100)
    @DisplayName("float")
    fun testGenerateFloat() {
        val float = sampler.generateFloat()
        println("actual: $float")
        assertTrue(float.matches(Regex("(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([Ee](\\+|-)?[0-9]+)?|(\\+|-)?INF|NaN")))
    }

    @RepeatedTest(100)
    @DisplayName("gDay")
    fun testGenerateGDay() {
        val gDay = sampler.generateGDay()
        println("actual: $gDay")
        assertTrue(gDay.matches(Regex("---(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("gMonth")
    fun testGenerateGMonth() {
        val gMonth = sampler.generateGMonth()
        println("actual: $gMonth")
        assertTrue(gMonth.matches(Regex("--(0[1-9]|1[0-2])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("gMonthDay")
    fun testGenerateGMonthDay() {
        val gMonthDay = sampler.generateGMonthDay()
        println("actual: $gMonthDay")
        assertTrue(gMonthDay.matches(Regex("--(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("gYear")
    fun testGenerateGYear() {
        val gYear = sampler.generateGYear()
        println("actual: $gYear")
        assertTrue(gYear.matches(Regex("-?([1-9][0-9]{3,}|0[0-9]{3})(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("gYearMonth")
    fun testGenerateGYearMonth() {
        val gYearMonth = sampler.generateGYearMonth()
        println("actual: $gYearMonth")
        assertTrue(gYearMonth.matches(Regex("-?([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

    @RepeatedTest(100)
    @DisplayName("hexBinary")
    fun testGenerateHexBinary() {
        val hexBinary = sampler.generateHexBinary()
        println("actual: $hexBinary")
        assertTrue(hexBinary.matches(Regex("([0-9a-fA-F]{2})*")))
    }

    @Disabled
    @RepeatedTest(100)
    @DisplayName("NOTATION")
    fun testGenerateNOTATION() {
        // NOTATION doesn't provide a lexical space
        assertTrue(false)
    }

    @Disabled
    @RepeatedTest(100)
    @DisplayName("QName")
    fun testGenerateQName() {
        // QName doesn't provide a lexical space
        assertTrue(false)
    }

    @RepeatedTest(100)
    @DisplayName("string")
    fun testGenerateString() {
        val string = sampler.generateString()
        println("actual: $string")
        assertTrue(string.matches(Regex(".*")))
    }

    @RepeatedTest(100)
    @DisplayName("time")
    fun testGenerateTime() {
        val time = sampler.generateTime()
        println("actual: $time")
        assertTrue(time.matches(Regex("(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?|(24:00:00(\\.0+)?))(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?")))
    }

}