package ru.sber.model

import kotlinx.serialization.Serializable

@Serializable
class SimpleModel(
    val double: Double,
    val integer: Int,
    val boolean: Boolean
)