package kz.request.demo.web.controllers

import kz.request.demo.core.repositories.ApplicationRepository
import kz.request.demo.core.services.SaveService
import kz.request.demo.web.dto.ApplicationDTO
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/applications")
class ApplicationController(
        private val aplicationRepository: ApplicationRepository,
        private val saveService: SaveService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable  ("id") id: Long): ApplicationDTO {
        val result = this.aplicationRepository.findById(id)
        return ApplicationDTO.mapToDTO(result)
    }

    @PostMapping("/")
    fun save(@RequestBody applicationDTO: ApplicationDTO): ApplicationDTO {
        applicationDTO.bId = 0
        val result = this.saveService.save(ApplicationDTO.mapToApplicatiion((applicationDTO)))
        return ApplicationDTO.mapToDTO(result)

    }

    @PutMapping("/")
    fun edit(@RequestBody applicationDTO: ApplicationDTO): ApplicationDTO {
        val result = this.aplicationRepository.update(ApplicationDTO.mapToApplicatiion((applicationDTO)))
        return ApplicationDTO.mapToDTO(result)

    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ApplicationDTO {
        val result = this.aplicationRepository.delete(id)
        return ApplicationDTO.mapToDTO(result)

    }

    /**
     * Check for duplicate in database
     */

    @PostMapping("/action/duplicate")
    fun findDuplicate(@RequestBody applicationDTO: ApplicationDTO): ApplicationDTO? {
        val result = this.aplicationRepository.findDuplicate(ApplicationDTO.mapToApplicatiion((applicationDTO)))
        return if (result != null) ApplicationDTO.mapToDTO(result) else null

    }
}