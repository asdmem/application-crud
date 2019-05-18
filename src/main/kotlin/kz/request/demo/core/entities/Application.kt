package kz.request.demo.core.entities

import java.util.stream.Collectors

class Application(
        var bId: Long,
        var phone: KazakhPhoneNumber,
        var fullName: String,
        _org: String) {


    var abbr: String = ""
        private set

    var org: String = _org
        get() = field
        set(value) {
            field = value
                this.abbr = value.split(" ").stream().map {s -> s.substring(0, 1)}.collect((Collectors.joining()))
        }

    init {
        this.org = _org
    }

}