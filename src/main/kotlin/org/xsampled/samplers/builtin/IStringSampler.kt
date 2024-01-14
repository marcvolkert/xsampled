package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IStringSampler {
    companion object {
        const val MIN_LENGTH = 10
        const val MAX_LENGTH = 100
    }

    fun generateString(): String {
        /**
         * Generates a random String
         * @return a random String
         */
        return Randomization.getRandomString(MIN_LENGTH, MAX_LENGTH)
    }

    // TODO: implement derived built-in type samplers
}