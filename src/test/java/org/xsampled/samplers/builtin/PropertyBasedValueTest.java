package org.xsampled.samplers.builtin;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.FloatRange;
import net.jqwik.api.constraints.LongRange;
import net.jqwik.api.constraints.WithNull;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.StatisticsReport;
import org.assertj.core.api.Assertions;
import org.junit.platform.commons.annotation.Testable;
import org.xsampled.samplers.builtin.numeric_like.DoubleSampler;
import org.xsampled.samplers.builtin.numeric_like.DurationSampler;
import org.xsampled.samplers.builtin.numeric_like.FloatSampler;

import java.time.Duration;

@Testable
class PropertyBasedValueTest {

    @Property
    @Label("FloatSampler generates values within the specified range")
    void floatMinMaxValueTest(@ForAll @FloatRange(min = FloatSampler.MIN_FLOAT, minIncluded = false, max = FloatSampler.MAX_FLOAT, maxIncluded = false) @WithNull(0.5) Float min,
                              @ForAll Boolean minInclusive,
                              @ForAll @FloatRange(min = FloatSampler.MIN_FLOAT, minIncluded = false, max = FloatSampler.MAX_FLOAT, maxIncluded = false) @WithNull(0.5) Float max,
                              @ForAll Boolean maxInclusive) {
        FloatSampler sampler = new FloatSampler() {};

        // if min or max is null, then the value should be between the min and max of the sampler
        float lowerLimit = (min == null) ? FloatSampler.MIN_FLOAT : min;
        float upperLimit = (max == null) ? FloatSampler.MAX_FLOAT : max;

        // generation should work according to java.util.Random
        // therefore rand should be in [origin, bound)
        float origin = (minInclusive) ? lowerLimit : Math.nextUp(lowerLimit);
        float bound = (maxInclusive) ? Math.nextUp(upperLimit) : upperLimit;

        if (origin >= bound) {
            Assertions.assertThatThrownBy(() -> sampler.value$xsampled(min, minInclusive, max, maxInclusive))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Assertions.assertThat(
                    sampler.value$xsampled(min, minInclusive, max, maxInclusive)
            ).isBetween(
                    minInclusive ? Math.nextDown(lowerLimit) : lowerLimit,
                    Math.nextUp(bound)
            );
        }

    }

    @Property
    @Label("DoubleSampler generates values within the specified range")
    void doubleMinMaxValueTest(@ForAll @DoubleRange(min = DoubleSampler.MIN_DOUBLE, minIncluded = false, max = DoubleSampler.MAX_DOUBLE, maxIncluded = false) @WithNull(0.5) Double min,
                               @ForAll Boolean minInclusive,
                               @ForAll @DoubleRange(min = DoubleSampler.MIN_DOUBLE, minIncluded = false, max = DoubleSampler.MAX_DOUBLE, maxIncluded = false) @WithNull(0.5) Double max,
                               @ForAll Boolean maxInclusive) {
        DoubleSampler sampler = new DoubleSampler() {};

        // if min or max is null, then the value should be between the min and max of the sampler
        double lowerLimit = (min == null) ? DoubleSampler.MIN_DOUBLE : min;
        double upperLimit = (max == null) ? DoubleSampler.MAX_DOUBLE : max;

        // generation should work according to java.util.Random
        // therefore rand should be in [origin, bound)
        double origin = (minInclusive) ? lowerLimit : Math.nextUp(lowerLimit);
        double bound = (maxInclusive) ? Math.nextUp(upperLimit) : upperLimit;

        if (origin >= bound) {
            Assertions.assertThatThrownBy(() -> sampler.value$xsampled(min, minInclusive, max, maxInclusive))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Assertions.assertThat(
                    sampler.value$xsampled(min, minInclusive, max, maxInclusive)
            ).isBetween(
                    minInclusive ? Math.nextDown(lowerLimit) : lowerLimit,
                    Math.nextUp(bound)
            );
        }

    }

    @Property
    @Label("DurationSampler generates values within the specified range")
    void durationMinMaxValueTest(@ForAll @LongRange(min = DurationSampler.MIN_DURATION_SECONDS, max = DurationSampler.MAX_DURATION_SECONDS) @WithNull(0.5) Long minSeconds,
                                 @ForAll Boolean minInclusive,
                                 @ForAll @LongRange(min = DurationSampler.MIN_DURATION_SECONDS, max = DurationSampler.MAX_DURATION_SECONDS) @WithNull(0.5) Long maxSeconds,
                                 @ForAll Boolean maxInclusive) {
        DurationSampler sampler = new DurationSampler() {};

        Duration min = (minSeconds == null) ? null : Duration.ofSeconds(minSeconds);
        Duration max = (maxSeconds == null) ? null : Duration.ofSeconds(maxSeconds);

        // if min or max is null, then the value should be between the min and max of the sampler
        long lowerLimit = (min == null) ? DurationSampler.MIN_DURATION_SECONDS : min.getSeconds();
        long upperLimit = (max == null) ? DurationSampler.MAX_DURATION_SECONDS : max.getSeconds();

        // generation should work according to java.util.Random
        // therefore rand should be in [origin, bound)
        long origin = (minInclusive) ? lowerLimit : (lowerLimit + 1);
        long bound = (maxInclusive) ? (upperLimit + 1) : upperLimit;

        if (origin >= bound) {
            Assertions.assertThatThrownBy(() -> sampler.value$xsampled(min, minInclusive, max, maxInclusive))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Assertions.assertThat(
                    sampler.value$xsampled(min, minInclusive, max, maxInclusive)
            ).isBetween(
                    Duration.ofSeconds(minInclusive ? (lowerLimit - 1) : lowerLimit),
                    Duration.ofSeconds(maxInclusive ? (upperLimit + 1) : upperLimit)
            );
        }

    }

}
