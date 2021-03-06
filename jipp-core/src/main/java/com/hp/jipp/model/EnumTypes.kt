// Copyright 2018 HP Development Company, L.P.
// SPDX-License-Identifier: MIT
//
// DO NOT MODIFY. Code is auto-generated by genTypes.py. Content taken from registry at
// https://www.iana.org/assignments/ipp-registrations/ipp-registrations.xml, updated on 2019-05-28
@file:Suppress("MaxLineLength")

package com.hp.jipp.model

import com.hp.jipp.encoding.Enum
import com.hp.jipp.encoding.EnumType
import com.hp.jipp.encoding.IppPacket

/**
 * All known [Enum] types, used for better decoding of [IppPacket] data.
 */
object EnumTypes {
    @JvmField val all: Map<String, EnumType<out Enum>> = listOf(
        DestinationStatuses.Types.transmissionStatus,
        MediaCol.MediaSourceProperties.Types.mediaSourceFeedOrientation,
        InputAttributes.Types.inputOrientationRequested,
        MediaColReady.MediaSourceProperties.Types.mediaSourceFeedOrientation,
        MediaColDatabase.MediaSourceProperties.Types.mediaSourceFeedOrientation,
        Types.inputOrientationRequestedSupported,
        Types.orientationRequested,
        Types.orientationRequestedActual,
        Types.orientationRequestedDefault,
        Types.orientationRequestedSupported,
        Types.operationsSupported,
        Types.printerState,
        InputAttributes.Types.inputQuality,
        Types.inputQualitySupported,
        Types.printQuality,
        Types.printQualityActual,
        Types.printQualityDefault,
        Types.printQualitySupported,
        Types.fetchStatusCode,
        Types.notifyStatusCode,
        Types.documentState,
        Types.outputDeviceDocumentState,
        Types.jobState,
        Types.outputDeviceJobState,
        Types.outputDeviceJobStates,
        Types.finishings,
        Types.finishingsActual,
        Types.finishingsDefault,
        Types.finishingsReady,
        Types.finishingsSupported
    ).map { it.name to it }.toMap()
}
