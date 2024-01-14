package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.format.DateTimeFormatter

interface IGMonthDaySampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateGMonthDay(): String {
        /**
         * generates a month and day in the format --mm-dd
         * @return a month and day in the format --mm-dd
         */
        val formatter = DateTimeFormatter.ofPattern("--MM-dd")
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW).format(formatter)
    }

}
