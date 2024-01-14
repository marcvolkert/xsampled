package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IHexBinarySampler {

    companion object {
        const val MIN_LENGTH = 4
        const val MAX_LENGTH = 50
    }

    fun generateHexBinary(): ByteArray {
        /**
         * Generates a random HexBinary as a ByteArray
         * @return a random HexBinary
         */
        val bytes = ByteArray(Randomization.rand.nextInt(MIN_LENGTH, MAX_LENGTH))
        Randomization.rand.nextBytes(bytes)
        return bytes
    }

}