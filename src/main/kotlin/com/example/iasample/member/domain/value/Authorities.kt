package com.example.iasample.member.domain.value

import com.example.iasample.member.domain.Authority
import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.OneToMany

@Embeddable
class Authorities(

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    private val authorities: MutableList<Authority> = mutableListOf()
) {

    fun addAuthority(authority: Authority) {
        if (authorities.contains(authority)) {
            throw RuntimeException()
        }
        authorities.add(authority)
    }
}