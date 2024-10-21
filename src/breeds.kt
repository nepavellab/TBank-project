package breeds

import animals.*

data class Husky(
    override var weight: Double,
    override var age: UInt) : Dog {
	override val biteType: DogBiteType = DogBiteType.DIRECT
}

data class Corgi(
    override var weight: Double,
    override var age: UInt) : Dog {
	override val biteType: DogBiteType = DogBiteType.OVER
}

data class ScottishCat(
    override var weight: Double,
    override var age: UInt) : Cat {
	override val behaviorType: CatBehaviorType = CatBehaviorType.ACTIVE
}

data class SiameseCat(
    override var weight: Double,
    override var age: UInt) : Cat {
	override val behaviorType: CatBehaviorType = CatBehaviorType.PASSIVE
}
