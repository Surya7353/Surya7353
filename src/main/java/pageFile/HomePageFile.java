package pageFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageFile {
	 WebDriver driver;
     
     public HomePageFile(WebDriver driver) {
  	   this.driver=driver;
  	   PageFactory.initElements(driver, this);
     }
     
     
   //locator of searchbox
     @FindBy(id="twotabsearchtextbox")
     WebElement btnSearch;
     
     
   //locator of searchbar
     @FindBy(id="nav-search-submit-button")
     WebElement btnSearchIcon;
     
     //click on sortby for low price
     @FindBy(xpath="//select[@data-action='a-dropdown-select']")
     WebElement selectprice;
     
     

 
    //explicit wait 
     public void waitForClick() {
    	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	 wait.until(ExpectedConditions.elementToBeClickable(selectprice));
    	 
     }
     
     //click on product
     public void clickSearch() throws IOException {
    	 FileInputStream fis=new FileInputStream("F:\\ExcelSheet\\testleaf.xlsx");
    	 
    	 try  (XSSFWorkbook WB = new XSSFWorkbook(fis)) {
			XSSFSheet sheet1=WB.getSheetAt(0);
			 String datavalues=sheet1.getRow(2).getCell(0).getStringCellValue();
			 btnSearch.sendKeys(datavalues);
		}
     
       }
     //click on search
     public void clickIcon() {
    	 btnSearchIcon.click();
       }
  
     
     
     
     //click on search
      public void clickDropdown() {
    	  Select select=new Select(selectprice);
    	  select.selectByIndex(1);
       }
     
     
    
}
      
     
    
   
     

