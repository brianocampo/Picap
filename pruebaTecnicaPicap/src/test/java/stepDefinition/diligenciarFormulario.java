package stepDefinition;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.automationPracticeFormPage;

public class diligenciarFormulario {

    automationPracticeFormPage automationPracticeForm = new automationPracticeFormPage();

    public ChromeDriver crearDriverWebChrome() {

        ChromeDriver driver = null;

        try {
            
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return driver;
        }
    }
    
    public AndroidDriver crearAndroidDriverRemote(String userName, String accessKey){
    
        AndroidDriver driver = null;
        
        try {
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();          
            
            browserstackOptions.put("deviceName", "Samsung Galaxy S10");
            browserstackOptions.put("buildName", "Prueba tecnica");
            browserstackOptions.put("projectName", "demoqa");
            browserstackOptions.put("sessionName", "prueba Picap");
            browserstackOptions.put("osVersion", "9.0");            
            browserstackOptions.put("local", "false"); 
            browserstackOptions.put("realMobile", "true");
            
            capabilities.setCapability("bstack:options", browserstackOptions);
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("platformName", "Android");
            
            driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
                
            
        } catch (Exception e) {        
            System.out.println(e.getMessage());
        }finally{
        
            return driver;
        }
    }
    
    public void cerrarDriver(WebDriver driver){
    
        driver.quit();
        
    }
       
    public void cargarPagina(WebDriver driver, String URL){
    
        try {
            
            driver.get(URL);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void diligenciarFormulario(
            WebDriver driver, 
            String name,
            String lastName,
            String email,
            String gender,
            String mobile,
            int month,
            int year,
            int day,
            String subject,
            String hobbie,
            String currentAddress){
    
        try {
            
            automationPracticeForm.name(driver).sendKeys(name);
            desplazarVerticalmenteUnWebElement(driver,automationPracticeForm.name(driver));
            Thread.sleep(500);
            automationPracticeForm.lastName(driver).sendKeys(lastName);
            desplazarVerticalmenteUnWebElement(driver,automationPracticeForm.lastName(driver));
            Thread.sleep(500);
            automationPracticeForm.email(driver).sendKeys(email);
            desplazarVerticalmenteUnWebElement(driver,automationPracticeForm.email(driver));
            Thread.sleep(500);
            automationPracticeForm.gender(driver,gender).click();
            desplazarVerticalmenteUnWebElement(driver,automationPracticeForm.gender(driver,gender));
            Thread.sleep(500);
            automationPracticeForm.mobile(driver).sendKeys(mobile);
            desplazarVerticalmenteUnWebElement(driver,automationPracticeForm.mobile(driver));
            Thread.sleep(500);
            automationPracticeForm.dateOfBirth(driver).click();
            Thread.sleep(1000);
            automationPracticeForm.dateOfBirthMonth(driver,month).click();
            automationPracticeForm.dateOfBirthYear(driver,year).click();           
            automationPracticeForm.dateOfBirthDay(driver,day).click();
            desplazarVerticalmenteUnWebElement(driver,automationPracticeForm.subjects(driver));
            Thread.sleep(500);
            automationPracticeForm.subjects(driver).sendKeys(subject);
            automationPracticeForm.subjects(driver).sendKeys(Keys.ENTER);
            automationPracticeForm.hobbies(driver,hobbie).click();
            automationPracticeForm.currentAddress(driver).sendKeys(currentAddress);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void desplazarVerticalmenteUnWebElement(WebDriver driver, WebElement element){
    
        try {
             
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
    }
}
