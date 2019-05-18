package kz.request.demo.infastructure.models

import javax.persistence.*

@Entity
@Table(name = "applications")
@NamedQueries(
        NamedQuery(name = "findDuplicate", query = "SELECT a FROM ApplicationDb a " +
                "WHERE a.phone = :phone and a.fullName = :name and a.org = :org"),
        NamedQuery(name = "findAll", query = "SELECT a FROM  ApplicationDb a")
        )
open class ApplicationDb(

        @Id
        @GeneratedValue
        @Column(name = "id")
        open var bId: Long = 0,
        open var phone: String = "",
        open var org: String = "",
        open var abbr: String = "",
        @Column(name = "full_name")
        open var fullName: String = ""
)