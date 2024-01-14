package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.math.BigDecimal

interface IDecimalSampler {

    companion object {
        const val MIN_DECIMAL = Double.MIN_VALUE
        const val MAX_DECIMAL = Double.MAX_VALUE
    }

    fun generateDecimal(): BigDecimal {
        /**
         * Generates a random decimal as a BigDecimal
         * @return a random decimal
         */
        return BigDecimal(Randomization.rand.nextDouble(MIN_DECIMAL, MAX_DECIMAL))
    }

    // TODO: implement derived built-in type samplers

}
