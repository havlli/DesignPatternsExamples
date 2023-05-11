package behavioral.template.reportgenerator;

// Base class for report generation
public abstract class ReportGenerator {
    // Template method to generate report
    public void generateReport() {
        gatherData();
        formatReport();
        generateOutput();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void gatherData();
    protected abstract void formatReport();
    protected abstract void generateOutput();
}
