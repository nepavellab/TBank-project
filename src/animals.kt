package animals

interface Animal {
    var weight: Double
    var age: UInt
}

interface Cat : Animal {
	enum class BehaviorType {
		ACTIVE, // активное поведение
		PASSIVE // пассивное поведение
	}
	
    val behaviorType: BehaviorType
}

interface Dog : Animal {
	enum class BiteType {
		DIRECT, // прямой прикус
		OVER, // недокус
		UNDER // перекус
	}
	
    val biteType: BiteType
}