package org.xsampled.helpers

import org.apache.commons.lang3.RandomStringUtils
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*

open class Randomization {

    internal companion object {
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

        fun getRandomString(origin: Int, bound: Int): String {
            /**
             * Generates a random String with random alphanumeric characters
             * @return a random String
             */
            return RandomStringUtils.randomAlphanumeric(rand.nextInt(origin, bound))
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
}