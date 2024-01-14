package org.xsampled.samplers.builtin

import org.xsampled.helpers.Randomization
import java.net.URI

interface IAnyURISampler {

    companion object {
        const val LOWER_BOUND_NAMES = 5
        const val UPPER_BOUND_NAMES = 20
        const val LOWER_BOUND_PASSWORDS = 10
        const val UPPER_BOUND_PASSWORDS = 20
        const val LOWER_BOUND_SUBDOMAINS = 1
        const val UPPER_BOUND_SUBDOMAINS = 3
        const val LOWER_BOUND_SUBDOMAIN_NAMES = 3
        const val UPPER_BOUND_SUBDOMAIN_NAMES = 12
    }

    fun generateAnyURI(): URI {
        /**
         * Generates a random absolute URI as URI
         * Reference: https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
         * A URI is composed of a scheme, an optional authority, a path, an optional query,
         * and an optional fragment
         * @return a random URI
         */
        val uriString = Randomization.getRandomUri(
            lowerBoundNames = LOWER_BOUND_NAMES,
            upperBoundNames = UPPER_BOUND_NAMES,
            lowerBoundPasswords = LOWER_BOUND_PASSWORDS,
            upperBoundPasswords = UPPER_BOUND_PASSWORDS,
            lowerBoundSubdomains = LOWER_BOUND_SUBDOMAINS,
            upperBoundSubdomains = UPPER_BOUND_SUBDOMAINS,
            lowerBoundSubdomainNames = LOWER_BOUND_SUBDOMAIN_NAMES,
            upperBoundSubdomainNames = UPPER_BOUND_SUBDOMAIN_NAMES
        )
        // build URI
        return URI(uriString)
    }
}