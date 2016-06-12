
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JungleSocks {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://jungle-socks.herokuapp.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
  @Test
  public void testJungleSocks() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("line_item_quantity_zebra")).clear();
	    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("2");
	    driver.findElement(By.id("line_item_quantity_lion")).clear();
	    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("3");
	    driver.findElement(By.id("line_item_quantity_elephant")).clear();
	    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("1");
	    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
	    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("1");
	    //Selecting state of California
	    new Select(driver.findElement(By.name("state"))).selectByVisibleText("California");
	    driver.findElement(By.name("commit")).click();
	    try {
	      assertFalse(isAlertPresent());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$138.00", driver.findElement(By.id("subtotal")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	    	/* California Tax @ 8.00% */
	      assertEquals("$11.04", driver.findElement(By.id("taxes")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$149.04", driver.findElement(By.id("total")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	   
	  }
  
  @Test
  public void testJungleSocks2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("1");
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("0");
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("-1");
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("1");
    //Selecting state of California
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("Colorado");
    driver.findElement(By.name("commit")).click();
    try {
      assertFalse(isAlertPresent());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$30.00", driver.findElement(By.id("subtotal")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
    	/* Colorado Tax @ 5.00% */
      assertEquals("$1.50", driver.findElement(By.id("taxes")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$31.50", driver.findElement(By.id("total")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
   
  }
  
  @Test
  public void testJungleSocks3() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    //Don't select a state
    //new Select(driver.findElement(By.name("state"))).selectByVisibleText("");
    driver.findElement(By.name("commit")).click();
    try {
      assertFalse(isAlertPresent());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertFalse(driver.getTitle().equalsIgnoreCase("We're sorry, but something went wrong (500)"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }     
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  
  }

