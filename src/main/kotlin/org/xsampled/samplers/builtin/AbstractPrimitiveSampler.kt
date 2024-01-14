package org.xsampled.samplers.builtin

import java.time.format.DateTimeFormatter
import java.util.*

// this class is the base class for all primitive samplers
// it uses the default implementations of the interfaces
abstract class AbstractPrimitiveSampler(
    private val anyURISampler: IAnyURISampler = defaultAnyUriSampler,
    private val base64BinarySampler: IBase64BinarySampler = defaultBase64BinarySampler,
    private val booleanSampler: IBooleanSampler = defaultBooleanSampler,
    private val dateSampler: IDateSampler = defaultDateSampler,
    private val dateTimeSampler: IDateTimeSampler = defaultDateTimeSampler,
    private val decimalSampler: IDecimalSampler = defaultDecimalSampler,
    private val doubleSampler: IDoubleSampler = defaultDoubleSampler,
    private val durationSampler: IDurationSampler = defaultDurationSampler,
    private val floatSampler: IFloatSampler = defaultFloatSampler,
    private val gDaySampler: IGDaySampler = defaultGDaySampler,
    private val gMonthSampler: IGMonthSampler = defaultGMonthSampler,
    private val gMonthDaySampler: IGMonthDaySampler = defaultGMonthDaySampler,
    private val gYearSampler: IGYearSampler = defaultGYearSampler,
    private val gYearMonthSampler: IGYearMonthSampler = defaultGYearMonthSampler,
    private val hexbinarySampler: IHexBinarySampler = defaultHexBinarySampler,
    private val dtdNOTATIONSampler: INOTATIONSampler = defaultNOTATIONSampler,
    private val dtdQNameSampler: IQNameSampler = defaultQNameSampler,
    private val stringSampler: IStringSampler = defaultStringSampler,
    private val timeSampler: ITimeSampler = defaultTimeSampler
) {

    // the default samplers for this class rely on the default implementations of their corresponding interfaces
    private companion object {
        private val defaultAnyUriSampler = object : IAnyURISampler {}
        private val defaultBase64BinarySampler = object : IBase64BinarySampler {}
        private val defaultBooleanSampler = object : IBooleanSampler {}
        private val defaultDateSampler = object : IDateSampler {}
        private val defaultDateTimeSampler = object : IDateTimeSampler {}
        private val defaultDecimalSampler = object : IDecimalSampler {}
        private val defaultDoubleSampler = object : IDoubleSampler {}
        private val defaultDurationSampler = object : IDurationSampler {}
        private val defaultFloatSampler = object : IFloatSampler {}
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

    fun generateAnyURI(): String = anyURISampler.generateAnyURI().toString()
    fun generateBase64Binary(): String = base64BinarySampler.generateBase64Binary()
    fun generateBoolean(): String = booleanSampler.generateBoolean().toString()
    fun generateDate(): String = dateSampler.generateDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
    fun generateDateTime(): String = dateTimeSampler.generateDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    fun generateDecimal(): String = decimalSampler.generateDecimal().toString()
    fun generateDouble(): String = doubleSampler.generateDouble().toString()
    fun generateDuration(): String = durationSampler.generateDuration().toString()
    fun generateFloat(): String = floatSampler.generateFloat().toString()
    fun generateGDay(): String = gDaySampler.generateGDay()
    fun generateGMonth(): String = gMonthSampler.generateGMonth()
    fun generateGMonthDay(): String = gMonthDaySampler.generateGMonthDay()
    fun generateGYear(): String = gYearSampler.generateGYear()
    fun generateGYearMonth(): String = gYearMonthSampler.generateGYearMonth()
    fun generateHexBinary(): String = HexFormat.of().formatHex(hexbinarySampler.generateHexBinary())
    fun generateString(): String = stringSampler.generateString()
    fun generateTime(): String = timeSampler.generateTime().format(DateTimeFormatter.ISO_LOCAL_TIME)
    fun generateNOTATION(): String = dtdNOTATIONSampler.generateNOTATION()
    fun generateQName(): String = dtdQNameSampler.generateQName()

}