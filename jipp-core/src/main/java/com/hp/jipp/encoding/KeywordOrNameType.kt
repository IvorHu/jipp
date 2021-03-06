// Copyright 2017 HP Development Company, L.P.
// SPDX-License-Identifier: MIT

package com.hp.jipp.encoding

/**
 * An attribute type for `name` or `keyword` values.
 *
 * See [RFC8011 Section 5.1.3](https://tools.ietf.org/html/rfc8011#section-5.1.3).
 */
class KeywordOrNameType(override val name: String) : AttributeType<KeywordOrName> {

    override fun coerce(value: Any): KeywordOrName? =
        when (value) {
            is KeywordOrName -> value
            is Name -> KeywordOrName(value)
            is String -> KeywordOrName(value)
            else -> null
        }

    /**
     * A form of this [AttributeType] that represents all incoming Name and Keyword data as [String] objects.
     */
    val asString: AttributeType<String> by lazy {
        object : AttributeType<String> {
            override val name = this@KeywordOrNameType.name

            override fun coerce(value: Any): String? =
                when (value) {
                    is KeywordOrName -> value.keyword ?: value.name?.value
                    is Name -> value.value
                    is String -> value
                    else -> null
                }
        }
    }

    /** Return an attribute containing values as keywords .*/
    fun of(vararg keywords: String) = of(keywords.map { KeywordOrName(it) })

    /** Return an attribute containing values as keywords. */
    fun of(vararg names: Name) = of(names.map { KeywordOrName(it) })

    /** Return an attribute containing values interpreted as keywords. */
    fun ofKeywords(values: Iterable<String>) = of(values.map { KeywordOrName(Name(it)) })

    /** Return an attribute containing values as text strings (without language). */
    fun ofNames(values: Iterable<String>) = of(values.map { KeywordOrName(Name(it)) })

    override fun toString() = "KeywordOrNameType($name)"

    companion object {
        val codec = Codec<KeywordOrName>({ false }, {
            throw IllegalArgumentException("This codec is not used for reading")
        }, {
            if (NameType.codec.handlesTag(it.tag)) {
                NameType.codec.writeValue(this, it.name!!)
            } else {
                KeywordType.codec.writeValue(this, it.keyword!!)
            }
        })
    }
}
