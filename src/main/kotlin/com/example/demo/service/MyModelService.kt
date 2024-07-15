package com.example.demo.service

import com.example.demo.model.MyModel
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class MyModelService (
    val myModelRepository: MyModelRepository
) {

    fun save(myModel: MyModel): MyModel
        = myModelRepository.save(myModel)

    fun findAll(): List<MyModel>
        = myModelRepository.findAll()

    fun findById(id: Long): MyModel?
        = myModelRepository.findById(id).getOrNull()
}