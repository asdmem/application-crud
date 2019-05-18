package kz.request.demo.core.repositories

import kz.request.demo.core.entities.Application

interface ApplicationRepository {

    fun save(application: Application): Application
    fun update(application: Application): Application
    fun delete(id: Long): Application
    fun findById(id: Long): Application
    fun findAll(): List<Application>
    fun findDuplicate(application: Application): Application?
}