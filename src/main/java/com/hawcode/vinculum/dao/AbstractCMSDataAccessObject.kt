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

import org.hibernate.Session
import org.hibernate.SessionFactory

/**
 * Abstract class for the CMS DAO - Abstraction layer between the application and the CMS.
 */
abstract class AbstractCMSDataAccessObject (private val sessionFactoryCms: SessionFactory) {

    /**
     * Get session method.
     * @return The current session.
     */
    internal fun getSession(): Session {
        return sessionFactoryCms.currentSession
    }

    /**
     * Persist method.
     * @param entity Persistence target.
     */
    fun persist(entity: Any) {
        getSession().persist(entity)
    }

    /**
     * Delete method.
     * @param entity Deletion target.
     */
    fun delete(entity: Any) {
        getSession().delete(entity)
    }
}
