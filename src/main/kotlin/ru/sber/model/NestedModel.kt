package ru.sber.model

import kotlinx.serialization.Serializable

@Serializable
class NestedModel(
    val long: Long,
    val float: Float,
    val nested: Nested
)

@Serializable
class Nested(val double: Double, val boolean: Boolean)