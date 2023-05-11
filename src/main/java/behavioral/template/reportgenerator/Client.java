package behavioral.template.reportgenerator;

public class Client {
    public static void main(String[] args) {
        ReportGenerator salesReportGenerator = new SalesReportGenerator();
        salesReportGenerator.generateReport();

        ReportGenerator inventoryReportGenerator = new InventoryReportGenerator();
        inventoryReportGenerator.generateReport();
    }
}
