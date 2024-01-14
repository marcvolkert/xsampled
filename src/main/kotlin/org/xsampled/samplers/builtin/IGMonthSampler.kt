package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.format.DateTimeFormatter

interface IGMonthSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateGMonth(): String {
        /**
         * generates a month in the format --mm
         * @return a month in the format --mm
         */
        val formatter = DateTimeFormatter.ofPattern("--MM")
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW).format(formatter)
    }

}
