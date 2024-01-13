package org.xsampled.samplers.primitive

import org.xsampled.helpers.Randomization
import java.time.Duration
import java.time.format.DateTimeFormatter

interface IDateTimeSampler {
    fun generateDate(): String {
        /**
         * Generates a random Date as String
         * @return a random Date
         */
        val zdt = Randomization.getRandomZdt()
        return zdt.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

    fun generateTime(): String {
        /**
         * Generates a random Time as String
         * @return a random Time
         */
        val zdt = Randomization.getRandomZdt()
        return zdt.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

    fun generateDateTime(): String {
        /**
         * Generates a random DateTime as String
         * @return a random DateTime
         */
        val zdt = Randomization.getRandomZdt()
        return zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    fun generateDuration(): String {
        /**
         * Generates a random Duration as String
         * @return a random Duration
         */
        val zdts = listOf(Randomization.getRandomZdt(), Randomization.getRandomZdt()).sorted()
        val duration = Duration.between(zdts[0], zdts[1])
        return duration.toString()
    }

    fun generateGDay(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGMonth(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGMonthDay(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGYear(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }

    fun generateGYearMonth(): String {
        /**
         * This method is not implemented yet
         * @throws NotImplementedError
         */
        throw NotImplementedError()
    }
}