package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.format.DateTimeFormatter

interface IGDaySampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateGDay(): String {
        /**
         * generates a day of the month in the format ---dd
         * @return a day of the month in the format ---dd
         */
        val formatter = DateTimeFormatter.ofPattern("---dd")
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW).format(formatter)
    }
}
