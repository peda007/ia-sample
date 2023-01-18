package com.example.iasample.member.domain.rfind

import com.example.iasample.member.domain.Member
import com.example.iasample.member.domain.MemberDetail
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@DiscriminatorValue("RFIND")
class RfindMemberDetail(


    @ManyToOne
    @JoinColumn(name = "member_detail_id")
    private val member: Member,

    id: Long = 0L
) : MemberDetail(id) {

    override fun isDomainEqual(domain: String): Boolean {
        return domain == "RFIND"
    }
}