import java.sql.SQLOutput

class KotlinGenerics {

    /**
     * This class below is an example of a custom data structure that
     * accepts any value. Once it's assigned a value, i.e. an int, then
     * it becomes a MutableStack<Int>
     * @param items: E - E is the generic type parameter
     * Also, elsewhere you may see "T", for type, used
     * Or "?", T and E are interchangeable, while ? refers to the type being set
     * elsewhere
     *
     * E: Element
     * T: Type
     * ?: Wildcard
     * Refer to this stack overflow link:
     * https://stackoverflow.com/questions/6008241/what-is-the-difference-between-e-t-and-for-java-generics
     */
    class MutableStack<E>(vararg items: E) {

        private val elements = items.toMutableList()
        // Here we see that E can be used as a parameter like any other type
        fun push(element: E) = elements.add(element)

        // Here we see E can be also used as a return type
        fun peek(): E = elements.last()
        fun pop(): E = elements.removeAt(elements.size - 1)
        fun isEmpty() = elements.isEmpty()
        fun size() = elements.size
        override fun toString() = "MutableStack(${elements.joinToString()})"
    }

    /**
     * This is a generic function
     * This can either infer what type you provide it, or take a value when you call it
     */
    fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

    fun example() {
        println("--- Start of Kotlin Generics Examples ---")
        val stack = this.mutableStackOf(1,23, 4, 5)
        println("Stack: $stack")
        stack.push(7)
        println("Stack after pushing 7: $stack")
        println("Peeking: ${stack.peek()}")
        println("Popping: ${stack.pop()}")
        println("Stack after popping: $stack")
        println("Stack.isEmpty(): ${stack.isEmpty()}")
        println("Stack.size(): ${stack.size()}")

        val stringStack = mutableStackOf("1", "2", "3")
        println("stringStack: $stringStack")
        println("stringStack type: ${stringStack::class.simpleName}")

        // You can explicitly type the arguments
        val doubleStack = mutableStackOf<Double>(1.1, 2.2, 3.3)
        println("DoubleStack: $doubleStack")
        // The two ways to check the type
        // 1. <var>::class.qualifiedName
        // 2. <var>::class.simpleName
        // Since above is simplified, maybe you can say <var>.qualifiedName?
        // Nope you cannot
        println("DoubleStack type: ${doubleStack::class.qualifiedName}")
        println("--- End of Kotlin Generics Examples ---")
    }
}