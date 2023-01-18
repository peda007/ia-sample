package com.example.iasample.member.domain

import com.example.iasample.member.domain.ra.RaMemberDetail
import com.example.iasample.member.domain.value.Authorities
import com.example.iasample.member.domain.value.MemberDetails
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(

    val email: String,

    private val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) {

    @Embedded
    private val memberDetails: MemberDetails = MemberDetails()

    @Embedded
    private val authorities: Authorities = Authorities()

    private var enabled: Boolean = true

    companion object {
        fun ofRa(
            email: String?,
            password: String?,
            raMemberDetail: RaMemberDetail?
        ): Member {
            require(!email.isNullOrBlank()
                    && !password.isNullOrBlank()
                    && raMemberDetail != null)
            val member = Member(email, password)
            member.addRaMemberDetail(raMemberDetail)
            member.addRaDefaultAuthority()
            return member
        }
    }

    private fun addRaMemberDetail(raMemberDetail: RaMemberDetail) {
        this.memberDetails.addMemberDetail(raMemberDetail)
    }

    private fun addRaDefaultAuthority() {
        this.authorities.addAuthority(Authority("RA_DEFAULT", this))
    }

}