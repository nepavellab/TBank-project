import animals.*
import breeds.*

class ZooStore {
    infix fun determineAnimalTypeOf(breed: Animal) {
        when (breed) {
            is Cat -> println("It is cat!")
            is Dog -> println("It is dog!")
            else -> println("I do not know what kind of animal it is, I am not an Akinator!")
        }
    }
}

fun main() {
    val store = ZooStore()

    // проверка типа животного на примере породы кошки
    val cat = ScottishCat(weight=10.5, age=3U, behaviorType=Cat.BehaviorType.ACTIVE)
    store determineAnimalTypeOf cat
	
    // проверка типа животного на примере породы собаки
    val dog = Corgi(weight=10.5, age=3U, biteType=Dog.BiteType.DIRECT)
    store determineAnimalTypeOf dog
	
    // проверка обработки неизвестного типа животного
    val unknownAnimal = object : Animal {
    	override var weight: Double = 7.5
	override var age: UInt = 2U
    }
	
    store determineAnimalTypeOf unknownAnimal
}
