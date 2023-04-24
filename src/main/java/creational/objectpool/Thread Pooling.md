## Thread Pooling
This example demonstrates how to create a thread pool using the Object Pool design pattern. The `ThreadPool` class is responsible for managing a pool of threads. It has a constructor that takes the pool size and work queue size as parameters.

The `execute()` method is used to submit a task to the thread pool. It puts the task into the work queue. The worker threads in the thread pool continuously take tasks from the work queue and execute them. The `shutdown()` method is used to interrupt the worker threads and terminate the thread pool.
```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private BlockingQueue<Runnable> workQueue;
    private Thread[] workerThreads;

    public ThreadPool(int poolSize, int workQueueSize) {
        workQueue = new LinkedBlockingQueue<>(workQueueSize);
        workerThreads = new Thread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            workerThreads[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = workQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            workerThreads[i].start();
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        workQueue.put(task);
    }

    public void shutdown() {
        for (Thread workerThread : workerThreads) {
            workerThread.interrupt();
        }
    }

}
```