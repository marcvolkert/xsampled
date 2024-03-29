package org.xsampled

import org.xsampled.samplers.builtin.*
import org.xsampled.samplers.builtin.numeric_like.DoubleSampler
import org.xsampled.samplers.builtin.numeric_like.FloatSampler
import org.xsampled.samplers.builtin.numeric_like.DurationSampler
import java.time.format.DateTimeFormatter
import java.util.*
import javax.xml.namespace.QName
import kotlin.contracts.ExperimentalContracts

// this class is the base class for all primitive samplers
// it uses the default implementations of the interfaces
internal abstract class AbstractPrimitiveSampler(
    private val anyURISampler: IAnyURISampler = defaultAnyUriSampler,
    private val base64BinarySampler: IBase64BinarySampler = defaultBase64BinarySampler,
    private val booleanSampler: IBooleanSampler = defaultBooleanSampler,
    private val dateSampler: IDateSampler = defaultDateSampler,
    private val dateTimeSampler: IDateTimeSampler = defaultDateTimeSampler,
    private val decimalSampler: IDecimalSampler = defaultDecimalSampler,
    private val doubleSampler: DoubleSampler = defaultDoubleSampler,
    private val durationSampler: DurationSampler = defaultDurationSampler,
    private val floatSampler: FloatSampler = defaultFloatSampler,
    private val gDaySampler: IGDaySampler = defaultGDaySampler,
    private val gMonthSampler: IGMonthSampler = defaultGMonthSampler,
    private val gMonthDaySampler: IGMonthDaySampler = defaultGMonthDaySampler,
    private val gYearSampler: IGYearSampler = defaultGYearSampler,
    private val gYearMonthSampler: IGYearMonthSampler = defaultGYearMonthSampler,
    private val hexbinarySampler: IHexBinarySampler = defaultHexBinarySampler,
    private val dtdNOTATIONSampler: INOTATIONSampler = defaultNOTATIONSampler,
    private val dtdQNameSampler: IQNameSampler = defaultQNameSampler,
    private val stringSampler: IStringSampler = defaultStringSampler,
    private val timeSampler: ITimeSampler = defaultTimeSampler,
    private val availableQNames: Iterable<QName>
) {

    // the default samplers for this class rely on the default implementations of their corresponding interfaces
    private companion object {
        private val defaultAnyUriSampler = object : IAnyURISampler {}
        private val defaultBase64BinarySampler = object : IBase64BinarySampler {}
        private val defaultBooleanSampler = object : IBooleanSampler {}
        private val defaultDateSampler = object : IDateSampler {}
        private val defaultDateTimeSampler = object : IDateTimeSampler {}
        private val defaultDecimalSampler = object : IDecimalSampler {}
        private val defaultDoubleSampler = object : DoubleSampler() {}
        private val defaultDurationSampler = object : DurationSampler() {}
        private val defaultFloatSampler = object : FloatSampler() {}
        private val defaultGDaySampler = object : IGDaySampler {}
        private val defaultGMonthSampler = object : IGMonthSampler {}
        private val defaultGMonthDaySampler = object : IGMonthDaySampler {}
        private val defaultGYearSampler = object : IGYearSampler {}
        private val defaultGYearMonthSampler = object : IGYearMonthSampler {}
        private val defaultHexBinarySampler = object : IHexBinarySampler {}
        private val defaultNOTATIONSampler = object : INOTATIONSampler {}
        private val defaultQNameSampler = object : IQNameSampler {}
        private val defaultStringSampler = object : IStringSampler {}
        private val defaultTimeSampler = object : ITimeSampler {}
    }

    // methods for generating xml built-in types
    fun generateAnyURI(): String = anyURISampler.generateAnyURI().toString()
    fun generateBase64Binary(): String = base64BinarySampler.generateBase64Binary()
    fun generateBoolean(): String = booleanSampler.generateBoolean().toString()
    fun generateDate(): String = dateSampler.generateDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
    fun generateDateTime(): String = dateTimeSampler.generateDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    fun generateDecimal(): String = decimalSampler.generateDecimal().toString()
    @OptIn(ExperimentalContracts::class)
    fun generateDouble(): String = doubleSampler.generate()
    fun generateDuration(): String = durationSampler.generate()
    fun generateFloat(): String = floatSampler.generate()
    fun generateGDay(): String = gDaySampler.generateGDay()
    fun generateGMonth(): String = gMonthSampler.generateGMonth()
    fun generateGMonthDay(): String = gMonthDaySampler.generateGMonthDay()
    fun generateGYear(): String = gYearSampler.generateGYear()
    fun generateGYearMonth(): String = gYearMonthSampler.generateGYearMonth()
    fun generateHexBinary(): String = HexFormat.of().formatHex(hexbinarySampler.generateHexBinary())
    fun generateString(): String = stringSampler.generateString()
    fun generateTime(): String = timeSampler.generateTime().format(DateTimeFormatter.ISO_LOCAL_TIME)
    fun generateNOTATION(): String = dtdNOTATIONSampler.generateNOTATION()
    fun generateQName(): String = dtdQNameSampler.generateQName(availableQNames).toString()

}