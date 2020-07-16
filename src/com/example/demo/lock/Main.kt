package com.example.demo.lock

import java.util.concurrent.Executors

fun main(args: Array<String>) {
    println("Hello Example!")
    val loader = SearchLoader()
    val executor = Executors.newFixedThreadPool(5)

    for (i in 0..100) {
        executor.submit { loader.fetchNextPage() }
        Thread.sleep(5)
    }

    println("Goodbye Example!")
    executor.shutdownNow()
}