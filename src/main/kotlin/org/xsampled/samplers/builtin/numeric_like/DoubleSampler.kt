package org.xsampled.samplers.builtin.numeric_like

import org.xsampled.helpers.Randomization
import kotlin.math.nextUp

abstract class DoubleSampler: AbstractNumericLikeSampler<Double>() {

    companion object {
        const val MIN_DOUBLE = -36.00000005E12
        const val MAX_DOUBLE = 36.00000005E12
    }

    override fun value(min: Double?, minInclusive: Boolean, max: Double?, maxInclusive: Boolean): Double {
        val lowerLimit = min ?: MIN_DOUBLE
        val upperLimit = max ?: MAX_DOUBLE
        val original = if (minInclusive) lowerLimit else lowerLimit.nextUp()
        val bound = if (maxInclusive) upperLimit.nextUp() else upperLimit
        return Randomization.rand.nextDouble(original, bound)
    }

}