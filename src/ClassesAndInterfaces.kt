abstract class Product(val name: String, var price: Double) {
    abstract val category: String

    fun productInfo(): String {
        return "Product: $name, Price: $$price, Category: $category"
    }
}

class Electronics(name: String, price: Double, val warranty: Int) : Product(name, price) {
    override val category = "Electronics"
}

interface PaymentMethod {
    fun initiatePayment(amount: Double): String
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(val cardNumber: String, val cardHolderName: String, val expiryDate: String) : PaymentMethod, PaymentType {
    override fun initiatePayment(amount: Double): String {
        return "Payment of $$amount initiated using Credit Card ending in ${cardNumber.takeLast(4)}."
    }

    override val paymentType: String = "Credit Card"
}

interface Drawable {
    fun draw()
    fun resize()
    val color: String?
}

class Circle: Drawable {
    override fun draw() {
        println("Drawing a circle")
    }
    override fun resize() {
        println("Resizing a circle")
    }
    override val color = null
}

class RedCircle(val circle: Circle): Drawable by circle {
    override val color = "Red"
}

fun main() {
    val Laptoop = Electronics("Laptop", 2500.0, 12)
    println(Laptoop.productInfo())

    val paymentMethod = CreditCardPayment("1234567890", "Tony", "12/25")
    println(paymentMethod.initiatePayment(2500.0))
    println("Payment is by ${paymentMethod.paymentType}")

    val redCircle = RedCircle(Circle())
    redCircle.draw()
    redCircle.resize()
    println(redCircle.color)
}