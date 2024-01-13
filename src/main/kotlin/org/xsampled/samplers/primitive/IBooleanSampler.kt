package org.xsampled.samplers.primitive

import org.xsampled.helpers.Randomization

interface IBooleanSampler {
    fun generateBoolean(): String {
        /**
         * Generates a random Boolean as String
         * @return a random Boolean
         */
        val bool = Randomization.rand.nextBoolean()
        return bool.toString()
    }
}