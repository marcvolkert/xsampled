package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.util.*

interface IBase64BinarySampler {

    companion object {
        const val MIN_LENGTH = 4
        const val MAX_LENGTH = 50
    }

    fun generateBase64Binary(): String {
        /**
         * Generates a random Base64 string
         * @return a random Base64 string
         */
        val bytes = ByteArray(Randomization.rand.nextInt(MIN_LENGTH, MAX_LENGTH))
        Randomization.rand.nextBytes(bytes)
        return Base64.getEncoder().encodeToString(bytes)
    }

}