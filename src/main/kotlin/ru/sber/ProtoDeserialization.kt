package ru.sber

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import kotlinx.serialization.protobuf.ProtoBuf.Default.decodeFromByteArray
import org.openjdk.jmh.annotations.*
import ru.sber.model.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

@ExperimentalSerializationApi
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class ProtoDeserialization {

    private val simpleSerialized = ProtoBuf.encodeToByteArray(simpleModel)

    private val stringSerialized = ProtoBuf.encodeToByteArray(stringModel)

    private val arraySerialized = ProtoBuf.encodeToByteArray(arrayModel)

    private val mapSerialized = ProtoBuf.encodeToByteArray(mapModel)

    private val inheritSerialized = ProtoBuf.encodeToByteArray(inheritModel)

    private val nestedSerialized = ProtoBuf.encodeToByteArray(nestedModel)

    @Benchmark
    fun jsonSimpleDeserialization(): String = ProtoBuf.decodeFromByteArray(simpleSerialized)

    @Benchmark
    fun jsonStringDeserialization(): String = ProtoBuf.decodeFromByteArray(stringSerialized)

    @Benchmark
    fun jsonArrayDeserialization(): String = ProtoBuf.decodeFromByteArray(arraySerialized)

    @Benchmark
    fun jsonMapDeserialization(): String = ProtoBuf.decodeFromByteArray(mapSerialized)

    @Benchmark
    fun jsonInheritDeserialization(): String = ProtoBuf.decodeFromByteArray(inheritSerialized)

    @Benchmark
    fun jsonNestedJDeserialization(): String = ProtoBuf.decodeFromByteArray(nestedSerialized)
}