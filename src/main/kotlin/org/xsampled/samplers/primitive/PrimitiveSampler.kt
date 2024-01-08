package org.xsampled.samplers.primitive

import org.apache.commons.lang3.RandomStringUtils
import java.time.Duration
import java.time.Instant
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.pow

abstract class PrimitiveSampler() {

    protected companion object Helpers {

        val rand: Random = Random()

        fun getRandomZdt(): ZonedDateTime {
            /**
             * Generates a random ZonedDateTime between 30 years ago and 90 years in the future
             * @return a random ZonedDateTime
             */
            val now = ZonedDateTime.now()
            val thousandYearPast = now.minusYears(30).toInstant().toEpochMilli()
            val thousandYearFuture = now.plusYears(90).toInstant().toEpochMilli()
            val random = rand.nextLong(thousandYearPast, thousandYearFuture)
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(random), now.zone)
        }

        fun getRandomName(): String {
            /**
             * Generates a random name with alternating vowels and consonants
             * @return a random name
             */
            val vowels = listOf('a', 'e', 'i', 'o', 'u')
            val consonants = ('a'..'z').toList() - vowels
            val length = rand.nextInt(3, 10)
            return (0..length).map {
                if (it % 2 == 0) vowels.random() else consonants.random()
            }.joinToString("")
        }

        fun getRandomHostname(): String {
            /**
             * Generates a random hostname with random subdomains and top-level domains
             * @return a random hostname
             */
            val subdomains = (0..rand.nextInt(1, 3)).map { getRandomName() }
            val tlds = listOf("com", "net", "org", "gov", "edu", "io", "co", "uk", "ca", "de", "jp", "fr", "au", "us")
            return subdomains.joinToString(".") + if (rand.nextBoolean()) ".${tlds.random()}" else ""
        }

        fun getRandomPassword(): String {
            /**
             * Generates a random password with random alphanumeric characters and special characters
             * @return a random password
             */
            val letters = ('a'..'z').toList()
            val numbers = ('0'..'9').toList()
            val special = listOf('+', '.', '-')
            val all = letters + numbers + special
            return (0..rand.nextInt(5, 10))
                .map { all.random() }
                .joinToString("")
        }

    }

    fun generateURI(): String {
        /**
         * Generates a random absolute URI as String
         * Reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
         * A URI is composed of a scheme, an optional authority, a path, an optional query,
         * and an optional fragment
         * @return a random URI
         */
        // reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
        // a URI is composed of a scheme, an optional authority, a path, an optional query, and an optional fragment
        // --- scheme ---
        val scheme = listOf("http", "https", "ftp", "file", "mailto", "data", "irc", "urn")
            .random()
        // --- authority ---
        val authority: String
        if (rand.nextBoolean()) {
            val username = getRandomName()
            val password = if (rand.nextBoolean()) ":${getRandomPassword()}" else ""
            val userInfo = if (rand.nextBoolean()) "$username$password@" else ""
            val host = getRandomHostname()
            val port = if (rand.nextBoolean()) ":${rand.nextInt(65535)}" else ""
            authority = "//$userInfo$host$port"
        } else authority = ""
        // --- path ---
        val path = "/" + (0..rand.nextInt(5)).joinToString("/") { getRandomName() }
        // --- query ---
        val query = if (rand.nextBoolean()) {
            "?" + (0..rand.nextInt(5)).joinToString("&") {
                "${getRandomName()}=${getRandomName()}"
            }
        } else ""
        // --- fragment ---
        val fragment =
            if (rand.nextBoolean()) "#" + RandomStringUtils.randomAlphanumeric(rand.nextInt(3, 10)).lowercase() else ""
        // build URI
        return "$scheme:$authority$path$query$fragment"
    }

    fun generateBase64Binary(): String {
        /**
         * Generates a random Base64Binary as String
         * @return a random Base64Binary
         */
        val bytes = ByteArray(rand.nextInt(10, 100))
        rand.nextBytes(bytes)
        return Base64.getEncoder().encodeToString(bytes)
    }

    fun generateBoolean(): String {
        /**
         * Generates a random Boolean as String
         * @return a random Boolean
         */
        val bool = rand.nextBoolean()
        return bool.toString()
    }

    fun generateDate(): String {
        /**
         * Generates a random Date as String
         * @return a random Date
         */
        val zdt = getRandomZdt()
        return zdt.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

    fun generateDateTime(): String {
        /**
         * Generates a random DateTime as String
         * @return a random DateTime
         */
        val zdt = getRandomZdt()
        return zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    fun generateDecimal(): String {
        /**
         * Generates a random Decimal as String
         * @return a random Decimal
         */
        return generateDouble()
    }

    fun generateDouble(): String {
        /**
         * Generates a random Double as String
         * @return a random Double
         */
        return rand.nextDouble(10.0.pow(6)).toString()
    }

    fun generateDuration(): String {
        /**
         * Generates a random Duration as String
         * @return a random Duration
         */
        val zdts = listOf(getRandomZdt(), getRandomZdt()).sorted()
        val duration = Duration.between(zdts[0], zdts[1])
        return duration.toString()
    }

    fun generateFloat(): String {
        /**
         * Generates a random Float as String
         * @return a random Float
         */
        return rand.nextFloat().toString()
    }

    fun generateGDay(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGMonth(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGMonthDay(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGYear(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGYearMonth(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateHexBinary(): String {
        /**
         * Generates a random HexBinary as String
         * @return a random HexBinary
         */
        val bytes = ByteArray(rand.nextInt(10, 100))
        rand.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun generateNOTATION(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateQName(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateString(): String {
        /**
         * Generates a random String
         * @return a random String
         */
        return RandomStringUtils.randomAlphanumeric(rand.nextInt(10, 100))
    }

    fun generateTime(): String {
        /**
         * Generates a random Time as String
         * @return a random Time
         */
        val zdt = getRandomZdt()
        return zdt.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

}