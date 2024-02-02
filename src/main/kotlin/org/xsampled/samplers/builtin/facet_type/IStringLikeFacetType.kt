package org.xsampled.samplers.builtin.facet_type

/**
 * Provides the method signature for generating XSD string, hexBinary, base64Binary, anyURI, QName, and NOTATION types
 * with a given set of facets.
 */
internal interface IStringLikeFacetType {

    fun generate(
        pattern: String? = null,
        enumeration: List<String>? = null,
        length: Int? = null,
        minLength: Int? = null,
        maxLength: Int? = null,
        whiteSpace: String? = null,
        assertions: List<String>? = null
    ): String

}