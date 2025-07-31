fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int) = x + y

fun main() {
    // Function called with both parameters
    val k = printMessageWithPrefix("Hello", "Log")
    // [Log] Hello
    println(k)

    // Function called only with message parameter
    printMessageWithPrefix("Hello")
    // [Info] Hello

    printMessageWithPrefix(prefix = "Log", message = "Hello")
    // [Log] Hello

    // concise fun
    println(sum(1, 2))

    // lambda fun
    val upperCaseString: (String) -> String = { text: String -> text.uppercase() }
    println(upperCaseString("hello"))

    val nums = listOf(1, -2, 3, -4, 5, -6)

    var positive = nums.filter({x -> x > 0})
    val isNegative = {x: Int -> x < 0}
    val negative = nums.filter(isNegative)
    println(positive)
    println(negative)

    positive = nums.filter{x -> x > 0}
    println(positive)

    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val doubled = numbers.map { x -> x * 2 }

    val isTripled = { x: Int -> x * 3 }
    val tripled = numbers.map(isTripled)

    println(doubled)
    println(tripled)

    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> { value -> value * 60 * 60 }
        "minute" -> { value -> value * 60 }
        "second" -> { value -> value }
        else -> { value -> value }
    }

    val timesInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")

    println({ text: String -> text.uppercase() }("hello"))

    // The initial value is zero.
    // The operation sums the initial value with every item in the list cumulatively.
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 6

    // Alternatively, in the form of a trailing lambda
    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })  // 6
}