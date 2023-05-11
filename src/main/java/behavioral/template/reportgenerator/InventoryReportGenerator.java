package behavioral.template.reportgenerator;

public class InventoryReportGenerator extends ReportGenerator {
    @Override
    protected void gatherData() {
        System.out.println("Gathering inventory data...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting inventory report...");
    }

    @Override
    protected void generateOutput() {
        System.out.println("Generating inventory report output...");
    }
}
