package kz.request.demo.infastructure.repositories

import kz.request.demo.core.entities.Application
import kz.request.demo.core.entities.KazakhPhoneNumber
import kz.request.demo.core.repositories.ApplicationRepository
import kz.request.demo.infastructure.models.ApplicationDb
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityManager
import kotlin.streams.toList


open class ApplicationRepositoryImpl : ApplicationRepository {


    @Autowired
    lateinit  var em: EntityManager


    @Transactional
    override fun save(application: Application): Application {
        val result = em.merge(mapToAppDb(application, create = true))
        application.bId = result.bId
        return application
    }

    @Transactional
    override fun update(application: Application): Application {
        em.merge(mapToAppDb(application))
        return application
    }

    @Transactional
    override fun delete(id: Long): Application {
        val found = this.em.find(ApplicationDb::class.java , id)
        em.remove(found)
        return mapToApp(found)
    }

    override fun findById(id: Long): Application {
        val result = em.find(ApplicationDb::class.java , id)
        return mapToApp(result)
    }

    override fun findAll(): List<Application> {
        val result =  em.createQuery("findAll", ApplicationDb::class.java).resultList
        return result.stream().map { mapToApp(it) }.toList()
    }

    override fun findDuplicate(application: Application): Application? {
        val query = em.createNamedQuery("findDuplicate", ApplicationDb::class.java)
        query.setParameter("phone", application.phone.phoneNumber)
        query.setParameter("org", application.org)
        query.setParameter("name", application.fullName)
        val result = query.resultList
        return if (!result.isEmpty()) mapToApp(result[0]) else null
    }



    private fun mapToApp(appDb: ApplicationDb): Application {
        with(appDb) {
            return Application(bId, KazakhPhoneNumber(phone), fullName, org)
        }
    }

    private fun mapToAppDb(app: Application, create: Boolean = false): ApplicationDb {
        with(app) {
            return ApplicationDb(if (create) 0 else bId , phone.phoneNumber, org, abbr, fullName)
        }
    }
}