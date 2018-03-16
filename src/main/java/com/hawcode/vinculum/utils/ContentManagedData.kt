/*
 * ************************************************************************
 *
 *  Copyright (c) 2018. Hawcode - Diseño Atómico SL
 *
 *  This file is subject to the terms and conditions defined in
 *  file 'LICENSE.txt', which is part of this source code package.
 *
 * ************************************************************************
 */

package com.hawcode.vinculum.utils

import com.hawcode.vinculum.service.CMSService
import java.util.HashMap

/**
 *
 * This class contains the all the resources needed for rendering a view
 */
class ContentManagedData (cmsService: CMSService, EntityType: Class<*>?, language: String) {

    var map: Map<String, String> = HashMap()

    init {
        if (EntityType != null) {
            cmsService.setClassType(EntityType)
        }
        map = cmsService.getAllTextContents(language)
    }

    fun getMappedContent(id: String): String? {
        return map[id]
    }
}