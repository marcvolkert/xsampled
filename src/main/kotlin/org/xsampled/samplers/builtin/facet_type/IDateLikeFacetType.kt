package org.xsampled.samplers.builtin.facet_type

/**
 * Provides the method signature for generating XSD dateTime, time, date, gYearMonth, gYear, gMonthDay, gDay, and gMonth
 * types with a given set of facets.
 */
internal interface IDateLikeFacetType {

    fun generate(
        pattern: String? = null,
        enumeration: List<String>? = null,
        minInclusive: String? = null,
        minExclusive: String? = null,
        maxInclusive: String? = null,
        maxExclusive: String? = null,
        explicitTimezone: String? = null,
        whiteSpace: String? = null,
        assertions: List<String>? = null
    ): String

}