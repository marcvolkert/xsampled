package org.xsampled.helpers

import org.apache.commons.lang3.RandomStringUtils
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*

open class Randomization {

    internal companion object {
        val rand: Random = Random()
        fun getRandomZdt(minusYearsFromNow: Long, plusYearsFromNow: Long): ZonedDateTime {
            /**
             * Generates a random ZonedDateTime in the range of [minusYearsFromNow, plusYearsFromNow]
             * @param minusYearsFromNow the number of years in the past to generate a random ZonedDateTime
             * @param plusYearsFromNow the number of years in the future to generate a random ZonedDateTime
             * @return a random ZonedDateTime
             */
            val now = ZonedDateTime.now()
            val thousandYearPast = now.minusYears(minusYearsFromNow).toInstant().toEpochMilli()
            val thousandYearFuture = now.plusYears(plusYearsFromNow).toInstant().toEpochMilli()
            val random = rand.nextLong(thousandYearPast, thousandYearFuture)
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(random), now.zone)
        }

        fun getRandomString(lowerBound: Int, upperBound: Int): String {
            /**
             * Generates a random String of alphanumeric characters
             * with a random length in the range of [lowerBound, upperBound]
             * @param lowerBound the lower bound of the random length
             * @param upperBound the upper bound of the random length
             * @return a random String
             */
            return RandomStringUtils.randomAlphanumeric(rand.nextInt(lowerBound, upperBound))
        }

        fun getRandomName(lowerBound: Int, upperBound: Int): String {
            /**
             * Generates a random pseudo name with alternating vowels and consonants
             * with a random length in the range of [lowerBound, upperBound]
             * @param lowerBound the lower bound of the random length
             * @param upperBound the upper bound of the random length
             * @return a random name
             */
            val vowels = listOf('a', 'e', 'i', 'o', 'u')
            val consonants = ('a'..'z').toList() - vowels
            val length = rand.nextInt(lowerBound, upperBound)
            return (0..length).map {
                if (it % 2 == 0) vowels.random() else consonants.random()
            }.joinToString("")
        }

        fun getRandomHostname(
            lowerBoundSubdomains: Int,
            upperBoundSubdomains: Int,
            lowerBoundSubdomainNames: Int,
            upperBoundSubdomainNames: Int
        ): String {
            /**
             * Generates a random hostname with random subdomains and top-level domains.
             * The length of the domain part is in the range of [lowerBoundSubdomains, upperBoundSubdomains].
             * The length of each subdomain is in the range of [lowerBoundSubdomainNames, upperBoundSubdomainNames].
             * Top-level domains are randomly selected from a list of common top-level domains and may not be present.
             * @param lowerBoundSubdomains the lower bound of the number of subdomains
             * @param upperBoundSubdomains the upper bound of the number of subdomains
             * @param lowerBoundSubdomainNames the lower bound of the length of each subdomain
             * @param upperBoundSubdomainNames the upper bound of the length of each subdomain
             * @return a random hostname
             */
            val subdomains = (0..rand.nextInt(lowerBoundSubdomains, upperBoundSubdomains))
                .map { getRandomName(lowerBoundSubdomainNames, upperBoundSubdomainNames) }
            val tlds = listOf("com", "net", "org", "gov", "edu", "io", "co", "uk", "ca", "de", "jp", "fr", "au", "us")
            return subdomains.joinToString(".") + if (rand.nextBoolean()) ".${tlds.random()}" else ""
        }

        fun getRandomPassword(lowerBound: Int, upperBound: Int): String {
            /**
             * Generates a random password with random alphanumeric characters and special characters
             * with a random length in the range of [lowerBound, upperBound]
             * @param lowerBound the lower bound of the random length
             * @param upperBound the upper bound of the random length
             * @return a random password
             */
            val letters = ('a'..'z').toList()
            val numbers = ('0'..'9').toList()
            val special = listOf('+', '.', '-')
            val all = letters + numbers + special
            return (0..rand.nextInt(lowerBound, upperBound))
                .map { all.random() }
                .joinToString("")
        }
    }
}