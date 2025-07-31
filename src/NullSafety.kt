import kotlin.properties.Delegates.notNull

fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}

fun main () {
    var neverNull: String = "This can't be null"

//    neverNull = null

    var nullable: String? = "You can keep a null here"
    nullable = null

    println(nullable)

    var inferredNonNull = "Tony"
//    inferredNonNull = null

    fun strLength(notNull: String): Int {
        return notNull.length
    }
    println(strLength(neverNull))
//    println(strLength(nullable))

    val nullString: String? = null
    println(describeString(nullString))

    // safe calls
    println(nullString?.length)
    println(nullString?.uppercase())

    // Elvis operator
    println(nullString?.length ?: 0)
}