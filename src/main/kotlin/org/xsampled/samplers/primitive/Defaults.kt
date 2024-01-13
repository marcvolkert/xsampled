package org.xsampled.samplers.primitive

class Defaults {

    companion object {
        fun getBinarySampler(): IBinarySampler {
            return object : IBinarySampler {}
        }

        fun getBooleanSampler(): IBooleanSampler {
            return object : IBooleanSampler {}
        }

        fun getDateTimeSampler(): IDateTimeSampler {
            return object : IDateTimeSampler {}
        }

        fun getFloatingPointSampler(): IFloatingPointSampler {
            return object : IFloatingPointSampler {}
        }

        fun getTextSampler(): ITextSampler {
            return object : ITextSampler {}
        }
        
    }


}