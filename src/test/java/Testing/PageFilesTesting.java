package Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageFile.AddtoCart;
import pageFile.HomePageFile;
import pageFile.LoginPageFile;

public class PageFilesTesting extends MainData {
	
	//extent the reports 
	ExtentReports extent;
	@BeforeTest
    public void setUp() {
		String path= System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("Project team");
		spark.config().setReportName("Automation Result");
	
		
	    extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester","surya");
	 
 }
//using logger command for log files
   private static Logger log =LogManager.getLogger(PageFilesTesting.class.getName());
	@Test
	public void pageNavigation() throws IOException, InterruptedException {
		
		ExtentTest test=extent.createTest("initial test");
		driver=initializeDriver();
		
		//calling the class files
		HomePageFile Funcall=PageFactory.initElements(driver,HomePageFile.class);
		LoginPageFile signcall=PageFactory.initElements(driver,LoginPageFile.class);
		AddtoCart productcall=PageFactory.initElements(driver,AddtoCart.class);
		
		//calling the login credentials
		signcall.loginClick();
		
		//email id
		signcall.emailClick();
		
		//continue btn
		signcall.clickContinue();
		
		//password id
		log.debug("This is debug");
		signcall.passwordID();
		log.info("This password is right");
		
		//click on signin
		signcall.signClick();
		
		//calling the search
		Funcall.clickSearch();
		
		//calling the searchicon
		Funcall.clickIcon();
		//explicit wait
		Funcall.waitForClick();
		
		
		//select low price 
		Funcall.clickDropdown();
		
		
		//calling the product
		productcall.selectLink();
     
          
        //calling the cart btn
		productcall.selectAddtoCart();
	    
	    
	    //calling the proceed btn
		productcall.proceedtoCart();
		
		//calling the payment btn
		productcall.paymentClick();
		
		
		extent.flush();
		}
	


}
