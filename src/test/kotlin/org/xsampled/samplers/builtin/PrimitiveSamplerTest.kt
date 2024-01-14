package org.xsampled.samplers.builtin

import org.junit.jupiter.api.Nested
import org.xsampled.test.blueprints.PrimitiveSamplerTest

internal class PrimitiveSamplerTest {

    @Nested
    inner class DefaultsTest : PrimitiveSamplerTest() {
        override val sampler: AbstractPrimitiveSampler = object : AbstractPrimitiveSampler() {}
    }

}