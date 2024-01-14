package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.ZonedDateTime

interface IDateTimeSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateDateTime(): ZonedDateTime {
        /**
         * Generates a random time as ZonedDateTime
         * @return a random time
         */
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW)
    }
}