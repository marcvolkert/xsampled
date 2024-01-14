package org.xsampled.samplers.builtin

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.platform.commons.annotation.Testable
import org.xsampled.helpers.Randomization
import org.xsampled.test.blueprints.PrimitiveSamplerTest
import javax.xml.namespace.QName

@Testable
@DisplayName("Primitive samplers delivered with the library are valid according to PrimitiveSamplerTest")
internal class BuiltinPrimitiveSamplerTests {

    // generate list with for loop
    private val bootStrapQNames = mutableListOf<QName>().apply {
        for (i in 1..100) {
            add(Randomization.getRandomQName(
                lowerBoundNames = 3,
                upperBoundNames = 10,
                lowerBoundPasswords = 5,
                upperBoundPasswords = 20,
                lowerBoundSubdomains = 1,
                upperBoundSubdomains = 3,
                lowerBoundSubdomainNames = 3,
                upperBoundSubdomainNames = 12
            ))
        }
    }

    @Nested
    @DisplayName("Default implementation of AbstractPrimitiveSampler generates valid values")
    inner class DefaultAbstractPrimitiveSamplerTest : PrimitiveSamplerTest() {
        override val sampler: AbstractPrimitiveSampler = object : AbstractPrimitiveSampler(availableQNames = bootStrapQNames) {}
    }

}