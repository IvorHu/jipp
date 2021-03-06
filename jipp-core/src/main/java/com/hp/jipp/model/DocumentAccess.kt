// Copyright 2018 HP Development Company, L.P.
// SPDX-License-Identifier: MIT
//
// DO NOT MODIFY. Code is auto-generated by genTypes.py. Content taken from registry at
// https://www.iana.org/assignments/ipp-registrations/ipp-registrations.xml, updated on 2019-05-28
@file:Suppress("MaxLineLength", "WildcardImport")

package com.hp.jipp.model

import com.hp.jipp.encoding.* // ktlint-disable no-wildcard-imports

/**
 * Data object corresponding to a "document-access" collection as defined in:
 * [IPPWG20180620](https://www.pwg.org/archives/ipp/2018/019634.html),
 * [PWG5100.18](https://ftp.pwg.org/pub/pwg/candidates/cs-ippinfra10-20150619-5100.18.pdf).
 */
@Suppress("RedundantCompanionReference", "unused")
data class DocumentAccess
constructor(
    var accessOauthToken: List<ByteArray>? = null,
    var accessOauthUri: java.net.URI? = null,
    var accessPassword: String? = null,
    var accessPin: String? = null,
    var accessUserName: String? = null
) : AttributeCollection {

    /** Construct an empty [DocumentAccess]. */
    constructor() : this(null, null, null, null, null)

    /** Produce an attribute list from members. */
    override val attributes: List<Attribute<*>> by lazy {
        listOfNotNull(
            accessOauthToken?.let { Types.accessOauthToken.of(it) },
            accessOauthUri?.let { Types.accessOauthUri.of(it) },
            accessPassword?.let { Types.accessPassword.of(it) },
            accessPin?.let { Types.accessPin.of(it) },
            accessUserName?.let { Types.accessUserName.of(it) }
        )
    }

    /** Type for attributes of this collection */
    class Type(override val name: String) : AttributeCollection.Type<DocumentAccess>(DocumentAccess)

    /** All member names as strings. */
    object Name {
        /** "access-oauth-token" member name */
        const val accessOauthToken = "access-oauth-token"
        /** "access-oauth-uri" member name */
        const val accessOauthUri = "access-oauth-uri"
        /** "access-password" member name */
        const val accessPassword = "access-password"
        /** "access-pin" member name */
        const val accessPin = "access-pin"
        /** "access-user-name" member name */
        const val accessUserName = "access-user-name"
    }

    /** Types for each member attribute. */
    object Types {
        val accessOauthToken = OctetsType(Name.accessOauthToken)
        val accessOauthUri = UriType(Name.accessOauthUri)
        val accessPassword = TextType(Name.accessPassword)
        val accessPin = TextType(Name.accessPin)
        val accessUserName = TextType(Name.accessUserName)
    }

    /** Defines types for each member of [DocumentAccess] */
    companion object : AttributeCollection.Converter<DocumentAccess> {
        override fun convert(attributes: List<Attribute<*>>): DocumentAccess =
            DocumentAccess(
                extractAll(attributes, Types.accessOauthToken),
                extractOne(attributes, Types.accessOauthUri),
                extractOne(attributes, Types.accessPassword)?.value,
                extractOne(attributes, Types.accessPin)?.value,
                extractOne(attributes, Types.accessUserName)?.value
            )
    }
}
