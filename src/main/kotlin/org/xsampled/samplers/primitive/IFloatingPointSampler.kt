package org.xsampled.samplers.primitive

import kotlin.math.pow

interface IFloatingPointSampler {

    companion object {
        val rand = java.util.Random()
    }

    fun generateDecimal(): String {
        /**
         * Generates a random Decimal as String
         * @return a random Decimal
         */
        return generateDouble()
    }

    fun generateFloat(): String {
        /**
         * Generates a random Float as String
         * @return a random Float
         */
        return rand.nextFloat().toString()
    }

    fun generateDouble(): String {
        /**
         * Generates a random Double as String
         * @return a random Double
         */
        return rand.nextDouble(10.0.pow(6)).toString()
    }

}