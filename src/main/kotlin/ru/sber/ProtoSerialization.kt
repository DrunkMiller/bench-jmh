package ru.sber

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import org.openjdk.jmh.annotations.*
import ru.sber.model.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

@ExperimentalSerializationApi
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = SECONDS)
class ProtoSerialization {
    @Benchmark
    fun protoSimpleSerialization(): ByteArray = ProtoBuf.encodeToByteArray(simpleModel)

    @Benchmark
    fun protoStringSerialization(): ByteArray = ProtoBuf.encodeToByteArray(stringModel)

    @Benchmark
    fun protoArraySerialization(): ByteArray = ProtoBuf.encodeToByteArray(arrayModel)

    @Benchmark
    fun protoMapSerialization(): ByteArray = ProtoBuf.encodeToByteArray(mapModel)

    @Benchmark
    fun protoInheritSerialization(): ByteArray = ProtoBuf.encodeToByteArray(inheritModel)

    @Benchmark
    fun protoNestedJSerialization(): ByteArray = ProtoBuf.encodeToByteArray(nestedModel)
}


//
//
//@State(Scope.Benchmark)
//fun protoSimpleSerialization(): ByteArray = ProtoBuf.encodeToByteArray(simpleModel)
//
//fun protoStringSerialization(): ByteArray = ProtoBuf.encodeToByteArray(stringModel)
//
//fun protoArraySerialization(): ByteArray = ProtoBuf.encodeToByteArray(arrayModel)
//
//fun protoMapSerialization(): ByteArray = ProtoBuf.encodeToByteArray(mapModel)
//
//fun protoInheritSerialization(): ByteArray = ProtoBuf.encodeToByteArray(inheritModel)
//
//fun protoNestedJSerialization(): ByteArray = ProtoBuf.encodeToByteArray(nestedModel)
//
//fun main() {
//    println(jsonSimpleSerialization())
//    println(jsonStringSerialization())
//    println(jsonArraySerialization())
//    println(jsonMapSerialization())
//    println(jsonInheritSerialization())
//    println(jsonNestedJSerialization())
//
//    println()
//    println()
//
//    println(protoSimpleSerialization().toList())
//    println(protoStringSerialization().toList())
//    println(protoArraySerialization().toList())
//    println(protoMapSerialization().toList())
//    println(protoInheritSerialization().toList())
//    println(protoNestedJSerialization().toList())
//}