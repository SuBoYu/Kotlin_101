import javax.print.DocFlavor

fun printObjectType(obj: Any) {
    when (obj) {
        is Int -> println("It's an Integer")
        !is Double -> println("It's NOT a Double")
        else -> println("It's something else")
    }
}

fun calculateTotalStringLength(items: List<Any>): Int {
    return items.sumOf { (it as? String)?.length ?: 0 }
}

data class UserY(val name: String?, val age: Int?)

fun main() {
    val myInt = 42
    val myDouble = 42.5
    val myList = listOf("tony", "123", 3)

    printObjectType(myInt)

    printObjectType(myList)

    printObjectType(myDouble)

    val a: String? = null
    val b = a as? String
    println(b)

    println(calculateTotalStringLength(myList))

    val emails: List<String?> = listOf("123", null)

    val validemails = emails.filterNotNull()

    println(validemails)

    val serverConfig = mapOf(
        "app" to "APP",
        "db" to "DB"
    )

    val requestedFile = "app"
    val configFiles = listOfNotNull(serverConfig[requestedFile])
    println(configFiles)

    val temp = listOf(1, 2, 3, 4)

    val maxTemp = temp.maxOrNull()

    println("${maxTemp ?: "No Data"}")

    val singleHotDay = temp.singleOrNull { it > 30 }
    println("${singleHotDay ?: "No Data"}")

    val users = listOf (
        UserY(null, 12),
        UserY("Steve", 15),
        UserY("John", null)
    )

    val firstNonNullName = users.firstNotNullOfOrNull { it.name }
    println(firstNonNullName)

    val itemPricess = listOf(1, 2, 3, 4, 5)

    val totalPrice = itemPricess.reduceOrNull { runningTotal, itemPrice -> runningTotal + itemPrice}
    println("${totalPrice ?: "No Data"}")

    val emptyCart = listOf<Int>()
    val emptyTotalPrice = emptyCart.reduceOrNull { runningTotal, itemPrice -> runningTotal + itemPrice}

    println("${emptyTotalPrice ?: "No Data"}")



}