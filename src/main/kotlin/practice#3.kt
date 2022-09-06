abstract class Pet(var name: String)

class Cat (name: String): Pet(name)

class Dog (name: String): Pet(name)

class Fish (name: String): Pet(name)

class Contest <T: Pet>(){
    var scores: MutableMap<T, Int> = mutableMapOf()

    fun addScore (t: T, score: Int = 0){
        if (score >= 0) scores.put(t, score)
    }

    fun getWinners(): Set<T>{
        val highScore = scores.maxBy { it.value } // scores.values.max
        val winners = scores.filter {it == highScore}.keys // it.value
        winners.forEach { println ("Winner: ${it.name}") }
        return winners
    }

}

fun main(){

    val cat = Cat("Bibi")
    val dog = Dog("Auf")
    val fish = Fish ("Smokey Big Bill")
    val petContest: Contest<Pet> = Contest()
    petContest.addScore(cat, 50)
    petContest.addScore(dog,53)
    petContest.addScore(fish, 150)
    petContest.getWinners()
}