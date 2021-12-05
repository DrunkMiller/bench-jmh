package ru.sber


import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.openjdk.jmh.annotations.*
import ru.sber.model.*
import java.util.concurrent.TimeUnit.SECONDS

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class JsonDeserialization {

    private val simpleSerialized = Json.encodeToString(simpleModel)

    private val stringSerialized = Json.encodeToString(stringModel)

    private val arraySerialized = Json.encodeToString(arrayModel)

    private val mapSerialized = Json.encodeToString(mapModel)

    private val inheritSerialized = Json.encodeToString(inheritModel)

    private val nestedSerialized = Json.encodeToString(nestedModel)

    @Benchmark
    fun jsonSimpleDeserialization(): SimpleModel = Json.decodeFromString(simpleSerialized)

    @Benchmark
    fun jsonStringDeserialization(): StringModel = Json.decodeFromString(stringSerialized)

    @Benchmark
    fun jsonArrayDeserialization(): ArrayModel = Json.decodeFromString(arraySerialized)

    @Benchmark
    fun jsonMapDeserialization(): MapModel = Json.decodeFromString(mapSerialized)

    @Benchmark
    fun jsonInheritDeserialization(): InheritModel = Json.decodeFromString(inheritSerialized)

    @Benchmark
    fun jsonNestedDeserialization(): NestedModel = Json.decodeFromString(nestedSerialized)
}