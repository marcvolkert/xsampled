package org.xsampled.samplers.builtin.facet_type

/**
 * Provides the method signature for generating XSD float, double, and duration types with a given set of facets.
 */
internal interface INumericLikeFacetType<T> where T: Comparable<T> {

    fun generate(
        pattern: String? = null,
        enumeration: List<T>? = null,
        min: T? = null,
        minInclusive: Boolean = true,
        max: T? = null,
        maxInclusive: Boolean = true,
        whiteSpace: String? = null,
        assertions: List<String>? = null
    ): String

}