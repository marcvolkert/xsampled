package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.ZonedDateTime

interface IDateSampler {
    fun generateDate(): ZonedDateTime {
        /**
         * Generates a random date as ZonedDateTime
         * @return a random date
         */
        return Randomization.getRandomZdt()
    }

}
