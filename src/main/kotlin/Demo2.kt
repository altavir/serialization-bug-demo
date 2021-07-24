import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json

interface Recursive<T : Recursive<T>>

object RecursiveSerializer : KSerializer<Recursive<*>> {
    override fun deserialize(decoder: Decoder): Recursive<*> {
        TODO("Not yet implemented")
    }

    override val descriptor: SerialDescriptor
        get() = TODO("Not yet implemented")

    override fun serialize(encoder: Encoder, value: Recursive<*>) {
        TODO("Not yet implemented")
    }
}

@Serializable
class Demo2(
    @Serializable(RecursiveSerializer::class)
    val r: Recursive<*>
)

fun main() {
    val string = Json.encodeToString(Demo2.serializer(), Demo2())
    val reconstructed = Json.decodeFromString(Demo2.serializer(),string)
}