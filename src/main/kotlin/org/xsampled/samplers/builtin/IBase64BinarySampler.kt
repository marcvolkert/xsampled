package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.util.*

interface IBase64BinarySampler {

    fun generateBase64Binary(): String {
        /**
         * Generates a random Base64 string
         * @return a random Base64 string
         */
        val bytes = ByteArray(Randomization.rand.nextInt(10, 100))
        Randomization.rand.nextBytes(bytes)
        return Base64.getEncoder().encodeToString(bytes)
    }

}