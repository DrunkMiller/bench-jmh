package ru.sber.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("owned")
class InheritModel(
    val long: Long,
    val float: Float,
    override val double: Double,
    override val boolean: Boolean,
) : Inherited()

@Serializable
sealed class Inherited {
    abstract val double: Double
    abstract val boolean: Boolean
}