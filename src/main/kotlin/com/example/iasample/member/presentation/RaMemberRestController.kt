package com.example.iasample.member.presentation

import com.example.iasample.member.application.RaMemberService
import com.example.iasample.member.domain.dto.response.SignUpResponseDto
import com.example.iasample.member.domain.ra.dto.request.RaSignUpRequestDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/ra/members")
class RaMemberRestController(
    private val raMemberService: RaMemberService
) {

    @PostMapping
    fun raSignUp(@RequestBody raSignUpRequestDto: RaSignUpRequestDto): ResponseEntity<SignUpResponseDto> {
        return ResponseEntity.ok(raMemberService.raSignUp(raSignUpRequestDto))
    }

    @GetMapping
    fun getRaMembers() {
        
    }

}