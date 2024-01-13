package org.xsampled.samplers.primitive

import org.xsampled.helpers.Randomization

interface ITextSampler {
    fun generateURI(): String {
        /**
         * Generates a Randomization.random absolute URI as String
         * Reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
         * A URI is composed of a scheme, an optional authority, a path, an optional query,
         * and an optional fragment
         * @return a Randomization.random URI
         */
        // reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
        // a URI is composed of a scheme, an optional authority, a path, an optional query, and an optional fragment
        // --- scheme ---
        val scheme = listOf("http", "https", "ftp", "file", "mailto", "data", "irc", "urn").random()
        // --- authority ---
        val authority: String
        if (Randomization.rand.nextBoolean()) {
            val username = Randomization.getRandomName()
            val password = if (Randomization.rand.nextBoolean()) ":${Randomization.getRandomPassword()}" else ""
            val userInfo = if (Randomization.rand.nextBoolean()) "$username$password@" else ""
            val host = Randomization.getRandomHostname()
            val port = if (Randomization.rand.nextBoolean()) ":${Randomization.rand.nextInt(65535)}" else ""
            authority = "//$userInfo$host$port"
        } else authority = ""
        // --- path ---
        val path = "/" + (0..Randomization.rand.nextInt(5)).joinToString("/") { Randomization.getRandomName() }
        // --- query ---
        val query = if (Randomization.rand.nextBoolean()) {
            "?" + (0..Randomization.rand.nextInt(5)).joinToString("&") {
                "${Randomization.getRandomName()}=${Randomization.getRandomName()}"
            }
        } else ""
        // --- fragment ---
        val fragment =
            if (Randomization.rand.nextBoolean()) "#" + Randomization.getRandomString(3, 10).lowercase() else ""
        // build URI
        return "$scheme:$authority$path$query$fragment"
    }

    fun generateString(): String {
        /**
         * Generates a Randomization.random String
         * @return a Randomization.random String
         */
        return Randomization.getRandomString(10, 100)
    }

    // TODO: implement
    fun generateNOTATION(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    // TODO: implement
    fun generateQName(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }
}