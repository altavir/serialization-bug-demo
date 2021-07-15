import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Demo1: Demo()

fun main() {
    val string = Json.encodeToString(Demo1.serializer(), Demo1())
    val reconstructed = Json.decodeFromString(Demo1.serializer(),string)
}