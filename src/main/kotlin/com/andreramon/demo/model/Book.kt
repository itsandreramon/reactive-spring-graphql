package com.andreramon.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("books")
data class Book(
  @Id val id: Int,
  val name: String?,
  val pageCount: Int?,
  val authorId: Int?
)