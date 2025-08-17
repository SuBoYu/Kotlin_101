import kotlin.properties.Delegates.observable

//backing fields
class Person {
    var name: String = ""
        set(value) {
            field = value.replaceFirstChar {firstChar -> firstChar.uppercaseChar()}
        }
}

//extension properties
data class Per(val firstName: String, val lastName: String)

val Per.fullName: String
    get() = "$firstName $lastName"

//delegated properties
class CachedStringDelegate {
    var cachedValue: String? = null

    operator fun getValue(thisRef: UserX, property:Any?): String {
        if (cachedValue == null) {
            cachedValue = "${thisRef.firstName} ${thisRef.lastName}"
            println("Computed and cached: $cachedValue")
        } else {
            println("Accessed from cache: $cachedValue")
        }
        return cachedValue ?: "Unknown"
    }
}

class UserX(val firstName: String, val lastName: String) {
    val displayName: String by CachedStringDelegate()
}

//standard delegates
//lazy properties

class Database {
    fun connect() {
        println("Connected to database")
    }
    fun query(sql: String): List<String> {
        return listOf("Data1", "Data2")
    }
}

val databaseConnection: Database by lazy {
    val db = Database()
    db.connect()
    db
}

fun fetchData() {
    val data = databaseConnection.query("SELECT * FROM users")
    println("Data: $data")
}

//observable properties
class Thermostat{
    var temperature: Double by observable(20.0) { _, old, new ->
        if (new > 25) {
            println("Warning: Temperature is too high! ($old°C -> $new°C)")
        } else {
            println("Temperature updated: $old°C -> $new°C")
        }
    }
}

fun main() {
    val peron = Person()
    peron.name = "john"
    println(peron.name)

    val per = Per("John", "Doe")
    println(per.fullName)

    val user = UserX("John", "Doe")
    println(user.displayName)
    println(user.displayName)

    fetchData()
    fetchData()

    val thermostat = Thermostat()
    thermostat.temperature = 22.5
    thermostat.temperature = 27.0
}