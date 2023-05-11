package behavioral.template.databaseaccess;

public class CustomerQuery extends DatabaseAccessor {
    @Override
    protected String constructQuery() {
        return "SELECT * FROM customers";
    }

    @Override
    protected void execute(String query) {
        System.out.println("Executing customer query: " + query);
    }

    @Override
    protected void handleResults() {
        System.out.println("Handling customer query results...");
    }
}
