package org.xsampled.samplers.builtin

import javax.xml.namespace.QName

interface IQNameSampler {

    fun generateQName(valuesSpace: Iterable<QName>): QName {
        /**
         * Chooses a random QName from the given valuesSpace
         * Reference: https://www.w3.org/TR/xmlschema-2/#QName
         * @param valuesSpace the valuesSpace to choose the QName from
         * @return a random QName
         */
        return valuesSpace.toList().random()
    }

}
