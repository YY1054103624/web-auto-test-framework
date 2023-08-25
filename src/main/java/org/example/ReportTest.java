package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ReportTest {
    @Test
    public void test() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html")
                .viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY})
                .apply();
        spark.loadXMLConfig(new File("src/test/resources/config/reportsettings.xml"));
        ExtentSparkReporter failedSpark = new ExtentSparkReporter("target/fail-tests-Spark.html")
                .filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
        failedSpark.config().setDocumentTitle("Failed tests");
        extent.attachReporter(spark, failedSpark);

        ExtentTest test1 = extent.createTest("Login Test");
        test1.pass("Login Test started successfully");
        test1.info("URL is loaded");
        test1.info("Values entered");
        test1.pass(MarkupHelper.createLabel("Login Test completed successfully", ExtentColor.GREEN));
        String json = "{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        test1.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
        test1.assignAuthor("Oscar").assignCategory("Smoke").assignCategory("Regression").assignDevice("Chrome 116");


        ExtentTest test2 = extent.createTest("HomePage Test");
        test2.pass("Login Test started successfully");
        test2.info("URL is loaded");
        test2.info("Values entered");
        test2.fail("HomePage Test failed miserably");
        test2.fail(MarkupHelper.createLabel("HomePage Test failed miserably", ExtentColor.RED));
        List<String> list = Arrays.asList("Oscar", "Lee", "Yang");
        list.forEach(test2::pass);
        test2.fail(MarkupHelper.createOrderedList(list));

        Map<String, String> map = new HashMap<>();
        map.put("username", "Oscar");
        map.put("password", "123456");
        test2.fail(MarkupHelper.createUnorderedList(map));
        test2.assignAuthor("Stan").assignCategory("Smoke").assignDevice("Firefox 86");

        extent.flush();
        Desktop.getDesktop().browse(new File("target/Spark.html").toURI());
//        Desktop.getDesktop().browse(new File("target/fail-tests-Spark.html").toURI());
    }
}
