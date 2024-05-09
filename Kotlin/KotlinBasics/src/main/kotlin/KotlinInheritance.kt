class KotlinInheritance {

    /**
     * The Open keyword marks the class inheritable
     * It also marks functions are overridable
     */
    open class Dog {
        open fun sayHello() = println("wow wow!")
    }

    /**
     * Kotlin's classes are final by default
     * This class inherits dog since it's specified as the superclass
     * Inheritance is done by the type reference after
     * : SuperclassName() - Empty means empty superclass constructor
     */
    class Yorkshire: Dog() {
        override fun sayHello() = println("wif wif!")
    }


    /**
     * This is an example of inheritance with a parametrized
     * constructor
     */
    open class Tiger(val origin: String) {
        fun sayHello() = println("A tiger from $origin says: grrhhh!")
    }

    class SiberianTiger: Tiger("Siberia")

    /**
     * This is an example of passing constructor arguments
     */
    open class Lion(val name: String, val origin: String) {
        fun sayHello() = println("$name, the lion from $origin says: graoh!")
    }

    /**
     * Note that name is neither val nor var
     * It's a constructor argument, whose value is passed to the name property of the superclass Lion
     */
    class Asiatic(name: String): Lion(name = name, origin = "India")
    fun example()  {
        println("--- Start of Kotlin Inheritance Examples ---")
        val dog: Dog = Yorkshire()
        dog.sayHello()
        Dog().sayHello() // Instantiates a dog and then calls a function

        val tiger: Tiger = SiberianTiger() // Example of polymorphism
        tiger.sayHello()

        val siberianTiger: SiberianTiger = SiberianTiger()
        siberianTiger.sayHello()

        val lion: Lion = Asiatic("Rufo")
        lion.sayHello()

        println("--- End of Kotlin Inheritance Examples ---")
    }



}