package org.xsampled.samplers.builtin.numeric_like

import org.xsampled.helpers.Randomization
import kotlin.math.nextUp

abstract class FloatSampler: AbstractNumericLikeSampler<Float>() {

    companion object {
        const val MIN_FLOAT = -3.00000005E12f
        const val MAX_FLOAT = 3.00000005E12f
    }

    override fun value(min: Float?, minInclusive: Boolean, max: Float?, maxInclusive: Boolean): Float {
        val lowerLimit = min ?: MIN_FLOAT
        val upperLimit = max ?: MAX_FLOAT
        val original = if (minInclusive) lowerLimit else lowerLimit.nextUp()
        val bound = if (maxInclusive) upperLimit.nextUp() else upperLimit
        return Randomization.rand.nextFloat(original, bound)
    }

}