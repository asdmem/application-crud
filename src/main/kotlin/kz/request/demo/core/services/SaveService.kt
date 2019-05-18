package kz.request.demo.core.services

import kz.request.demo.core.entities.Application
import kz.request.demo.core.exceptions.DuplicateApplicationException
import kz.request.demo.core.repositories.ApplicationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class SaveService {

    @Autowired
    lateinit var applicationRepository: ApplicationRepository

    /**
     * @param application application to save
     * Save application to database and check for duplicates
     * if duplicate found throw
     * @throws DuplicateApplicationException
     * @return saved application with bId set from database
     */
    fun save(application: Application): Application {
        val duplicate = applicationRepository.findDuplicate(application)
        if (duplicate != null ) throw DuplicateApplicationException("Найден дубликат")
        return applicationRepository.save(application)
    }
}
