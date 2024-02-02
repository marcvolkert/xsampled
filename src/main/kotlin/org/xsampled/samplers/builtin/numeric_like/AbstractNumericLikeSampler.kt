package org.xsampled.samplers.builtin.numeric_like

import org.xsampled.samplers.builtin.facet_type.INumericLikeFacetType

abstract class AbstractNumericLikeSampler<T>: INumericLikeFacetType<T> where T: Comparable<T> {

    /**
     * Chooses a random value from the provided enumeration
     * @param enumeration the enumeration
     * @return a random value
     */
    internal fun value(enumeration: List<T>): T {
        return enumeration.random()
    }

    /**
     * Generates a random value for the provided pattern
     */
    internal fun value(pattern: String) : T {
        TODO("Pattern based value generation is not yet implemented")
    }

    /**
     * Generates a random value within a given range
     * @param min the minimum value
     * @param minInclusive whether the minimum value is inclusive
     * @param max the maximum value
     * @param maxInclusive whether the maximum value is inclusive
     * @return a random value
     */
    internal abstract fun value(min: T?, minInclusive: Boolean = true, max: T?, maxInclusive: Boolean = true): T

    override fun generate(
        pattern: String?,
        enumeration: List<T>?,
        min: T?,
        minInclusive: Boolean,
        max: T?,
        maxInclusive: Boolean,
        whiteSpace: String?,
        assertions: List<String>?
    ): String {
        if (whiteSpace != null || assertions != null) {
            TODO("whiteSpace and assertions are not yet supported")
        }
        // pattern and enumeration are mutually exclusive
        require(!(pattern != null && enumeration != null)) { "Pattern and enumeration are mutually exclusive" }
        // pattern and min/max are mutually exclusive
        require(!(pattern != null && (min != null || max != null))) { "Pattern and min/max are mutually exclusive" }
        // enumeration and min/max are mutually exclusive
        require(!(enumeration != null && (min != null || max != null))) { "Enumeration and min/max are mutually exclusive" }
        return if (pattern != null) {
            value(pattern).toString()
        } else if (enumeration != null) {
            value(enumeration).toString()
        } else {
            value(min, minInclusive, max, maxInclusive).toString()
        }
    }

}