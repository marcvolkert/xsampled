package org.xsampled.samplers.builtin.facet_type

/**
 * Provides the method signature for generating XSD decimal types with a given set of facets.
 */
interface IDecimalFacetType {

    fun generate(
        pattern: String? = null,
        enumeration: List<String>? = null,
        minInclusive: String? = null,
        minExclusive: String? = null,
        maxInclusive: String? = null,
        maxExclusive: String? = null,
        totalDigits: Int? = null,
        fractionDigits: Int? = null,
        whiteSpace: String? = null,
        assertions: List<String>? = null
    ): String

}