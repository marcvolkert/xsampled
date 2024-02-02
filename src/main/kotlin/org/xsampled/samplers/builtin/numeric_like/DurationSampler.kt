package org.xsampled.samplers.builtin.numeric_like

import org.xsampled.helpers.Randomization
import java.time.Duration

abstract class DurationSampler: AbstractNumericLikeSampler<Duration>() {
    companion object {
        const val MIN_DURATION_SECONDS = -31536000L
        const val MAX_DURATION_SECONDS = 31536000L
    }

    override fun value(min: Duration?, minInclusive: Boolean, max: Duration?, maxInclusive: Boolean): Duration {
        val lowerLimit = min ?: Duration.ofSeconds(MIN_DURATION_SECONDS)
        val upperLimit = max ?: Duration.ofSeconds(MAX_DURATION_SECONDS)
        val original = if (minInclusive) lowerLimit else lowerLimit.plusSeconds(1)
        val bound = if (maxInclusive) upperLimit.plusSeconds(1) else upperLimit
        val durationSeconds = Randomization.rand.nextLong(original.seconds, bound.seconds)
        return Duration.ofSeconds(durationSeconds)
    }

}
