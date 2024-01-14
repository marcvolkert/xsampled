package org.xsampled.samplers.builtin

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.platform.commons.annotation.Testable
import org.xsampled.test.blueprints.PrimitiveSamplerTest

@Testable
@DisplayName("Primitive samplers delivered with the library are valid according to PrimitiveSamplerTest")
internal class BuiltinPrimitiveSamplerTests {

    @Nested
    @DisplayName("Default implementation of AbstractPrimitiveSampler generates valid values")
    inner class DefaultAbstractPrimitiveSamplerTest : PrimitiveSamplerTest() {
        override val sampler: AbstractPrimitiveSampler = object : AbstractPrimitiveSampler() {}
    }

}