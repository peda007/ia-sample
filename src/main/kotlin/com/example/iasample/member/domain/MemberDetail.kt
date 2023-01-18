package com.example.iasample.member.domain

import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "domain", discriminatorType = DiscriminatorType.STRING)
abstract class MemberDetail(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

) {

    abstract fun isDomainEqual(domain: String): Boolean
}