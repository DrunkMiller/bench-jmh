package ru.sber


import kotlinx.serialization.decodeFromString
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
class JsonDeserialization {

    private val simpleSerialized = Json.encodeToString(simpleModel)

    private val stringSerialized = Json.encodeToString(stringModel)

    private val arraySerialized = Json.encodeToString(arrayModel)

    private val mapSerialized = Json.encodeToString(mapModel)

    private val inheritSerialized = Json.encodeToString(inheritModel)

    private val nestedSerialized = Json.encodeToString(nestedModel)

    @Benchmark
    fun jsonSimpleDeserialization(): String = Json.decodeFromString(simpleSerialized)

    @Benchmark
    fun jsonStringDeserialization(): String = Json.encodeToString(stringSerialized)

    @Benchmark
    fun jsonArrayDeserialization(): String = Json.encodeToString(arraySerialized)

    @Benchmark
    fun jsonMapDeserialization(): String = Json.encodeToString(mapSerialized)

    @Benchmark
    fun jsonInheritDeserialization(): String = Json.encodeToString(inheritSerialized)

    @Benchmark
    fun jsonNestedJDeserialization(): String = Json.encodeToString(nestedSerialized)
}