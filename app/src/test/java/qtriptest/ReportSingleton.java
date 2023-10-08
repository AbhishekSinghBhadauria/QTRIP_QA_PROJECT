package qtriptest;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;

public class ReportSingleton {
    private static ExtentReports report;

    private ReportSingleton(){}

    public static ExtentReports getReportInstance(){
        if(report == null){
            report = new ExtentReports(System.getProperty("user.dir")+"/extentReport.html");
            report.loadConfig(new File(System.getProperty("user.dir")+"/extent_customization_configs.xml"));
        }
        return report;
    }
}