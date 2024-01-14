package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IFloatSampler {

    private companion object {

        const val MIN_FLOAT = Float.MIN_VALUE
        const val MAX_FLOAT = Float.MAX_VALUE

    }

    fun generateFloat(): Float {
        /**
         * Generates a random Float
         * @return a random Float
         */
        return Randomization.rand.nextFloat(MIN_FLOAT, MAX_FLOAT)
    }

}