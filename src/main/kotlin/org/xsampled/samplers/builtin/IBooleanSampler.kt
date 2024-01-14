package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IBooleanSampler {
    fun generateBoolean(): Boolean {
        /**
         * Generates a random Boolean
         * @return a random Boolean
         */
        val bool = Randomization.rand.nextBoolean()
        return bool
    }
}