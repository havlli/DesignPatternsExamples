## Network Connection Pooling
This example demonstrates how to create a network connection pool using the Object Pool design pattern. The ConnectionPool class is responsible for managing a pool of network connections. It has a constructor that takes the server host, server port, and maximum pool size as parameters.

The `getConnection()` method is used to borrow a connection from the pool. If the pool is empty, it creates a new connection using the `createConnection()` method. The `releaseConnection()` method is used to return a connection to the pool. If the pool is full, it closes the connection instead.
```java
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private String host;
    private int port;
    private List<Socket> pool;
    private int maxPoolSize;

    public ConnectionPool(String host, int port, int maxPoolSize) {
        this.host = host;
        this.port = port;
        this.maxPoolSize = maxPoolSize;
        pool = new ArrayList<>(maxPoolSize);
    }

    public synchronized Socket getConnection() throws IOException {
        if (pool.isEmpty()) {
            return createConnection();
        }
        return pool.remove(pool.size() - 1);
    }

    public synchronized void releaseConnection(Socket connection) throws IOException {
        if (pool.size() < maxPoolSize) {
            pool.add(connection);
        } else {
            connection.close();
        }
    }

    private Socket createConnection() throws IOException {
        return new Socket(host, port);
    }

}
```