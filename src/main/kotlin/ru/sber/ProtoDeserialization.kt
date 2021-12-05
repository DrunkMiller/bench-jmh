package ru.sber

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.openjdk.jmh.annotations.*
import ru.sber.model.*
import java.util.concurrent.TimeUnit.SECONDS

@ExperimentalSerializationApi
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class ProtoDeserialization {

    private val simpleSerialized = ProtoBuf.encodeToByteArray(simpleModel)

    private val stringSerialized = ProtoBuf.encodeToByteArray(stringModel)

    private val arraySerialized = ProtoBuf.encodeToByteArray(arrayModel)

    private val mapSerialized = ProtoBuf.encodeToByteArray(mapModel)

    private val inheritSerialized = ProtoBuf.encodeToByteArray(inheritModel)

    private val nestedSerialized = ProtoBuf.encodeToByteArray(nestedModel)

    @Benchmark
    fun protoSimpleDeserialization(): SimpleModel = ProtoBuf.decodeFromByteArray(simpleSerialized)

    @Benchmark
    fun protoStringDeserialization(): StringModel = ProtoBuf.decodeFromByteArray(stringSerialized)

    @Benchmark
    fun protoArrayDeserialization(): ArrayModel = ProtoBuf.decodeFromByteArray(arraySerialized)

    @Benchmark
    fun protoMapDeserialization(): MapModel = ProtoBuf.decodeFromByteArray(mapSerialized)

    @Benchmark
    fun protoInheritDeserialization(): InheritModel = ProtoBuf.decodeFromByteArray(inheritSerialized)

    @Benchmark
    fun protoNestedDeserialization(): NestedModel = ProtoBuf.decodeFromByteArray(nestedSerialized)
}