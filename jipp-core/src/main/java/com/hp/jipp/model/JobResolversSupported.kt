// Copyright 2018 HP Development Company, L.P.
// SPDX-License-Identifier: MIT
//
// DO NOT MODIFY. Code is auto-generated by genTypes.py. Content taken from registry at
// https://www.iana.org/assignments/ipp-registrations/ipp-registrations.xml, updated on 2019-05-28
@file:Suppress("MaxLineLength", "WildcardImport")

package com.hp.jipp.model

import com.hp.jipp.encoding.* // ktlint-disable no-wildcard-imports

/**
 * Data object corresponding to a "job-resolvers-supported" collection as defined in:
 * [PWG5100.13](https://ftp.pwg.org/pub/pwg/candidates/cs-ippjobprinterext3v10-20120727-5100.13.pdf).
 */
@Suppress("RedundantCompanionReference", "unused")
data class JobResolversSupported
constructor(
    var resolverName: String? = null
) : AttributeCollection {

    /** Construct an empty [JobResolversSupported]. */
    constructor() : this(null)

    /** Produce an attribute list from members. */
    override val attributes: List<Attribute<*>> by lazy {
        listOfNotNull(
            resolverName?.let { Types.resolverName.of(it) }
        )
    }

    /** Type for attributes of this collection */
    class Type(override val name: String) : AttributeCollection.Type<JobResolversSupported>(JobResolversSupported)

    /** All member names as strings. */
    object Name {
        /** "resolver-name" member name */
        const val resolverName = "resolver-name"
    }

    /** Types for each member attribute. */
    object Types {
        val resolverName = NameType(Name.resolverName)
    }

    /** Defines types for each member of [JobResolversSupported] */
    companion object : AttributeCollection.Converter<JobResolversSupported> {
        override fun convert(attributes: List<Attribute<*>>): JobResolversSupported =
            JobResolversSupported(
                extractOne(attributes, Types.resolverName)?.value
            )
    }
}
