## Database Adapter
In this example, we have a legacy database system that uses a specific interface for accessing data. We want to create a new system that uses a different interface for accessing data. To achieve this, we can create a database adapter that adapts the legacy interface to the new interface. The adapter will contain an instance of the legacy database object and will implement the new interface.
```java
// Adaptee interface (legacy interface)
public interface LegacyDatabase {
    void connect(String url);
    void query(String sql);
}

// Adaptee implementation (legacy implementation)
public class LegacyDatabaseImpl implements LegacyDatabase {
    @Override
    public void connect(String url) {
        // connect to legacy database
    }

    @Override
    public void query(String sql) {
        // execute legacy database query
    }
}

// Target interface (new interface)
public interface NewDatabase {
    void connect(String host, int port, String username, String password);
    ResultSet executeQuery(String sql);
}

// Adapter class
public class DatabaseAdapter implements NewDatabase {
    private final LegacyDatabase legacyDatabase;

    public DatabaseAdapter(LegacyDatabase legacyDatabase) {
        this.legacyDatabase = legacyDatabase;
    }

    @Override
    public void connect(String host, int port, String username, String password) {
        String url = "jdbc:legacy://" + host + ":" + port + "?user=" + username + "&password=" + password;
        legacyDatabase.connect(url);
    }

    @Override
    public ResultSet executeQuery(String sql) {
        legacyDatabase.query(sql);
        // parse and return result set
    }
}

// Client code.java
public class DatabaseClient {
    public static void main(String[] args) {
        LegacyDatabase legacyDatabase = new LegacyDatabaseImpl();
        NewDatabase newDatabase = new DatabaseAdapter(legacyDatabase);
        newDatabase.connect("localhost", 3306, "root", "password");
        ResultSet resultSet = newDatabase.executeQuery("SELECT * FROM users");
        // process result set
    }
}
```
In this example, the `LegacyDatabase` interface and `LegacyDatabaseImpl` class represent the legacy database system with its specific interface. The `NewDatabase` interface represents the new database system with its new interface. The `DatabaseAdapter` class adapts the `LegacyDatabase` interface to the `NewDatabase` interface. The client code creates an instance of the `DatabaseAdapter` class and uses it as if it were an instance of the `NewDatabase` interface.