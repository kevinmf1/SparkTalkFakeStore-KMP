package org.sparktalk.project.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

object DoubleAsNumberSerializer : KSerializer<Double> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DoubleAsNumber", PrimitiveKind.DOUBLE)
    override fun serialize(encoder: Encoder, value: Double) = encoder.encodeDouble(value)
    override fun deserialize(decoder: Decoder): Double {
        return when (val json = decoder as? JsonDecoder) {
            null -> decoder.decodeDouble()
            else -> {
                val element = json.decodeJsonElement()
                when (element) {
                    is JsonPrimitive -> element.doubleOrNull ?: element.intOrNull?.toDouble() ?: error("Invalid number")
                    else -> error("Invalid JSON for Double")
                }
            }
        }
    }
}