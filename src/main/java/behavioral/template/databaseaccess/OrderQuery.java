package behavioral.template.databaseaccess;

public class OrderQuery extends DatabaseAccessor {
    @Override
    protected String constructQuery() {
        return "SELECT * FROM orders";
    }

    @Override
    protected void execute(String query) {
        System.out.println("Executing order query: " + query);
    }

    @Override
    protected void handleResults() {
        System.out.println("Handling order query results...");
    }
}
