package com.example.faircorp.model

enum class Status { OPEN, CLOSED}

data class WindowDto(var id: Long, var name: String, var windowStatus: Status, var roomName: String, var roomId: Long)