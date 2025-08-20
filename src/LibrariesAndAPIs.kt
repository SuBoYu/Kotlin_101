import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

fun main() {
    val text = "emosewa si niltoK"
    val reversedText = text.reversed()
    println(reversedText)

    val thirtyMinutes: Duration = 30.minutes
    val halfHours: Duration = 0.5.hours
    print(thirtyMinutes == halfHours)
}