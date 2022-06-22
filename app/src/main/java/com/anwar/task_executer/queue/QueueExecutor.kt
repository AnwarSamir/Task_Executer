package com.anwar.task_executer.queue


interface QueueExecutor {

    suspend fun <T> enqueue(block: suspend () -> T): T
}
