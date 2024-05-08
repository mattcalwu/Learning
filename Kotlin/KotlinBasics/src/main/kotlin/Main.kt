fun main(args: Array<String>) {
    println("Hello World!")

    val d: Int  // 1

    fun someCondition() = true

    if (someCondition()) {
        d = 1   // 2
    } else {
        d = 2   // 2
    }

    println(d) // 3
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString(" ")}")

    val nullSafety = NullSafety()
    nullSafety.example()
}