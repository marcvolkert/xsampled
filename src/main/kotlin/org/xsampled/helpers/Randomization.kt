package org.xsampled.helpers

import org.apache.commons.lang3.RandomStringUtils
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*
import javax.xml.namespace.QName

object Randomization {

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

    fun getRandomUri(
        overWriteSchemeWith: String? = null,
        disableUserName: Boolean = false,
        disablePassword: Boolean = false,
        disableQuery: Boolean = false,
        disableFragment: Boolean = false,
        lowerBoundNames: Int,
        upperBoundNames: Int,
        lowerBoundPasswords: Int,
        upperBoundPasswords: Int,
        lowerBoundSubdomains: Int,
        upperBoundSubdomains: Int,
        lowerBoundSubdomainNames: Int,
        upperBoundSubdomainNames: Int
    ): String {
        /**
         * Generates a random URI
         * @param overWriteSchemeWith if not null, the scheme will be overwritten with this value
         * @param disableUserName if true, the username will not be generated
         * @param disablePassword if true, the password will not be generated
         * @param lowerBoundNames the lower bound of the length of each name
         * @param upperBoundNames the upper bound of the length of each name
         * @param lowerBoundPasswords the lower bound of the length of each password
         * @param upperBoundPasswords the upper bound of the length of each password
         * @param lowerBoundSubdomains the lower bound of the number of subdomains
         * @param upperBoundSubdomains the upper bound of the number of subdomains
         * @param lowerBoundSubdomainNames the lower bound of the length of each subdomain
         * @param upperBoundSubdomainNames the upper bound of the length of each subdomain
         * @return a random URI
         */
        // reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
        // a URI is composed of a scheme, an optional authority, a path, an optional query, and an optional fragment
        // --- scheme ---
        val scheme =
            overWriteSchemeWith ?: listOf("http", "https", "ftp", "file", "mailto", "data", "irc", "urn").random()

        // --- authority ---
        val authority: String
        if (rand.nextBoolean() && !disableUserName) {
            val username = getRandomName(
                lowerBoundNames,
                upperBoundNames
            )
            val password = if (rand.nextBoolean() && !disablePassword) ":${
                getRandomPassword(
                    lowerBoundPasswords,
                    upperBoundPasswords
                )
            }" else ""
            val userInfo = if (rand.nextBoolean()) "$username$password@" else ""
            val host = getRandomHostname(
                lowerBoundSubdomains,
                upperBoundSubdomains,
                lowerBoundSubdomainNames,
                upperBoundSubdomainNames
            )
            val port = if (rand.nextBoolean()) ":${rand.nextInt(65535)}" else ""
            authority = "//$userInfo$host$port"
        } else authority = ""
        // --- path ---
        val path = "/" + (0..rand.nextInt(5)).joinToString("/") {
            getRandomName(
                lowerBoundNames, upperBoundNames
            )
        }

        // --- query ---
        val query = if (rand.nextBoolean() && !disableQuery) {
            "?" + (0..rand.nextInt(5)).joinToString("&") {
                "${
                    getRandomName(
                        lowerBoundNames,
                        upperBoundNames
                    )
                }=${
                    getRandomName(
                        lowerBoundNames,
                        upperBoundNames
                    )
                }"
            }
        } else ""

        // --- fragment ---
        val fragment =
            if (rand.nextBoolean() && !disableFragment) "#" + getRandomString(3, 10).lowercase() else ""

        // build URI
        return "$scheme:$authority$path$query$fragment"
    }

    fun getRandomQName(
        lowerBoundNames: Int,
        upperBoundNames: Int,
        lowerBoundPasswords: Int,
        upperBoundPasswords: Int,
        lowerBoundSubdomains: Int,
        upperBoundSubdomains: Int,
        lowerBoundSubdomainNames: Int,
        upperBoundSubdomainNames: Int
    ): QName {
        /**
         * Generates a random QName
         * @param lowerBoundNames the lower bound of the length of each name
         * @param upperBoundNames the upper bound of the length of each name
         * @param lowerBoundPasswords the lower bound of the length of each password
         * @param upperBoundPasswords the upper bound of the length of each password
         * @param lowerBoundSubdomains the lower bound of the number of subdomains
         * @param upperBoundSubdomains the upper bound of the number of subdomains
         * @param lowerBoundSubdomainNames the lower bound of the length of each subdomain
         * @param upperBoundSubdomainNames the upper bound of the length of each subdomain
         * @return a random QName
         */
        val scheme = listOf("http", "https").random()
        val url = getRandomUri(
            overWriteSchemeWith = scheme,
            disableUserName = true,
            disablePassword = true,
            disableQuery = true,
            disableFragment = true,
            lowerBoundNames = lowerBoundNames,
            upperBoundNames = upperBoundNames,
            lowerBoundPasswords = lowerBoundPasswords,
            upperBoundPasswords = upperBoundPasswords,
            lowerBoundSubdomains = lowerBoundSubdomains,
            upperBoundSubdomains = upperBoundSubdomains,
            lowerBoundSubdomainNames = lowerBoundSubdomainNames,
            upperBoundSubdomainNames = upperBoundSubdomainNames
        )
        val element = getRandomName(lowerBoundNames, upperBoundNames)
        return QName(url, element)
    }
}