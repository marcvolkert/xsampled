package org.xsampled.samplers.primitive

import org.junit.jupiter.api.Nested
import org.xsampled.blueprints.PrimitiveSamplerTest

internal class PrimitiveSamplerTest {

    @Nested
    inner class DefaultsTest : org.xsampled.blueprints.PrimitiveSamplerTest() {
        override val sampler: AbstractPrimitiveSampler = object : AbstractPrimitiveSampler() {}
    }

}