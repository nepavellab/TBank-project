package animals

interface Animal {
    var weight: Double
    var age: UInt
}

enum class CatBehaviorType {
	ACTIVE, // активное поведение
	PASSIVE // пассивное поведение
}

interface Cat : Animal {
    val behaviorType: CatBehaviorType
}

enum class DogBiteType {
	DIRECT, // прямой прикус
	OVER, // перекус
	UNDER // недокус
}

interface Dog : Animal {	
    val biteType: DogBiteType
}
