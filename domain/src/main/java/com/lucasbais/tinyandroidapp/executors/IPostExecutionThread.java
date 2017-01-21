package com.lucasbais.tinyandroidapp.executors;

import rx.Scheduler;

public interface IPostExecutionThread {
    Scheduler getScheduler();
}
