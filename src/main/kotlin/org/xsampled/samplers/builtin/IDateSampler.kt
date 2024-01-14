package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.ZonedDateTime

interface IDateSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }
    fun generateDate(): ZonedDateTime {
        /**
         * Generates a random date as ZonedDateTime
         * @return a random date
         */
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW)
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .withNano(0)
    }

}
