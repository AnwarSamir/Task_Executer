package com.anwar.task_executer.di

import com.anwar.task_executer.queue.QueueExecutor
import com.anwar.task_executer.queue.QueueExecutorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class KExecutorModule {

    @Binds
    abstract fun bindQueueExecutor(executor: QueueExecutorImpl): QueueExecutor


}
