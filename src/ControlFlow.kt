fun main() {
    // if
    val d: Int
    val check = true

    if (check) {
        d = 1
    } else {
        d = 2
    }
    println(d)

    val a = 1
    val b = 2
    println(if (a > b) a else b)

    // when
    val obj = "Hello"

    when (obj) {
        "1" -> println("One")
        "Hello" -> println("Hello")
        else -> println("Unknown")
    }

    val result = when (obj) {
        "1" -> "One"
        "Hello" -> "Hello"
        else -> "Unknown"
    }

    println(result)


    // for

    for (num in 1..5) {
        println(num)
    }

    val lans = listOf("Java", "Kotlin")
    for (lan in lans) {
        println(lan)
    }

    // while
    var Eaten = 0
    while (Eaten < 3) {
        println(Eaten)
        Eaten++
    }

    Eaten = 0
    do {
        println(Eaten)
        Eaten++
    } while (Eaten < 3)

}