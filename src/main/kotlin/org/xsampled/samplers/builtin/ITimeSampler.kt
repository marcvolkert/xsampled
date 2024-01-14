package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.ZonedDateTime

interface ITimeSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }
    fun generateTime(): ZonedDateTime {
        /**
         * Generates a random DateTime as ZonedDateTime
         * @return a random DateTime
         */
        return Randomization.getRandomZdt(
            MINUS_YEARS_FROM_NOW,
            PLUS_YEARS_FROM_NOW
        ).withYear(1970).withMonth(1).withDayOfMonth(1)
    }
}