### MultiThreadingDemo.java Code Explanation

This Java program, `MultiThreadingDemo.java`, is designed to illustrate fundamental multithreading concepts using a classic Producer-Consumer pattern. It showcases how multiple threads can work concurrently, safely share resources, and communicate with each other.

Here's a breakdown of its components and the multithreading principles they demonstrate:

### 1. `SharedResource` Class

This class acts as a buffer or a common data area that both the producer and consumer threads interact with.

*   **`message`**: A `String` variable to hold the data being passed between threads.
*   **`empty`**: A `boolean` flag indicating whether the `message` buffer is empty (`true`) or contains data (`false`).
*   **`take()` method (Consumer's role)**:
    *   `public synchronized String take()`: The `synchronized` keyword ensures that only one thread can execute this method at a time, preventing race conditions when accessing `message` and `empty`.
    *   `while (empty)`: If the buffer is empty, the consumer thread enters a `while` loop and calls `wait()`.
    *   `wait()`: This method, called on the `SharedResource` object, causes the current thread (the consumer) to release the lock on `SharedResource` and go into a waiting state. It will remain in this state until another thread calls `notify()` or `notifyAll()` on the same `SharedResource` object.
    *   `notifyAll()`: After consuming a message, the consumer calls `notifyAll()` to wake up any waiting threads (in this case, potentially the producer, indicating the buffer is now empty).
*   **`put()` method (Producer's role)**:
    *   `public synchronized void put(String message)`: Similar to `take()`, `synchronized` ensures exclusive access.
    *   `while (!empty)`: If the buffer is not empty (i.e., it contains a message), the producer thread calls `wait()`.
    *   `wait()`: The producer releases the lock and waits until the consumer has taken the message and called `notify()`/`notifyAll()`.
    *   `notifyAll()`: After putting a message, the producer calls `notifyAll()` to wake up any waiting threads (the consumer, indicating a message is available).

**Concepts Demonstrated**:
*   **Shared Resource**: `SharedResource` is the common object accessed by multiple threads.
*   **Synchronization**: The `synchronized` keyword is crucial for ensuring thread safety and preventing data corruption when multiple threads try to modify `message` and `empty` simultaneously.
*   **Inter-thread Communication**: `wait()` and `notifyAll()` are used for coordinated communication between the producer and consumer. The threads effectively "talk" to each other, pausing when necessary and resuming when conditions are met.

### 2. `ProducerThread` Class

This class represents a thread that produces data and puts it into the `SharedResource`.

*   **`extends Thread`**: This is one of the two primary ways to create a thread in Java. By extending the `Thread` class, `ProducerThread` itself becomes a thread.
*   **`run()` method**: This method contains the code that the thread will execute.
    *   It iterates through a predefined array of `messages`.
    *   For each message, it calls `resource.put(msg)` to place the message into the shared buffer.
    *   `Thread.sleep(1000)`: This method pauses the execution of the `ProducerThread` for 1000 milliseconds (1 second). This simulates some work being done by the producer and allows the consumer to process messages at a visible pace.

**Concepts Demonstrated**:
*   **Thread Creation (Extending `Thread`)**: Shows how to define a thread by subclassing `java.lang.Thread`.
*   **Thread Control (`sleep()`)**: Demonstrates how to temporarily pause a thread's execution.

### 3. `ConsumerRunnable` Class

This class represents a thread that consumes data from the `SharedResource`.

*   **`implements Runnable`**: This is the second primary way to create a thread in Java. By implementing the `Runnable` interface, `ConsumerRunnable` defines the task that a `Thread` object will execute.
*   **`run()` method**:
    *   It continuously calls `resource.take()` to retrieve messages from the shared buffer.
    *   The loop continues until it receives the special "Finished" message, signaling the end of production.
    *   `Thread.sleep(1000)`: Similar to the producer, this pauses the `ConsumerRunnable` for 1 second, simulating work.

**Concepts Demonstrated**:
*   **Thread Creation (Implementing `Runnable`)**: Shows how to define a thread's task by implementing `java.lang.Runnable`. This is generally preferred over extending `Thread` as it allows your class to extend other classes.
*   **Thread Control (`sleep()`)**: Again, demonstrates pausing a thread.

### 4. `MultiThreadingDemo` Class (Main Program)

This is the entry point of the application, where the threads are created and managed.

*   **`main()` method**:
    *   `SharedResource sharedResource = new SharedResource();`: An instance of the shared buffer is created.
    *   `ProducerThread producerThread = new ProducerThread(sharedResource);`: The producer thread is instantiated.
    *   `Thread consumerThread = new Thread(consumerRunnable);`: The consumer thread is created by passing a `ConsumerRunnable` instance to a new `Thread` object.
    *   `producerThread.start();` and `consumerThread.start();`: These methods initiate the execution of the `run()` methods of the respective threads in parallel. The operating system's thread scheduler determines when each thread gets CPU time.
    *   `producerThread.join();` and `consumerThread.join();`: The `join()` method makes the `main` thread wait until the specified thread (producer or consumer) completes its execution. This ensures that the "Main thread finished" message is printed only after both the producer and consumer have finished their tasks.

**Concepts Demonstrated**:
*   **Concurrency**: By calling `start()` on both threads, they begin executing concurrently.
*   **Thread Management (`start()`, `join()`)**: Shows how to initiate and wait for the completion of threads.

### Overall Impact and Behavior

When you run this program, you will observe:

*   **Interleaved Output**: The print statements from the producer and consumer threads will be interleaved, demonstrating that they are running concurrently.
*   **Coordinated Execution**: You'll see messages like "Consumer is waiting..." when the buffer is empty, and "Producer is waiting..." when the buffer is full. This shows `wait()` and `notifyAll()` are effectively coordinating their actions.
*   **Orderly Processing**: Despite concurrency, the messages will be produced and consumed in the correct order due to the synchronization and inter-thread communication mechanisms.
*   **Performance (Simulated)**: The `Thread.sleep()` calls simulate work, making the interaction between threads more apparent and preventing one thread from monopolizing the CPU. In a real-world scenario, these delays would represent actual computation or I/O operations.

This program provides a clear, hands-on example of how to build robust multithreaded applications in Java by managing shared resources and coordinating thread activities.
