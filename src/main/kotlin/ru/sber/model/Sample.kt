package ru.sber.model

val simpleModel get() = SimpleModel(12.34, 56, true)

val stringModel get() = StringModel("123456789qwerty")

val arrayModel get() = ArrayModel(listOf(1, 2, 3, 4, 5))

val mapModel get() = MapModel(mapOf(1 to 1.1, 2 to 2.2, 3 to 3.3, 4 to 4.4, 5 to 5.5))

val inheritModel get() = InheritModel(12L, 12.43f, 56.789, false)

val nestedModel get() = NestedModel(21L, 77.11f,  Nested(77.323, true))