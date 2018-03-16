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
import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions
import org.springframework.stereotype.Repository
import java.util.HashMap

/**
 * Implementation class for the CMS DAO - Abstraction layer between the application and the CMS.
 */
@Repository("cmsDao")
open class CMSDataAccessObjectImpl(sessionFactoryCms: SessionFactory) : AbstractCMSDataAccessObject(sessionFactoryCms), CMSDataAccessObject {

    private var classType: Class<Selectable>? = null

    private val enumType: Class<out Enum<*>>? = null

    override fun getAllTextContents(language: String): Map<String, String> {
        val map = HashMap<String, String>()
        val criteria = getSession().createCriteria(classType!!.name)
        val list = criteria.list()
        for (cid in list) map[classType!!.cast(cid).cid] = classType!!.cast(cid).getText(language)
        return map
    }

    override fun findTextByContentId(id: String, language: String): String {
        val criteria = getSession().createCriteria(classType!!.name)
        criteria.add(Restrictions.eq("cnt_id", id))
        val o = criteria.uniqueResult()
        return if (o != null) {
            classType!!.cast(o).getText(language)
        } else {
            "Error trying to access DB using " + classType!!.name + " as a model"
        }
    }

    override fun setClassType(classType: Class<*>) {
        this.classType = classType as Class<Selectable>
    }
}
