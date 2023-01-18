package com.example.iasample.member.domain.rwith.dto.request

import java.time.LocalDate

data class RwithSignUpRequestDto(
    val email: String?,
    val password: String?,
    val phone: String?,
    val birth: LocalDate?
)