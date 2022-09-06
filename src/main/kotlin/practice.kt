data class Grocery (val name: String, val category: String,
                    val unit: String, val unitPrice: Double,
                    val quantity: Int)

fun main(){
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "lb", 3.0,3),
        Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2)
        )
    // numbers and strings have a natural order, and it's that why could be sorted with min and max functions
    // however, you can use minBy and maxBy functions
    // both of functions can take one parameter - a lambda

    val highestUnitPrice = groceries.maxBy { it.unitPrice }
    val lovestQuantity = groceries.minBy { i:Grocery -> i.quantity } //same code
    // { i.item_type -> criteria } == { it.criteria }

    // minBy and maxBy work with collections that hold any type of object, making them much flexible than min and max
    // if you call minBy or maxBy on a specific collection, return type will match collections type
    // if a collection contains no items, the function will return a null value

    // sumBy and sumByDouble
    // sumBy adds Ints together, and returns an Int
    // sumByDouble are identical to sumBY, but works with Doubles
    // now sumBy and sumByDouble are deprecated, and sumOf in use for any purpose

    val sumQuantity = groceries.sumOf {x: Grocery -> x.quantity}
    // { it. quantity }
    println(sumQuantity)
    val totalPrice = groceries.sumOf { it.quantity * it.unitPrice }
    println(totalPrice)

    // you can't use sumOf directly on a Map
    // however, you can use this fun on a Map's keys, values and entries

    val r1 = 101
    val r2 = 202
    val r3 = 303
    val myMap: MutableMap<String, Int> = mutableMapOf("First" to r1, "Second" to r2, "Third" to r3)

    println(myMap.values.sumOf { it })

    // filter function
    // for most connections, filter returns a List that includes all the items that match your criteria
    // however, for Map, filter returns a Map

    val vegetables = groceries.filter {it.category == "Vegetable"}
    val vegetables2 = groceries.filter {x:Grocery -> x.category == "Vegetable"}
    println(vegetables)
    println(vegetables2)
    val unitPriceOver3 = groceries.filter { it.unitPrice > 3 }
    println(unitPriceOver3)
    // filterTo function, filterIsInstance function, filterNot function

    val notFrozen = groceries.filterNot { it.category == "Frozen" }
    println(notFrozen)
    val notFrozen2 = groceries.filter { it.category !== "Frozen" }
    println(notFrozen2)

    // a map function takes the items in a collection and transforms each one according to some formula that you specify
    // despite on it's name, map function returns List

    val ints = listOf(1,2,3,4,5)
    val doubleInts = ints.map { it * 2}
    println(doubleInts)
    val groceryNames = groceries.map {it.name}
    println(groceryNames)

    // chain function calls
    val newPrices = groceries.filter{ it.unitPrice > 3.0}
        .map {it.unitPrice * 2}
    println(newPrices)

    // forEach function

    for (x in groceries){ //using for loop
        println(x.name)
    }
    groceries.forEach { println(it.name) } // and an equivalent using forEach

    // you can use forEach with arrays, Lists, Sets, and on a Map's entries, keys and values properties

    for (x in groceries){
        if (x.unitPrice > 3.0) println(x.name)
    }

    groceries.filter { it.unitPrice > 3.0 }
        .forEach { println(it.name) }

    // both lines of code are equivalent

    // forEach has no return value

    var itemNames = ""
    for (x in groceries){
        itemNames += "${x.name} "
    }
    println("itemNames: $itemNames")

    var itemNames2 = ""
    groceries.forEach { itemNames2 += "${it.name} " }
    println("itemNames: $itemNames2")

    //lambda's closure is the variables which the lambda can access
    //"lambda can access its closure"
    // closure means that a lambda can access any local variables that it captures

    // groupBy
    // this fun lets you group items in your collection according to some criteria
    // groupBy returns a Map
    val groupBy = groceries.groupBy { it.category }
    println(groupBy.keys)
    println(groupBy.values)
    val v1 = groupBy.values.toList()
    println(v1[0])
    // groupBy uses the criteria for the keys and each associated value is a List of items from the original collection

    val v2 = groceries.groupBy { it.category }. forEach(){
        println(it.key)
        it.value.forEach {
            println(" ${it.name} costs ${it.unitPrice} $")
        }
    }

    //fold function
    // you can specify an initial value, and perform some operation on it for each item in a collection
    val ints2: List<Int> = listOf(1,2,3,4,5)
    val sumOfInts = ints.fold(0) /* the initial value*/ {x,y -> x + y}
    // x gets its type from the initial value that you specify (in this example - Int)
    // y gets its type from collection type (in this example - Int)
    println(sumOfInts)
    val multiply = ints.fold(1) {x,y -> x * y}
    println(multiply)
    val testGrocery = groceries.fold("") {x, y -> x + " ${y.name}"}
    println(testGrocery)
    val testFold = groceries.fold(50.0) {x, y
        -> x - y.unitPrice * y.quantity }
    println(testFold)
    // when you use the fold function, you must specify the initial value
    // it is a mandatory, and can't be omitted

    //reduce function
    val testReduce = ints.reduce() {x, y -> x + y}
    println(testReduce)

    // fold and reduce functions work through items in a collection from left to right
    // if you want to reverse this order, you can use the foldRight and reduceRight funcrions





}