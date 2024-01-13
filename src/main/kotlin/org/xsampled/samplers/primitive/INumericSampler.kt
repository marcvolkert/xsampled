package org.xsampled.samplers.primitive

import java.math.BigDecimal
import kotlin.math.pow

interface INumericSampler {

    private companion object {

        const val MIN_FLOAT = Float.MIN_VALUE
        const val MAX_FLOAT = Float.MAX_VALUE
        const val MIN_DOUBLE = Double.MIN_VALUE
        const val MAX_DOUBLE = Double.MAX_VALUE

        private val rand = java.util.Random()

    }

    fun generateFloat(): Float {
        /**
         * Generates a random Float as String
         * @return a random Float
         */
        return rand.nextFloat(MIN_FLOAT, MAX_FLOAT)
    }

    fun generateDouble(): Double {
        /**
         * Generates a random Double as String
         * @return a random Double
         */
        return rand.nextDouble(MIN_DOUBLE, MAX_DOUBLE)
    }

    fun generateDecimal(): BigDecimal {
        /**
         * Generates a random Decimal as String
         * @return a random Decimal
         */
        return BigDecimal(generateDouble())
    }

}