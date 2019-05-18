package kz.request.demo.core.entities

import kz.request.demo.core.exceptions.PhoneInvalidException

data class KazakhPhoneNumber(val phoneNumber: String) { // value
    init {
        if (phoneNumber.length != 11) {
            throw PhoneInvalidException("Неправильное количество символов")
        }

        // Test only
        val kazakCodes = listOf("7702", "7705", "7707", "7708")

        if (phoneNumber.substring(0, 4) !in kazakCodes)
            throw PhoneInvalidException("Не сотвествуют коду страны")
    }
}