package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.Duration

interface IDurationSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateDuration(): Duration {
        /**
         * Generates a random Duration
         * @return a random Duration
         */
        // difference should be positive, therefore sort the list
        val randomZonedDateTimes = listOf(
            Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW),
            Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW)
        ).sorted()
        return Duration.between(randomZonedDateTimes[0], randomZonedDateTimes[1])
    }

    // TODO: implement derived built-in type samplers
}
