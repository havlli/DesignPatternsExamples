package behavioral.template.databaseaccess;

public class Client {
    public static void main(String[] args) {
        DatabaseAccessor customerQuery = new CustomerQuery();
        customerQuery.executeQuery();

        DatabaseAccessor orderQuery = new OrderQuery();
        orderQuery.executeQuery();
    }
}
