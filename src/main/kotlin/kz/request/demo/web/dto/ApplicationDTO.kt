package kz.request.demo.web.dto

import kz.request.demo.core.entities.Application
import kz.request.demo.core.entities.KazakhPhoneNumber

class ApplicationDTO(
        var bId: Long,
        var phone: String,
        var fullName: String,
        var org: String,
        var abbr: String = "") {

    companion object {

            fun mapToDTO(application: Application): ApplicationDTO {
                with (application) {
                    return ApplicationDTO(bId, phone.phoneNumber , fullName, org, abbr)
                }
            }

            fun mapToApplicatiion(applicationDTO: ApplicationDTO): Application {
                with(applicationDTO) {
                    return Application(bId, KazakhPhoneNumber(phone), fullName, org)
                }
            }
    }
}