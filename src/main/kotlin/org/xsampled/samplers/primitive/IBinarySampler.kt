package org.xsampled.samplers.primitive

import org.xsampled.helpers.Randomization
import java.util.*

interface IBinarySampler {
    fun generateBase64Binary(): String {
        /**
         * Generates a random Base64Binary as String
         * @return a random Base64Binary
         */
        val bytes = ByteArray(Randomization.rand.nextInt(10, 100))
        Randomization.rand.nextBytes(bytes)
        return Base64.getEncoder().encodeToString(bytes)
    }

    fun generateHexBinary(): String {
        /**
         * Generates a random HexBinary as String
         * @return a random HexBinary
         */
        val bytes = ByteArray(Randomization.rand.nextInt(10, 100))
        Randomization.rand.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }

}