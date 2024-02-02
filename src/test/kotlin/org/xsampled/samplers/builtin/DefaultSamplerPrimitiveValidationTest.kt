package org.xsampled.samplers.builtin

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.platform.commons.annotation.Testable
import org.xsampled.AbstractPrimitiveSampler
import org.xsampled.test.blueprints.SamplerPrimitiveValidationTest

@Testable
@DisplayName("Default sampler passes SamplerPrimitiveValidationTest")
internal class DefaultSamplerPrimitiveValidationTests {

    @Nested
    @DisplayName("Default implementation of AbstractPrimitiveSampler generates valid values")
    inner class DefaultSamplerPrimitiveValidationTest : SamplerPrimitiveValidationTest() {
        override val sampler: AbstractPrimitiveSampler =
            object : AbstractPrimitiveSampler(availableQNames = getQNames()) {}
    }
}