data class Grocery3 (val name: String, val category: String,
                    val unit: String, val unitPrice: Double,
                    val quantity: Int)

fun main() {
    val groceries = listOf(
        Grocery3("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery3("Mushrooms", "Vegetable", "lb", 4.0, 1),
        Grocery3("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery3("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery3("Ice cream", "Frozen", "Pack", 3.0, 2)
    )

    val sumOfVegetables = groceries.filter {it.category == "Vegetable"}.sumOf { it.unitPrice * it.quantity}
    println(sumOfVegetables)
    val lessThanFive = groceries.filter { it.unitPrice < 5.0 }.map { println("${it.name}")}
    println(lessThanFive)
    val totalCost = groceries.groupBy { it.category }.forEach {
        println("${it.key}: ${it.value.sumOf { it.unitPrice * it.quantity }}")
    }
    println(totalCost)
    val notBottle = groceries.filterNot {
        it.unit == "Bottle"
    }.groupBy {
        it.unit
    }.forEach {
        println(it.key)
        it.value.forEach { println(" $it.name") }
    }
    println(notBottle)
    
}