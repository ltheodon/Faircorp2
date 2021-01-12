package com.example.faircorp.model

import retrofit2.Call
import retrofit2.http.*

interface RoomApiService {
    @GET("rooms")
    fun findAll(): Call<List<RoomDto>>

    @GET("rooms/{id}")
    fun findById(@Path("id") id: Long): Call<RoomDto>

    @PUT("rooms/{id}")
    fun updateRoom(@Path("id") id: Long, @Body Room: RoomDto): Call<RoomDto>
}