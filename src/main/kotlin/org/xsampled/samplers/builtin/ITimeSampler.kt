package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.ZonedDateTime

interface ITimeSampler {
    fun generateTime(): ZonedDateTime {
        /**
         * Generates a random DateTime as ZonedDateTime
         * @return a random DateTime
         */
        return Randomization.getRandomZdt()
    }
}