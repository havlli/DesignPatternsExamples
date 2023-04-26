## Socket Adapters
In Java, there are different types of sockets, such as `ServerSocket` and `Socket`. If you want to create a TCP/IP connection, you need to use the `Socket` class, but if you want to create a server, you need to use the `ServerSocket` class. To make these two classes work together, you can use an adapter that adapts the `ServerSocket` interface to the `Socket` interface.
```java
public class ServerSocketAdapter extends Socket {
    private ServerSocket serverSocket;

    public ServerSocketAdapter(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    // Override the methods from Socket class
    public InputStream getInputStream() throws IOException {
        return serverSocket.accept().getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return serverSocket.accept().getOutputStream();
    }
}
```