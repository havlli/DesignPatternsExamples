## Database Connection Pooling
This example demonstrates how to create a database connection pool using the Object Pool design pattern. The `ConnectionPool` class is responsible for managing a pool of database connections. It has a constructor that takes the database `URL`, `username`, `password`, and maximum pool size as parameters.

The `getConnection()` method is used to borrow a connection from the pool. If the pool is empty, it creates a new connection using the `createConnection()` method. The `releaseConnection()` method is used to return a connection to the pool. If the pool is full, it closes the connection instead.
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private String url, username, password;
    private List<Connection> pool;
    private int maxPoolSize;

    public ConnectionPool(String url, String username, String password, int maxPoolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxPoolSize = maxPoolSize;
        pool = new ArrayList<>(maxPoolSize);
    }

    public synchronized Connection getConnection() throws SQLException {
        if (pool.isEmpty()) {
            return createConnection();
        }
        return pool.remove(pool.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        if (pool.size() < maxPoolSize) {
            pool.add(connection);
        } else {
            try {
                connection.close();
            } catch (SQLException e) {
                // log error
            }
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
```