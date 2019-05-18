package kz.request.demo

import kz.request.demo.core.repositories.ApplicationRepository
import kz.request.demo.infastructure.repositories.ApplicationRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun getApplicationRepository(): ApplicationRepository = ApplicationRepositoryImpl()

//    @Bean
//    fun getCreateService(): CreateService = CreateService()
}