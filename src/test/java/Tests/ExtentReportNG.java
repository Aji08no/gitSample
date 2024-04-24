package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportNG {

    public static ExtentReports getReport(){

        String path = System.getProperty("user.dir")+"//ExtendReport.html";
        ExtentSparkReporter report=new ExtentSparkReporter(path);

        report.config().setDocumentTitle("");
        report.config().setReportName("");

        ExtentReports extend=new ExtentReports();
        extend.attachReporter(report);

        extend.setSystemInfo("","");
        return extend;
    }
}
