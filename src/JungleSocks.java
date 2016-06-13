
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
  public void testJungleSocksCA() throws Exception {
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
	    	assertEquals("elephant 35 1", driver.findElement(By.className("elephant")).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    try {
	    	assertEquals("lion 20 3", driver.findElement(By.className("lion")).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    try {
	    	assertEquals("zebra 13 2", driver.findElement(By.className("zebra")).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    try {
	    	assertEquals("giraffe 17 1", driver.findElement(By.className("giraffe")).getText());
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
  public void testJungleSocksCoNeg() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("1");
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("0");
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("-1");
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("1");
    //Selecting state of Colorado
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
  public void testJungleSocksNoItems() throws Exception {
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
  @Test
  public void testJungleSocksMnNoTax() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("1");
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("2");
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("3");
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("4");
    //Selecting state of Minnesota
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("Minnesota");
    driver.findElement(By.name("commit")).click();
    try {
      assertFalse(isAlertPresent());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$226.00", driver.findElement(By.id("subtotal")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
    	/* Minnesota Tax @ 0.00% */
      assertEquals("$0.00", driver.findElement(By.id("taxes")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("$226.00", driver.findElement(By.id("total")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
   
  }
  
  @Test
  public void testJungleSocksNY() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("line_item_quantity_zebra")).clear();
	    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("2");
	    driver.findElement(By.id("line_item_quantity_lion")).clear();
	    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("3");
	    driver.findElement(By.id("line_item_quantity_elephant")).clear();
	    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("1");
	    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
	    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("1");
	    //Selecting state of NY
	    new Select(driver.findElement(By.name("state"))).selectByVisibleText("New York");
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
	    	/* NewYork Tax @ 6.00% */
	      assertEquals("$8.28", driver.findElement(By.id("taxes")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$146.28", driver.findElement(By.id("total")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	   
	  }
  
  @Test
  public void testJungleSocksExceedsQty() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("line_item_quantity_zebra")).clear();
	    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("0");
	    driver.findElement(By.id("line_item_quantity_lion")).clear();
	    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("0");
	    driver.findElement(By.id("line_item_quantity_elephant")).clear();
	    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("5");
	    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
	    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("0");
	    //Selecting state of Nebraska
	    new Select(driver.findElement(By.name("state"))).selectByVisibleText("Nebraska");
	    driver.findElement(By.name("commit")).click();
	    try {
	      assertFalse(isAlertPresent());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	    	assertEquals("elephant 35 3", driver.findElement(By.className("elephant")).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    
	    try {
	      assertEquals("$105.00", driver.findElement(By.id("subtotal")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	    	/* Nebraska Tax @ 5.00% */
	      assertEquals("$5.25", driver.findElement(By.id("taxes")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("$110.25", driver.findElement(By.id("total")).getText());
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

