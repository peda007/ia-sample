package com.example.iasample.member.domain.rwith

import com.example.iasample.member.domain.Member
import com.example.iasample.member.domain.MemberDetail
import java.time.LocalDate
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@DiscriminatorValue("RWITH")
class RwithMemberDetail(

    private var phone: String,

    private val birth: LocalDate,

    @ManyToOne
    @JoinColumn(name = "member_detail_id")
    private val member: Member,

    id: Long = 0L
) : MemberDetail(id) {

    override fun isDomainEqual(domain: String): Boolean {
        return domain == "RWITH"
    }
}