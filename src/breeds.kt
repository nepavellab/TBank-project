package breeds

import animals.*

data class Husky(
    override var weight: Double,
    override var age: UInt, 
    override val biteType: Dog.BiteType) : Dog {}

data class Corgi(
    override var weight: Double,
    override var age: UInt,
    override val biteType: Dog.BiteType) : Dog {}

data class ScottishCat(
    override var weight: Double,
    override var age: UInt,
    override val behaviorType: Cat.BehaviorType) : Cat {}

data class SiameseCat(
    override var weight: Double,
    override var age: UInt,
    override val behaviorType: Cat.BehaviorType) : Cat {}