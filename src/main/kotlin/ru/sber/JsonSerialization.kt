package ru.sber


import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit.SECONDS

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class JsonSerialization {
    @Benchmark
    fun jsonSimpleSerialization() = Json.encodeToString(simpleModel)

    @Benchmark
    fun jsonStringSerialization() = Json.encodeToString(stringModel)

    @Benchmark
    fun jsonArraySerialization() = Json.encodeToString(arrayModel)

    @Benchmark
    fun jsonMapSerialization() = Json.encodeToString(mapModel)

    @Benchmark
    fun jsonInheritSerialization() = Json.encodeToString(inheritModel)

    @Benchmark
    fun jsonNestedJSerialization() = Json.encodeToString(nestedModel)
}