package pageFile;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFile {
	private static Logger log =LogManager.getLogger(LoginPageFile.class.getName());
    
WebDriver driver;
     
     public LoginPageFile(WebDriver driver) {
  	   this.driver=driver;
  	   PageFactory.initElements(driver, this);
     }
     //loginbtn
     @FindBy(xpath="//span[text()='Account & Lists']")
     WebElement LoginIn;
     
     //emailbtn
     @FindBy(xpath="//input[@id='ap_email']")
     WebElement EmailBox;
     
     //continuebtn
     @FindBy(xpath="//input[@id='continue']")
     WebElement Continuebtn;
     
     //passwordbtn
     @FindBy(xpath="//input[@id='ap_password']")
     WebElement Password;
     
     //signinbtn
     @FindBy(xpath="//input[@id='signInSubmit']")
     WebElement SignInClick;
     
     
     //click on thelogin method
     public void loginClick() {
    	 LoginIn.click();
     }
     
     //click on the email and get the id from excel sheet
     public void emailClick()throws IOException{
     FileInputStream fis=new FileInputStream("F:\\ExcelSheet\\testleaf.xlsx");
     
     try 
     (XSSFWorkbook WB = new XSSFWorkbook(fis)) {
	 XSSFSheet sheet1=WB.getSheetAt(0);
	 String data=sheet1.getRow(0).getCell(0).getStringCellValue();
	 EmailBox.sendKeys(data);
		}
     catch(Exception e) {
		
		}
     
     }
     
     //click on the continuebtn
     public void clickContinue() {
  	 Continuebtn.click();
     }
     
    //click on the password and get the password from excel sheet
     public void passwordID()throws IOException{
     FileInputStream fis=new FileInputStream("F:\\ExcelSheet\\testleaf.xlsx");
     try (XSSFWorkbook WB = new XSSFWorkbook(fis)) {
	 XSSFSheet sheet1=WB.getSheetAt(0);
	 String datavalue=sheet1.getRow(1).getCell(0).getStringCellValue();
	 Password.sendKeys(datavalue);
		log.info("Password is  entered");
	 }
	 
     }
    
  //click on the signin btn
     public void signClick() {
  	   SignInClick.click();
     }
}
