package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IHexBinarySampler {

    fun generateHexBinary(): ByteArray {
        /**
         * Generates a random HexBinary as a ByteArray
         * @return a random HexBinary
         */
        return ByteArray(Randomization.rand.nextInt(10, 100))
    }

}