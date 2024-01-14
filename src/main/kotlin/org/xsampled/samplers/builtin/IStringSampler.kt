package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IStringSampler {

    fun generateString(): String {
        /**
         * Generates a random String
         * @return a random String
         */
        return Randomization.getRandomString(10, 100)
    }

}