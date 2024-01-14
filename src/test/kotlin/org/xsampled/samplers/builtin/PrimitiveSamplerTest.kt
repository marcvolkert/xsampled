package org.xsampled.samplers.builtin

import org.junit.jupiter.api.Nested

internal class PrimitiveSamplerTest {

    @Nested
    inner class DefaultsTest : org.xsampled.blueprints.PrimitiveSamplerTest() {
        override val sampler: AbstractPrimitiveSampler = object : AbstractPrimitiveSampler() {}
    }

}