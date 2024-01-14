package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IDoubleSampler {

    companion object {
        const val MIN_DOUBLE = Double.MIN_VALUE
        const val MAX_DOUBLE = Double.MAX_VALUE
    }

    fun generateDouble(): Double {
        /**
         * Generates a random Double
         * @return a random Double
         */
        return Randomization.rand.nextDouble(MIN_DOUBLE, MAX_DOUBLE)
    }

}
