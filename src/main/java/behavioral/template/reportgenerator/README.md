# Report Generation
In a reporting system, you might have a common report generation process that needs to be executed for different types of reports. By using the Template Method Pattern, you can define the basic structure of the report generation process in a base class, and then allow subclasses to implement their own logic for specific steps of the process, such as gathering data, formatting the report, or generating output.
```java
// Base class for report generation
abstract class ReportGenerator {
    // Template method to generate report
    public void generateReport() {
        // Step 1: Gather data for report
        gatherData();
        // Step 2: Format report
        formatReport();
        // Step 3: Generate output
        generateOutput();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void gatherData();
    protected abstract void formatReport();
    protected abstract void generateOutput();
}

// Subclass for specific type of report
class SalesReportGenerator extends ReportGenerator {
    @Override
    protected void gatherData() {
        // Implementation for gathering sales data
        System.out.println("Gathering sales data...");
    }

    @Override
    protected void formatReport() {
        // Implementation for formatting sales report
        System.out.println("Formatting sales report...");
    }

    @Override
    protected void generateOutput() {
        // Implementation for generating sales report output
        System.out.println("Generating sales report output...");
    }
}

// Subclass for another type of report
class InventoryReportGenerator extends ReportGenerator {
    @Override
    protected void gatherData() {
        // Implementation for gathering inventory data
        System.out.println("Gathering inventory data...");
    }

    @Override
    protected void formatReport() {
        // Implementation for formatting inventory report
        System.out.println("Formatting inventory report...");
    }

    @Override
    protected void generateOutput() {
        // Implementation for generating inventory report output
        System.out.println("Generating inventory report output...");
    }
}

// Client code that uses the report generator
public class ReportGenerationClient {
    public static void main(String[] args) {
        // Generate sales report
        ReportGenerator salesReportGenerator = new SalesReportGenerator();
        salesReportGenerator.generateReport();

        // Generate inventory report
        ReportGenerator inventoryReportGenerator = new InventoryReportGenerator();
        inventoryReportGenerator.generateReport();
    }
}
```
In the above code, we have a base class `ReportGenerator` that defines the overall structure of the report generation process using a template method `generateReport()`. The template method consists of three steps: `gatherData()`, `formatReport()`, and `generateOutput()`. These steps are left as abstract methods, which means that the specific implementation of these methods will be provided by the subclasses.

We then have two subclasses `SalesReportGenerator` and `InventoryReportGenerator` that inherit from the `ReportGenerator` base class. These subclasses provide their own implementation for the three abstract methods defined in the base class, which allows them to customize the report generation process for their specific type of report.

Finally, we have a client code `ReportGenerationClient` that uses the report generator objects to generate reports. We create an instance of `SalesReportGenerator` and `InventoryReportGenerator` and call the `generateReport()` method on them to generate the corresponding reports.

With this design, we can easily add more types of reports by creating new subclasses of `ReportGenerator` and providing their own implementation for the abstract methods. This promotes code reusability and makes the report generation process flexible and extensible.