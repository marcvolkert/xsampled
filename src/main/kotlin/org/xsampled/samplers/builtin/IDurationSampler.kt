package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.Duration

interface IDurationSampler {
    fun generateDuration(): Duration {
        /**
         * Generates a random Duration
         * @return a random Duration
         */
        val zdts = listOf(Randomization.getRandomZdt(), Randomization.getRandomZdt()).sorted()
        return Duration.between(zdts[0], zdts[1])
    }
}
