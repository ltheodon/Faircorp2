package com.example.faircorp.model

data class RoomDto(
    var id: Long,
    var name: String,
    var currentTemperature: Double?,
    var targetTemperature: Double?,
    var floor: Int
                   )