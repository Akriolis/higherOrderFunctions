data class Pizza (val name: String, val pricePerSlice: Double, val quantity: Int)

fun main(){
    val ints = listOf(1,2,3,4,5)

    val pizzas = listOf(
        Pizza("Sunny Chicken", 4.5, 4),
        Pizza("Goat and Nut", 4.0, 1),
        Pizza("Tropical", 3.0,2),
        Pizza("The Garden", 3.5, 3)
    )

    val minInt = ints.min()
    val minInt2 = ints.minBy { int: Int -> int }
    println(minInt2)
    val sumInts = ints.sum()

    val sumInts2 = ints.sumOf { it }
    println("$sumInts2 and $sumInts")

    val lowPrice = pizzas.minBy { it.pricePerSlice }
    println(lowPrice) // to reach it price type lowPrice.pricePerSlice
    val highQuantity = pizzas.maxBy { x: Pizza -> x.quantity }
    val highQuantity2 = pizzas.maxBy { it.quantity }
    val totalPrice = pizzas.sumOf { it.pricePerSlice * it.quantity }
    println(totalPrice)

}