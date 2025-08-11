import java.net.http.HttpResponse


fun String.bold(): String = "<b>$this</b>"

class HttpClient {
    fun request(method: String, url: String, headers: Map<String, String>): String {
        println("Requesting $method to $url with headers: $headers")
        return "Response from $url"
    }
}

fun HttpClient.get(url: String): String = request("GET", url, emptyMap())


fun main() {
    println("hello".bold())

    // Extension-oriented design
    val client = HttpClient()

    // Making a GET request using request() directly
    val getResponseWithMember = client.request("GET", "https://example.com", emptyMap())

    // Making a GET request using the get() extension function
    val getResponseWithExtension = client.get("https://example.com")
}