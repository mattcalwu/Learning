class KotlinClasses {
    fun example(){

        println()
        println("--- Start of Kotlin Classes Examples ---")
        class Customer

        /**
         * Note that I am able to change the value of the email
         * because I defined it as var
         * That means I cannot reassign id
         */
        class Contact(val id: Int, var email: String) {
            /**
             * The default toString function doesn't return much information
             * I defined a toString function here to visualize this object
             * Also Data Type Classes provide that for free
             */
            override fun toString(): String {
                return """
                    Contact { id: ${this.id}, email: ${this.email} }
                """.trimIndent()
            }
        }

        data class Consumer(val name: String, val age: Int)

        val customer = Customer()
        val contact = Contact(1, "mary@gmail.com")
        val consumer = Consumer("John", 12)
        val consumer2 = Consumer("John", 12)

        println("Customer: $customer")
        println("Contact: ${contact}")

        println("Contact.id: ${contact.id}")
        contact.email = "jane@gmail.com"
        println("Contact.email: ${contact.email}")

        println("This is what a Data class will print: $consumer")
        println("Data classes also have hashes: ${consumer.hashCode()}")
        println("Destructuring works too: (name, age) = consumer2")

        println("--- End of Kotlin Classes Examples ---")
    }
}