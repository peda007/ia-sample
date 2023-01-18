package com.example.iasample.member.domain.ra

import com.example.iasample.member.domain.MemberDetail
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("RA")
class RaMemberDetail(

    private val customerCompanyName: String,

    id: Long = 0L
) : MemberDetail(id) {

    companion object {
        fun create(customerCompanyName: String?): RaMemberDetail {
            require(!customerCompanyName.isNullOrBlank())
            return RaMemberDetail(customerCompanyName)
        }
    }

    override fun isDomainEqual(domain: String): Boolean {
        return domain == "RA"
    }
}