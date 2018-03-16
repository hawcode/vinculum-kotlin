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

package com.hawcode.vinculum.service

import com.hawcode.vinculum.dao.CMSDataAccessObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Service to retrieve the information from the CMS.
 *
 * Makes use of the DAO as abstraction layer.
 */
@Service("cmsService")
@Transactional("transactionManagerCms")
open class CMSService (private val dao: CMSDataAccessObject) {

    fun setClassType(type: Class<*>) {
        this.dao.setClassType(type)
    }

    fun findTextByContentId(id: String, language: String): String {
        return dao.findTextByContentId(id, language)
    }

    fun getAllTextContents(language: String): Map<String, String> {
        return dao.getAllTextContents(language)
    }
}
