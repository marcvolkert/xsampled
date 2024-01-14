package org.xsampled.test.blueprints

import org.apache.ws.commons.schema.*
import org.dom4j.io.DOMWriter
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.platform.commons.annotation.Testable
import org.xsampled.samplers.builtin.AbstractPrimitiveSampler
import java.io.File
import java.io.StringWriter
import javax.xml.XMLConstants
import javax.xml.namespace.QName
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
import javax.xml.validation.Validator


@Testable
@DisplayName("Generated primitive values can be validated against a schema")
abstract class SamplerPrimitiveValidationTest {

    protected companion object {

        private val schemaFile = File("src/test/resources/only-primitives.xsd")
        protected val validator: Validator = setValidator()
        protected val schema: XmlSchema = setSchema()

        private fun setValidator(): Validator {
            // create a validator for the schema
            val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
            return schemaFactory.newSchema(schemaFile).newValidator()
        }

        private fun setSchema(): XmlSchema {
            val schemaCollection = XmlSchemaCollection()
            return schemaCollection.read(StreamSource(schemaFile))
        }

        private fun getParticles(): XmlSchemaSequence {
            // get the xsd root element
            val root = schema.elements.entries.first().value
            // get the type of the root element as a complex type
            val rootType = root.schemaType as XmlSchemaComplexType
            // get the particle of the complex type as a sequence
            return rootType.particle as XmlSchemaSequence
        }

        @JvmStatic
        protected fun getQNames(): List<QName> {
            val particles = getParticles()

            return particles.items
                .map { it as XmlSchemaElement }
                .map { it.qName }
        }

        @JvmStatic
        protected fun getTypeQNames(): List<QName> {
            val particles = getParticles()

            return particles.items
                .map { it as XmlSchemaElement }
                .map { it.schemaType as XmlSchemaSimpleType }
                .map { it.qName }
        }

    }

    abstract val sampler: AbstractPrimitiveSampler

    @RepeatedTest(100)
    @DisplayName("Generate a random XML from the schema and validate it")
    fun testPrimitiveValidation() {
        // init a dom4j document
        val document = org.dom4j.DocumentHelper.createDocument()
        // get the xsd root element
        val root = schema.elements.entries.first().value
        // add the root element to the dom4j document
        document.addElement(root.qName.localPart)
        val elementNames = getQNames()
        val typeNames = getTypeQNames()
        // zip
        val elementDefinitions = elementNames.zip(typeNames)
        // add the elements to the dom4j document
        elementDefinitions.forEach { definition ->
            run {
                val element = document.rootElement.addElement(definition.first.localPart)
                // switch on key
                when (definition.second.localPart) {
                    "anyURI" -> element.text = sampler.generateAnyURI()
                    "base64Binary" -> element.text = sampler.generateBase64Binary()
                    "boolean" -> element.text = sampler.generateBoolean()
                    "date" -> element.text = sampler.generateDate()
                    "dateTime" -> element.text = sampler.generateDateTime()
                    "decimal" -> element.text = sampler.generateDecimal()
                    "double" -> element.text = sampler.generateDouble()
                    "duration" -> element.text = sampler.generateDuration()
                    "float" -> element.text = sampler.generateFloat()
                    "gDay" -> element.text = sampler.generateGDay()
                    "gMonth" -> element.text = sampler.generateGMonth()
                    "gMonthDay" -> element.text = sampler.generateGMonthDay()
                    "gYear" -> element.text = sampler.generateGYear()
                    "gYearMonth" -> element.text = sampler.generateGYearMonth()
                    "hexBinary" -> element.text = sampler.generateHexBinary()
                    "NOTATION" -> element.text = sampler.generateNOTATION()
                    "QName" -> element.text = sampler.generateQName()
                    "string" -> element.text = sampler.generateString()
                    "time" -> element.text = sampler.generateTime()
                    else -> throw Exception("Unknown primitive type ${definition.second.localPart}")
                }
            }
        }
        // transform document to dom source
        val domSource = DOMSource(DOMWriter().write(document))
        // print the document beautifully
        val transformer = TransformerFactory.newInstance().newTransformer()
        transformer.setOutputProperty(OutputKeys.INDENT, "yes")
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
        val result = StreamResult(StringWriter())
        transformer.transform(domSource, result)
        println("--- Generated XML: ---\n${result.writer}\n")
        // validate the dom source
        assertDoesNotThrow {
            validator.validate(domSource)
        }
    }

}