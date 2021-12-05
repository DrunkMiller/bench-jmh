package ru.sber


import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import org.openjdk.jmh.annotations.*
import ru.sber.model.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class JsonSerialization {
    @Benchmark
    fun jsonSimpleSerialization(): String = Json.encodeToString(simpleModel)

    @Benchmark
    fun jsonStringSerialization(): String = Json.encodeToString(stringModel)

    @Benchmark
    fun jsonArraySerialization(): String = Json.encodeToString(arrayModel)

    @Benchmark
    fun jsonMapSerialization(): String = Json.encodeToString(mapModel)

    @Benchmark
    fun jsonInheritSerialization(): String = Json.encodeToString(inheritModel)

    @Benchmark
    fun jsonNestedJSerialization(): String = Json.encodeToString(nestedModel)
}