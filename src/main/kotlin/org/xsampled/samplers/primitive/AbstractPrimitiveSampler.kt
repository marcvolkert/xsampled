package org.xsampled.samplers.primitive

// this class is the base class for all primitive samplers
// it uses the default implementations of the interfaces
abstract class AbstractPrimitiveSampler(
    private val binarySampler: IBinarySampler = AbstractPrimitiveSampler.binarySampler,
    private val booleanSampler: IBooleanSampler = AbstractPrimitiveSampler.booleanSampler,
    private val dateTimeSampler: IDateTimeSampler = AbstractPrimitiveSampler.dateTimeSampler,
    private val floatingPointSampler: INumericSampler = AbstractPrimitiveSampler.floatingPointSampler,
    private val textSampler: ITextSampler = AbstractPrimitiveSampler.textSampler
) {

    private companion object {
        private val binarySampler = object : IBinarySampler {}
        private val booleanSampler = object : IBooleanSampler {}
        private val dateTimeSampler = object : IDateTimeSampler {}
        private val floatingPointSampler = object : INumericSampler {}
        private val textSampler = object : ITextSampler {}
    }

    fun generateURI(): String = textSampler.generateURI()
    fun generateBase64Binary(): String = binarySampler.generateBase64Binary()
    fun generateBoolean(): String = booleanSampler.generateBoolean()
    fun generateDate(): String = dateTimeSampler.generateDate()
    fun generateDateTime(): String = dateTimeSampler.generateDateTime()
    fun generateDecimal(): String = floatingPointSampler.generateDecimal().toString()
    fun generateDouble(): String = floatingPointSampler.generateDouble().toString()
    fun generateDuration(): String = dateTimeSampler.generateDuration()
    fun generateFloat(): String = floatingPointSampler.generateFloat().toString()
    fun generateGDay(): String = dateTimeSampler.generateGDay()
    fun generateGMonth(): String = dateTimeSampler.generateGMonth()
    fun generateGMonthDay(): String = dateTimeSampler.generateGMonthDay()
    fun generateGYear(): String = dateTimeSampler.generateGYear()
    fun generateGYearMonth(): String = dateTimeSampler.generateGYearMonth()
    fun generateHexBinary(): String = binarySampler.generateHexBinary()

    // throw exception
    fun generateInt(): String = throw NotImplementedError()
    fun generateInteger(): String = throw NotImplementedError()
    fun generateLong(): String = throw NotImplementedError()
    fun generateNegativeInteger(): String = throw NotImplementedError()
    fun generateNonNegativeInteger(): String = throw NotImplementedError()
    fun generateNonPositiveInteger(): String = throw NotImplementedError()
    fun generatePositiveInteger(): String = throw NotImplementedError()
    fun generateShort(): String = throw NotImplementedError()
    fun generateString(): String = textSampler.generateString()
    fun generateTime(): String = dateTimeSampler.generateTime()
    fun generateUnsignedByte(): String = throw NotImplementedError()
    fun generateUnsignedInt(): String = throw NotImplementedError()
    fun generateUnsignedLong(): String = throw NotImplementedError()
    fun generateUnsignedShort(): String = throw NotImplementedError()
    fun generateNOTATION(): String = throw NotImplementedError()
    fun generateQName(): String = throw NotImplementedError()

}