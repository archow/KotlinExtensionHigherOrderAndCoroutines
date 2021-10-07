package com.example.kotlinextensionhigherorderandcoroutines

import kotlinx.coroutines.*

//let's say I have a void function that does something to the result
//of the two ints; how would I define it here?
//i'll probably take in one more argument: a function type arg
fun sum(a: Int, b: Int,
        someFunction: (a1: Int, b1: Int) -> Unit
) {
    someFunction(a, b)
}

//the purpose of this function (that we're making)
//is to take some method and perform it inside a coroutine
fun myCoroutine(
    someFunction: () -> Unit
) {
    //let's create launch a coroutine to do our function in
    CoroutineScope(Dispatchers.IO).launch {
        while (isActive) {
            delay(1000L)
            someFunction()
        }
    }
}