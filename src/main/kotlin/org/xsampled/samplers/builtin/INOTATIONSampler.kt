package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization

interface INOTATIONSampler {
    companion object {
        const val ABBREVIATION_MIN_LENGTH = 3
        const val ABBREVIATION_MAX_LENGTH = 3
        const val LOWER_BOUND_NAMES = 5
        const val UPPER_BOUND_NAMES = 20
        const val LOWER_BOUND_PASSWORDS = 10
        const val UPPER_BOUND_PASSWORDS = 20
        const val LOWER_BOUND_SUBDOMAINS = 1
        const val UPPER_BOUND_SUBDOMAINS = 3
        const val LOWER_BOUND_SUBDOMAIN_NAMES = 3
        const val UPPER_BOUND_SUBDOMAIN_NAMES = 12
    }

    fun generateNOTATION(): String {
        /**
         * Generates a random NOTATION as String
         * Reference: https://www.w3.org/TR/xmlschema-2/#NOTATION
         * @return a random NOTATION
         */
        // generate a random abbreviation
        val abbreviation = Randomization.getRandomString(ABBREVIATION_MIN_LENGTH, ABBREVIATION_MAX_LENGTH)
        // decide whether to use PUBLIC or SYSTEM and return the result
        return if (Randomization.rand.nextBoolean()) {
            "$abbreviation PUBLIC"
        } else {
            // generate MIME or URI
            val suffix = if (Randomization.rand.nextBoolean()) {
                Randomization.getRandomUri(
                    lowerBoundNames = LOWER_BOUND_NAMES,
                    upperBoundNames = UPPER_BOUND_NAMES,
                    lowerBoundPasswords = LOWER_BOUND_PASSWORDS,
                    upperBoundPasswords = UPPER_BOUND_PASSWORDS,
                    lowerBoundSubdomains = LOWER_BOUND_SUBDOMAINS,
                    upperBoundSubdomains = UPPER_BOUND_SUBDOMAINS,
                    lowerBoundSubdomainNames = LOWER_BOUND_SUBDOMAIN_NAMES,
                    upperBoundSubdomainNames = UPPER_BOUND_SUBDOMAIN_NAMES
                )
            } else {
                abbreviation
            }
            "$abbreviation SYSTEM \"$suffix\""
        }

    }

}
