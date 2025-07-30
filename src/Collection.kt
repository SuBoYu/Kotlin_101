fun main() {
    // List
    val readOnlyShapes = listOf("tri", "squa", "cir")
    println(readOnlyShapes)

    val shapes: MutableList<String> = mutableListOf("tri", "squa", "cir")
    println(shapes)

    // Casting
    val shapesLocked: List<String> = shapes

    println(shapesLocked[0])
    println(shapesLocked.first())
    println(shapesLocked.last())
    println(shapesLocked.count())
    println("cir" in shapesLocked)

    shapes.add("pet")
    println(shapes)
    shapes.remove("pet")
    println(shapes)
    shapes[0] = "this"

    // Set
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println(readOnlyFruit)
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    println(fruit)

    // Casting
    val fruitedLocked: Set<String> = fruit
    println(fruitedLocked.count())
    print("banana" in readOnlyFruit)
    fruit.add("dragonfruit")
    println(fruit)

    fruit.remove("dragonfruit")
    println(fruit)

    // Map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu)

    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 190)
    println(juiceMenu)

    // Casting
    val juiceMenuLocked: Map<String, Int> = juiceMenu
    println(juiceMenuLocked["apple"])
    println(juiceMenuLocked["k"])

    juiceMenu["coco"] = 150
    println(juiceMenu)
    juiceMenu.remove("apple")
    println(juiceMenu)
    println(juiceMenu.count())
    println(juiceMenuLocked.containsKey("coco"))
    println(juiceMenu.keys)
    println(juiceMenu.values)
    println("coco" in juiceMenu)
    println(150 in juiceMenu.values)
}