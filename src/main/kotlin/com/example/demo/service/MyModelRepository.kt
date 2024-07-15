package com.example.demo.service

import com.example.demo.model.MyModel
import org.springframework.data.jpa.repository.JpaRepository

interface MyModelRepository : JpaRepository<MyModel, Long> {
}