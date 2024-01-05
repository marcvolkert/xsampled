package org.xsampled.samplers.simple.content

import org.apache.ws.commons.schema.XmlSchemaEnumerationFacet
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeRestriction

class Restriction {

    companion object {

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generate(restriction: XmlSchemaSimpleTypeRestriction) {
            restriction.facets.forEach {
                when (it) {
                    is XmlSchemaEnumerationFacet -> generateEnumerationFacet(it)
                }
            }
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateEnumerationFacet(facet: XmlSchemaEnumerationFacet): Any {
            return facet.value
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateMaxExclusiveFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateMaxInclusiveFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateMinExclusiveFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateMinInclusiveFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateNumericFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generatePatternFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

        // TODO: write test
        // TODO: implement
        // TODO: write documentation
        fun generateWhiteSpaceFacet(facet: XmlSchemaEnumerationFacet): Any {
            return ""
        }

    }

}