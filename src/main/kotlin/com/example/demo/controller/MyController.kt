package com.example.demo.controller

import com.example.demo.dto.SaveMyModelRequest
import com.example.demo.dto.UpdateMyModelRequest
import com.example.demo.model.MyModel
import com.example.demo.service.MyModelService
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.web.bind.annotation.*

@RestController
class MyController(
    val MyModelService: MyModelService,
    private val myModelService: MyModelService,
) {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }

    @PostMapping("/my-model")
    fun saveMyModel(
        @RequestBody
        request: SaveMyModelRequest,
    ): MyModel {
        return MyModelService.save(
            MyModel(
                name = request.name
            )
        )
    }

    @GetMapping("/my-models")
    fun listMyModels(): List<MyModel>
        = MyModelService.findAll();

    @PatchMapping("/my-model/{id}")
    fun updateMyModel(
        @PathVariable id: Long,
        @RequestBody request: UpdateMyModelRequest
    ): MyModel {
        val myModel: MyModel = myModelService.findById(id) ?: throw NotFoundException()

        myModel.name = request.name

        return myModelService.save(myModel)
    }
}