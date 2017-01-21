package com.lucasbais.tinyandroidapp.executors;

import java.util.concurrent.Executor;

import rx.Scheduler;

public interface IThreadExecutor extends Executor {
    Scheduler getScheduler();
}
