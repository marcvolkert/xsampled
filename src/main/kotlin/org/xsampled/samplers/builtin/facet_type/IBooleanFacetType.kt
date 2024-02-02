package org.xsampled.samplers.builtin.facet_type

/**
 * Provides the method signature for generating XSD boolean types with a given set of facets.
 */
internal interface IBooleanFacetType {

    fun generate(
        pattern: String? = null,
        whiteSpace: String? = null,
        assertions: List<String>? = null
    ): String

}