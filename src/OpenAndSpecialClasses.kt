interface EcoFriendly {
    val emissionLevel: String
}

interface ElectricVehicle {
    val batteryCapacity: Double
}

open class Vehicle(val make: String, val model: String) {
    open fun displayInfo() {
        println("Vehicle: $make $model")
    }
}

open class Car(make: String, model: String, val numberofDoors: Int): Vehicle(make, model) {
    override fun displayInfo() {
        println("Car: $make $model with $numberofDoors doors")
    }
}

class ElectricCar(
    make: String,
    model: String,
    numberofDoors: Int,
    val capacity: Double,
    val emission: String
) : Car(make, model, numberofDoors), EcoFriendly, ElectricVehicle {
    override val emissionLevel: String = emission
    override val batteryCapacity: Double = capacity
}

sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
    }
}

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

@JvmInline
value class Email(val address: String)

fun sendEmail(email: Email) {
    println("Sending email to ${email.address}")
}

fun main () {

    val car1 = Car("Ford", "Mustang", 5)
    car1.displayInfo()

    val ecoCar1 = ElectricCar("Tesla", "ModelS", 4, 25.0, "Normal")
    ecoCar1.displayInfo()
    println("This ${ecoCar1.emissionLevel} car emits ${ecoCar1.emissionLevel} gCO2/km")

    println(greetMammal(Cat("Snowy")))

    val state = State.RUNNING
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }

    println(message)

    val red = Color.RED
    println(red)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(Color.GREEN.containsRed())

    val myEmail = Email("zhps5001246@gmail.com")
    sendEmail(myEmail)
    println(myEmail)


}