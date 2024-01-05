package org.xsampled.samplers.simple

import org.apache.ws.commons.schema.XmlSchemaSimpleType
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeList
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeRestriction
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeUnion

// this class is used to generate random values for simple types
// it delegates to appropriate classes for different types
class SimpleTypeSampler() {

    companion object {

        fun generate(simpleType: XmlSchemaSimpleType): String {

            val content = simpleType.content

            return ""
        }

        fun generateRestriction(content: XmlSchemaSimpleTypeRestriction) {
        }

        fun generateList(content: XmlSchemaSimpleTypeList) {
        }

        fun generateUnion(content: XmlSchemaSimpleTypeUnion) {
        }

    }

}