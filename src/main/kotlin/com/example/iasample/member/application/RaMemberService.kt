package com.example.iasample.member.application

import com.example.iasample.member.domain.MemberRepository
import com.example.iasample.member.domain.dto.response.SignUpResponseDto
import com.example.iasample.member.domain.ra.dto.request.RaSignUpRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RaMemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun getRaMembers() {

    }

    @Transactional
    fun raSignUp(raSignUpRequestDto: RaSignUpRequestDto): SignUpResponseDto {
        val newMember = raSignUpRequestDto.toMember()
        val member = memberRepository.findByEmail(newMember.email)
            ?: memberRepository.save(newMember)
        return SignUpResponseDto(member.id)
    }

}