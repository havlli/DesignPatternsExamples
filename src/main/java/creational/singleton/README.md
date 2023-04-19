# Singleton Design Pattern

The Singleton pattern is a design pattern that is used to ensure that there is only one instance of a class throughout the entire application. There are several ways to implement the Singleton pattern, and each has its own pros and cons.

### 1.  Eager Singleton:

In this approach, the Singleton instance is created when the class is loaded into memory, which means that the instance is created even if it is not needed. The advantage of this approach is that it ensures that the Singleton instance is always available and ready to use. The downside is that it can be wasteful of system resources if the Singleton instance is not needed very often.

**Pros:**
-   Thread-safe
-   No additional code required to handle multi-threaded access
-   Initialization is guaranteed to be complete before any thread can access the instance

**Cons:**
-   Wasteful of system resources if the Singleton instance is not needed very often
-   The Singleton instance is created even if it is not needed

***[Simple Example]() - [Real Life Example]()***
### 2.  Lazy Singleton:

In this approach, the Singleton instance is created only when it is needed for the first time. The advantage of this approach is that it conserves system resources until the Singleton instance is actually needed. The downside is that it requires additional code to ensure thread safety and handle multi-threaded access.

**Pros:**
-   Conserves system resources until the Singleton instance is actually needed
-   The Singleton instance is created only when it is needed for the first time

**Cons:**
-   Requires additional code to ensure thread safety and handle multi-threaded access
-   Initialization may not be complete before any thread can access the instance

***[Simple Example]() - [Real Life Example]()***
### 3.  Singleton with Initialization Holder:

In this approach, the Singleton instance is created when the class is loaded into memory, but the instance is not actually created until it is first needed. This approach provides the benefits of both the Eager Singleton and Lazy Singleton approaches, without their respective downsides.

**Pros:**
-   Thread-safe
-   No additional code required to handle multi-threaded access
-   Initialization is guaranteed to be complete before any thread can access the instance
-   Conserves system resources until the Singleton instance is actually needed
-   The Singleton instance is created only when it is needed for the first time

**Cons:**
-   Requires an additional inner class to hold the Singleton instance

***[Simple Example]() - [Real Life Example]()***
### 4.  Singleton implemented as an Enum:

In this approach, the Singleton instance is created automatically when the Enum class is loaded into memory. This approach provides a simple and efficient way to implement the Singleton pattern, while also ensuring that there is only one instance of the Singleton class throughout the entire application.

**Pros:**
-   Thread-safe
-   No additional code required to handle multi-threaded access
-   Initialization is guaranteed to be complete before any thread can access the instance
-   Simple and efficient to implement

**Cons:**
-   May not be appropriate for classes with complex initialization requirements
-   May not be appropriate for classes that require a non-default constructor

***[Simple Example]() - [Real Life Example]()***

---
Overall, the choice of Singleton implementation approach depends on the specific requirements of your application. If you need to ensure that the Singleton instance is always available and ready to use, you might choose the Eager Singleton approach. If you need to conserve system resources until the Singleton instance is actually needed, you might choose the Lazy Singleton or Singleton with Initialization Holder approach. If you need a simple and efficient way to implement the Singleton pattern, you might choose the Singleton implemented as an Enum approach.

