class KotlinNullSafety {

    /**
     * This is the main function that I call from this class
     * This example goes over what nullable types are
     */
    fun example() {
        println()
        println("--- Start of Kotlin Null Safety examples ---")
        val neverNull: String = "This variable can never be null"
        println("NeverNull: $neverNull")

        var nullable: String? = "You can keep a null value here"
        nullable = null

        println("Nullable: $nullable")

        val inferredNonNull = null

        fun strLength(notNull: String?): Int? {
            return notNull?.length
        }

        println("Inferred type of inferredNonNull: Nothing?")
        println("StrLength: ${strLength(inferredNonNull)}")

        // Below is playing around with calling this on class functions
        println("DescribeString(Nullable): ${this.describeString(nullable)}")
        println("DescribeString(neverNull): ${describeString(neverNull)}")
        try {
            println("!! means assert non-null: ${nullable!!}")
        } catch (e: Exception) {
            println("Exception thrown for above: $e")
        }
        println("--- End of Kotlin Null Safety examples ---")
    }

    /**
     * Describe string is a private function to NullSafety class
     * It takes a nullable string and prints the length
     * of the string if it's non-null
     */
    private fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null String"
        }
    }
}