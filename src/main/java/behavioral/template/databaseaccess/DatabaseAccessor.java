package behavioral.template.databaseaccess;

public abstract class DatabaseAccessor {
    public void executeQuery() {
        String query = constructQuery();
        execute(query);
        handleResults();
    }

    protected abstract String constructQuery();
    protected abstract void execute(String query);
    protected abstract void handleResults();
}
