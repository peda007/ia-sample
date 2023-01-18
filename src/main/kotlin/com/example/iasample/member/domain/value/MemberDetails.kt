package com.example.iasample.member.domain.value

import com.example.iasample.member.domain.MemberDetail
import com.example.iasample.member.domain.ra.RaMemberDetail
import com.example.iasample.member.domain.rwith.RwithMemberDetail
import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Embeddable
class MemberDetails(

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "member_detail_id")
    private val memberDetails: MutableList<MemberDetail> = mutableListOf()
) {

    fun addMemberDetail(memberDetail: MemberDetail) {
        memberDetails.add(memberDetail)
    }

    fun getRaMemberDetail(): RaMemberDetail {
        return (memberDetails.find { it.isDomainEqual("RA") } ?: RuntimeException()) as RaMemberDetail
    }

    fun getRwithMemberDetail(): RwithMemberDetail {
        return (memberDetails.find { it.isDomainEqual("RWITH") } ?: RuntimeException()) as RwithMemberDetail
    }
}