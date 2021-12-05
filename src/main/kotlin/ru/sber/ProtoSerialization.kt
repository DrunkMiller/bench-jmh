package ru.sber

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit.SECONDS

@ExperimentalSerializationApi
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class ProtoSerialization {
    @Benchmark
    fun protoSimpleSerialization() = ProtoBuf.encodeToByteArray(simpleModel)

    @Benchmark
    fun protoStringSerialization() = ProtoBuf.encodeToByteArray(stringModel)

    @Benchmark
    fun protoArraySerialization() = ProtoBuf.encodeToByteArray(arrayModel)

    @Benchmark
    fun protoMapSerialization() = ProtoBuf.encodeToByteArray(mapModel)

    @Benchmark
    fun protoInheritSerialization() = ProtoBuf.encodeToByteArray(inheritModel)

    @Benchmark
    fun protoNestedJSerialization() = ProtoBuf.encodeToByteArray(nestedModel)
}