package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.time.format.DateTimeFormatter

interface IGYearMonthSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateGYearMonth(): String {
        /**
         * generates a year and month in the format yyyy-mm
         * @return a year and month in the format yyyy-mm
         */
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM")
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW).format(formatter)
    }
}
