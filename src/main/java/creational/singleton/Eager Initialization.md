

Suppose you are building a database connection manager for a web application. You want to ensure that there is only one instance of the database connection manager throughout the entire application, to prevent issues with resource contention and consistency. Additionally, you want the database connection manager to be immediately available for use by any thread that needs it.

To accomplish this, you could implement the database connection manager as an eager singleton. The `getInstance()` method of the singleton class would return the single instance of the database connection manager, which would be initialized when the class is loaded.
``` java
public class DatabaseConnectionManager {
    private static final DatabaseConnectionManager instance = new DatabaseConnectionManager();

    private DatabaseConnectionManager() {
        // Private constructor to prevent external instantiation
    }
    
    public static DatabaseConnectionManager getInstance() {
        return instance;
    }
    
    // Other methods and properties of the singleton class
}
```

Now, any thread that needs to interact with the database can simply call the `getInstance()` method to obtain the database connection manager instance, without having to worry about initializing or managing the connection manager object themselves. This approach provides a centralized and reliable way to manage database connections throughout the application, while also being easy to use and thread-safe.

