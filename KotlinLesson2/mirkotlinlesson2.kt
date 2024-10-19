// Done by: Fouzan Ahmed Mir

import java.util.*    // Required import for Random class

fun main(args: Array<String>) {
    // Simple println statements
    println("Hello, world!")
    println("-----------------")

    // Will assign kotlin.Unit, since println() returns Unit
    val isUnit = println("This is an expression")
    println(isUnit)   // Prints "kotlin.Unit"
    println("-----------------")

    // If-else statement to determine if the temperature is hot
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)   // Will print "false"
    
    // Using if-else inside string interpolation
    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)  // Prints temperature message
    println("-----------------")

    // Call functions that demonstrate fish feeding and water change
    feedTheFish()
    println("-----------------")
    feedTheFish1()
    println("-----------------")
    feedTheFish2()
    println("-----------------")
    feedTheFish3()
    println("-----------------")
    feedTheFish4()
    println("-----------------")

    // Calling swim function with different arguments
    swim()   // Default argument
    println("-----------------")
    swim("slow")   // Positional argument
    println("-----------------")
    swim(speed="turtle-like")   // Named argument
    println("-----------------")

    // Filtering the decorations list for elements that start with 'p'
    println(decorations.filter {it[0] == 'p'})
    println("-----------------")

    // Eager filtering: creates a new list immediately
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")   // Prints eagerly filtered list
    println("-----------------")

    // Lazy filtering: evaluation will be delayed until required
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")   // Will print filtered sequence
    println("-----------------")

    // Force evaluation of lazy list by converting it to a list
    val newList = filtered.toList()
    println("new list: $newList")   // Prints the evaluated list
    println("-----------------")

    // Lazy map operation with sequence
    val lazyMap = decorations.asSequence().map {
        println("access: $it")   // Prints each element as it is accessed
        it
    }
    println("lazy: $lazyMap")   // Lazy sequence not yet evaluated
    println("-----------------")
    println("first: ${lazyMap.first()}")   // Access the first element
    println("-----------------")
    println("all: ${lazyMap.toList()}")   // Evaluate all elements
    println("-----------------")

    // Filter and map using sequences
    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")   // Prints when elements are accessed
        it
    }
    println("filtered: ${lazyMap2.toList()}")   // Evaluates and prints the filtered list
    println("-----------------")

    // Demonstrating flattening a list of lists
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // List of lists
    println("Flat: ${mylist.flatten()}")   // Flattens the list of lists
    println("-----------------")

    // Lambda expressions and higher-order functions
    var dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(dirtyLevel))   // Applies the lambda function to dirtyLevel
    println("-----------------")

    val waterFilter1: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter1(dirtyLevel))   // Same lambda with explicit type declaration
    println("-----------------")

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter2))   // Passes lambda to updateDirty function
    println("-----------------")

    // Using function reference with updateDirty
    fun increaseDirty(start: Int) = start + 1
    println(updateDirty(15, ::increaseDirty))   // Passes function reference
    println("-----------------")

    // Updating dirtyLevel using lambda in updateDirty
    var dirtyLevel1 = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel1 + 23 }
    println(dirtyLevel)   // Prints the updated dirtyLevel
    println("-----End-of-Code-----")
}

// Randomly selects a day of the week
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]   // Returns a random day
}

// Returns food based on the day
fun fishFood(day : String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

// Directly returns the result of when expression
fun fishFood1(day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

// Simple function demonstrating feeding fish
fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println ("Today is $day and the fish eat $food")
}

// Using fishFood function to decide food
fun feedTheFish1() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
}

// Using fishFood1 function
fun feedTheFish2() {
    val day = randomDay()
    val food = fishFood1(day)
    println ("Today is $day and the fish eat $food")
}

// Swim function with default and named parameters
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

// Function to determine if water should be changed
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    }
}

// Feeds fish and checks if water needs to be changed
fun feedTheFish3() {
    val day = randomDay()
    val food = fishFood1(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

// Helper functions for water change conditions
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

// Same function with helper functions for cleaner code
fun shouldChangeWater1(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

// Feeds fish and checks if water should be changed using helper functions
fun feedTheFish4() {
    val day = randomDay()
    val food = fishFood1(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater1(day)}")
}

// List of decorations for filtering demonstration
val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

// Higher-order function to update the dirty level
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
