package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.net.URI

interface IAnyURISampler {

    companion object {
        const val LOWER_BOUND_NAMES = 5
        const val UPPER_BOUND_NAMES = 20
        const val LOWER_BOUND_PASSWORDS = 10
        const val UPPER_BOUND_PASSWORDS = 20
        const val LOWER_BOUND_SUBDOMAINS = 1
        const val UPPER_BOUND_SUBDOMAINS = 3
        const val LOWER_BOUND_SUBDOMAIN_NAMES = 3
        const val UPPER_BOUND_SUBDOMAIN_NAMES = 12
    }

    fun generateAnyURI(): URI {
        /**
         * Generates a random absolute URI as URI
         * Reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
         * A URI is composed of a scheme, an optional authority, a path, an optional query,
         * and an optional fragment
         * @return a random URI
         */
        // reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
        // a URI is composed of a scheme, an optional authority, a path, an optional query, and an optional fragment
        // --- scheme ---
        val scheme = listOf("http", "https", "ftp", "file", "mailto", "data", "irc", "urn").random()
        // --- authority ---
        val authority: String
        if (Randomization.rand.nextBoolean()) {
            val username = Randomization.getRandomName(LOWER_BOUND_NAMES, UPPER_BOUND_NAMES)
            val password = if (Randomization.rand.nextBoolean()) ":${Randomization.getRandomPassword(
                LOWER_BOUND_PASSWORDS,
                UPPER_BOUND_PASSWORDS
            )}" else ""
            val userInfo = if (Randomization.rand.nextBoolean()) "$username$password@" else ""
            val host = Randomization.getRandomHostname(
                LOWER_BOUND_SUBDOMAINS,
                UPPER_BOUND_SUBDOMAINS,
                LOWER_BOUND_SUBDOMAIN_NAMES,
                UPPER_BOUND_SUBDOMAIN_NAMES
            )
            val port = if (Randomization.rand.nextBoolean()) ":${Randomization.rand.nextInt(65535)}" else ""
            authority = "//$userInfo$host$port"
        } else authority = ""
        // --- path ---
        val path = "/" + (0..Randomization.rand.nextInt(5)).joinToString("/") { Randomization.getRandomName(
            LOWER_BOUND_NAMES, UPPER_BOUND_NAMES) }
        // --- query ---
        val query = if (Randomization.rand.nextBoolean()) {
            "?" + (0..Randomization.rand.nextInt(5)).joinToString("&") {
                "${Randomization.getRandomName(LOWER_BOUND_NAMES, UPPER_BOUND_NAMES)}=${Randomization.getRandomName(LOWER_BOUND_NAMES, UPPER_BOUND_NAMES)}"
            }
        } else ""
        // --- fragment ---
        val fragment =
            if (Randomization.rand.nextBoolean()) "#" + Randomization.getRandomString(3, 10).lowercase() else ""
        // build URI
        return URI("$scheme:$authority$path$query$fragment")
    }
}