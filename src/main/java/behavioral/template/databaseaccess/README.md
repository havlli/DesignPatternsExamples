# Database Access
In a database application, you might have a common database access process that needs to be executed for different types of queries. By using the Template Method Pattern, you can define the basic structure of the database access process in a base class, and then allow subclasses to implement their own logic for specific steps of the process, such as constructing the query, executing the query, or handling the results.
```java
// Base class for database access
abstract class DatabaseAccessor {
    // Template method to execute query
    public void executeQuery() {
        // Step 1: Construct query
        String query = constructQuery();
        // Step 2: Execute query
        execute(query);
        // Step 3: Handle results
        handleResults();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract String constructQuery();
    protected abstract void execute(String query);
    protected abstract void handleResults();
}

// Subclass for specific type of query
class CustomerQuery extends DatabaseAccessor {
    @Override
    protected String constructQuery() {
        // Implementation for constructing customer query
        return "SELECT * FROM customers";
    }

    @Override
    protected void execute(String query) {
        // Implementation for executing customer query
        System.out.println("Executing customer query: " + query);
    }

    @Override
    protected void handleResults() {
        // Implementation for handling customer query results
        System.out.println("Handling customer query results...");
    }
}

// Subclass for another type of query
class OrderQuery extends DatabaseAccessor {
    @Override
    protected String constructQuery() {
        // Implementation for constructing order query
        return "SELECT * FROM orders";
    }

    @Override
    protected void execute(String query) {
        // Implementation for executing order query
        System.out.println("Executing order query: " + query);
    }

    @Override
    protected void handleResults() {
        // Implementation for handling order query results
        System.out.println("Handling order query results...");
    }
}

// Client code that uses the database accessors
public class DatabaseAccessorClient {
    public static void main(String[] args) {
        // Execute customer query
        DatabaseAccessor customerQuery = new CustomerQuery();
        customerQuery.executeQuery();

        // Execute order query
        DatabaseAccessor orderQuery = new OrderQuery();
        orderQuery.executeQuery();
    }
}
```

In the above code, we have a base class `DatabaseAccessor` that defines the overall structure of the database access process using a template method `executeQuery()`. The template method consists of three steps: `constructQuery()`, `execute(String query)`, and `handleResults()`. These steps are left as abstract methods, which means that the specific implementation of these methods will be provided by the subclasses.

We then have two subclasses `CustomerQuery` and `OrderQuery` that inherit from the `DatabaseAccessor` base class. These subclasses provide their own implementation for the three abstract methods defined in the base class, which allows them to customize the database access process for their specific type of query.

Finally, we have a client code `DatabaseAccessorClient` that uses the database accessor objects to execute queries. We create an instance of `CustomerQuery` and `OrderQuery` and call the `executeQuery()` method on them to execute the corresponding queries.

With this design, we can easily add more types of queries by creating new subclasses of `DatabaseAccessor` and providing their own implementation for the abstract methods. This promotes code reusability and makes the database access process flexible and extensible.