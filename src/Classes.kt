class Contact(val id: Int, var email: String) {
    fun printId() {
        println(id)
    }
}

data class User(val name: String, val id: Int)

fun main () {
    val contact = Contact(1, "mary@gmail.com")

    println(contact.email)

    contact.email = "jane@gmail.com"

    println(contact.email)

    contact.printId()

    val user = User("Alex", 1)
    val secondUser = User("Alex" , 1)
    println(user)
    println(user == secondUser)
}