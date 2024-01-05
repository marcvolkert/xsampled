package org.xsampled


import org.apache.ws.commons.schema.XmlSchemaCollection
import org.apache.ws.commons.schema.XmlSchemaSimpleType
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeRestriction
import java.io.FileInputStream
import javax.xml.transform.stream.StreamSource


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // iterate over the elements
    XMLGenerator.generate(FileInputStream("src/main/resources/POSLogV6.0.0.xsd"))

}

class XMLGenerator {

    // static method
    companion object {

        fun generate(xsdFile: FileInputStream) {

            // read the schema
            val schema = xsdFile.use {
                val schemaCollection = XmlSchemaCollection()
                schemaCollection.read(StreamSource(it))
            }
            // this library can only handle one root element
            if (schema.elements.size > 1)
                throw Exception("Multiple root elements in a schema are not supported")

            // TODO: get Schema components (elements, complexTypes, simpleTypes, attribute groups)
            // Schemas generally contain elements, data types, and attributes

            // separate complexTypes and simpleTypes by class
            //val (simpleTypes, complexTypes) = schema.schemaTypes.entries.partition { it.value is XmlSchemaSimpleType }

            schema.schemaTypes.entries.filter { it.value is XmlSchemaSimpleType }
                .map { x -> x.value }
                .map { x -> x as XmlSchemaSimpleType }
                .map { x -> x.content }
                .filter { x -> x is XmlSchemaSimpleTypeRestriction }
                .map { x -> x as XmlSchemaSimpleTypeRestriction }
                .map { x -> x.facets }
                .forEach(::println)

        }
    }
}