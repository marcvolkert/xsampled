package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.ZonedDateTime

interface IDateTimeSampler {

    fun generateDateTime(): ZonedDateTime {
        /**
         * Generates a random time as ZonedDateTime
         * @return a random time
         */
        return Randomization.getRandomZdt()
    }
}