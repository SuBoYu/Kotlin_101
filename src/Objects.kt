object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

data object AppConfig {
    var appName: String = "Kotlin App"
    var version: String = "1.0.0"
}

class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            repeat(nTimes) { print("BONG ")}
        }
    }
}

fun main () {
    DoAuth.takeParams("coding_ninja", "123123123")

    println(AppConfig)
    println(AppConfig.appName)

    BigBen.getBongs(12)
}