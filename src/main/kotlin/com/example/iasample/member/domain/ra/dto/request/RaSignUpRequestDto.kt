package com.example.iasample.member.domain.ra.dto.request

import com.example.iasample.member.domain.Member
import com.example.iasample.member.domain.ra.RaMemberDetail

data class RaSignUpRequestDto(
    val email: String?,
    val password: String?,
    val customerCompanyName: String?,
) {

    fun toMember(): Member {
        return Member.ofRa(email, password, RaMemberDetail.create(customerCompanyName))
    }
}