package com.example.demo.lock

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class SearchLoader {

    private val limit = 10
    private var offset = 0
    private var isLoading = false
    private val stateLock = ReentrantLock()

    fun fetchNextPage() {
        //println("Thread = ${Thread.currentThread()} : fetch called")
        stateLock.withLock {
            if (isLoading) {
                //println("Thread = ${Thread.currentThread()} : fetch returned")
                return
            }
            isLoading = true
        }

        println("Thread = ${Thread.currentThread()} : fetch next page : limit = $limit, offset = $offset")

        Thread.sleep(10)

        stateLock.withLock {
            isLoading = false
            offset += 1
        }
    }

}