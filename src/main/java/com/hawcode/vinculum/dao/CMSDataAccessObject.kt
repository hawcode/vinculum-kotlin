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

package com.hawcode.vinculum.dao

import com.hawcode.vinculum.utils.Selectable

/**
 * Interface for the CMS DAO - Abstraction layer between the application and the CMS.
 */
interface CMSDataAccessObject {

    /**
     * Set the class type of the Entity that is going to be used for doing the query.
     * @param classType Class type of the Entity defined by the developer.
     */
    fun setClassType(classType: Class<*>)

    /**
     * Search for the corresponding text of the given ID and the given language.
     * @param id The content ID.
     * @param language The content language.
     * @return The corresponding text given the parameters.
     */
    fun findTextByContentId(id: String, language: String): String

    /**
     * Search for the all corresponding texts of the whole table for a specific language.
     * @param language The content language.
     * @return Associative array with texts. The selector is the content ID.
     */
    fun getAllTextContents(language: String): Map<String, String>
}
