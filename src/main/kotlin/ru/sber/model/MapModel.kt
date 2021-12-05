package ru.sber.model

import kotlinx.serialization.Serializable

@Serializable
class MapModel(val map: Map<Int, Double>)