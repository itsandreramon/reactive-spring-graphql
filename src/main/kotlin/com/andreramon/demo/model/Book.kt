package com.andreramon.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("books")
data class Book(
    @Id
    val id: Int,

    @Column("name")
    val name: String?,

    @Column("authorid")
    val authorId: Int?
)
