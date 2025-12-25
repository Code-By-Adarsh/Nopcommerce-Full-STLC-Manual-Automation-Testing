package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstances(){
        if (extent == null){
            String reportPath = System.getProperty("user.dir")+"\\src\\main\\report\\extent-report\\NopCommerceReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("NopCommerce Project");
            spark.config().setReportName("NopCommerce Report");
            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Automation Tester: ","Adarsh Mishra");
            extent.setSystemInfo("Browser: ","Chrome");
            extent.setSystemInfo("AUT: ","NopCommerce");
            extent.setSystemInfo("Report: ","NopCommerce Report");
        }
        return extent;
    }
}
