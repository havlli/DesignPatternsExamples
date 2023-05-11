package behavioral.template.reportgenerator;

public class SalesReportGenerator extends ReportGenerator {
    @Override
    protected void gatherData() {
        System.out.println("Gathering sales data...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting sales report...");
    }

    @Override
    protected void generateOutput() {
        System.out.println("Generating sales report output...");
    }
}
