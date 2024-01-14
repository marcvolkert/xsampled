package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface IGYearSampler {
    companion object {
        const val MINUS_YEARS_FROM_NOW = 30L
        const val PLUS_YEARS_FROM_NOW = 30L
    }

    fun generateGYear(): String {
        /**
         * generates a year in the format yyyy
         * @return a year in the format yyyy
         */
        return Randomization.getRandomZdt(MINUS_YEARS_FROM_NOW, PLUS_YEARS_FROM_NOW).year.toString()
    }
}
