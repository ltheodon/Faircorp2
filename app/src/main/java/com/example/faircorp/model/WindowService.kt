package com.example.faircorp.model

class WindowService {

    companion object {
        // Fake rooms
        val ROOMS: List<RoomDto> = listOf(
            RoomDto(1, "Room EF 6.10", 18.2, 20.0),
            RoomDto(2, "Hall", 18.2, 18.0),
            RoomDto(3, "Room EF 7.10", 21.2, 20.0)
        )

        // Fake lights
        val WINDOWS: List<WindowDto> = listOf(
            WindowDto(1, "Entry Window", Status.CLOSED, "Room EF 6.10", 1),
            WindowDto(2, "Back Window", Status.CLOSED, "Room EF 6.10", 1),
            WindowDto(3, "Sliding door", Status.OPEN, "Hall", 2),
            WindowDto(4, "Window 1", Status.CLOSED, "Room EF 7.10", 3),
            WindowDto(5, "Window 2", Status.CLOSED, "Room EF 7.10", 3),
        )
    }

    fun findById(id: Long) = WINDOWS.firstOrNull { it.id == id}

    fun findAll() = WINDOWS.sortedBy { it.name }
}