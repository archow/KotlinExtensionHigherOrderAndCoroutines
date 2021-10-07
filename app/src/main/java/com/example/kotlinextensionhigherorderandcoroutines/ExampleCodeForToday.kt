package com.example.kotlinextensionhigherorderandcoroutines

fun main() {
    val kotlin = "🙂"
    println(kotlin)

    difference(8, 9, {
            someNumber1: Int, someNumber2: Int ->
        println("Difference between the the two numbers: ${someNumber1 - someNumber2}")
    })

    difference {
            someNumber1: Int, someNumber2: Int ->
        println("Difference between the the two numbers: ${someNumber1 - someNumber2}")
    }

    val exampleProduct = returnTypeExample(2, {
            number: Int ->
        number * 3
    })

    println(exampleProduct)
}

fun difference(a: Int = 7, b: Int = 6,
               exampleFunction: (someNumber1: Int, someNumber2: Int) -> Unit
) {
    exampleFunction(a, b)
}

fun returnTypeExample(x: Int,
                      anonymousFunction: (x1: Int) -> Int
): Int {
    return anonymousFunction(x)
}