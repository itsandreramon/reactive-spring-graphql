package com.andreramon.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("authors")
data class Author(
    @Id
    val id: Int,

    @Column("name")
    val name: String?
)
