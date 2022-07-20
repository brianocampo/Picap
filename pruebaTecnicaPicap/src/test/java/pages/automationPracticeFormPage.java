package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class automationPracticeFormPage {

    private WebElement element = null;

    public WebElement name(WebDriver driver) {

        element = driver.findElement(By.id("firstName"));
        return element;
    }

    public WebElement lastName(WebDriver driver) {

        element = driver.findElement(By.id("lastName"));
        return element;
    }

    public WebElement email(WebDriver driver) {

        element = driver.findElement(By.id("userEmail"));
        return element;
    }

    public WebElement gender(WebDriver driver, String gender) {

        element = driver.findElement(By.xpath("//*/input[@value='" + gender + "']/parent::div"));
        return element;
    }

    public WebElement mobile(WebDriver driver) {

        element = driver.findElement(By.id("userNumber"));
        return element;
    }

    public WebElement dateOfBirth(WebDriver driver) {

        element = driver.findElement(By.id("dateOfBirthInput"));
        return element;
    }

    public WebElement dateOfBirthMonth(WebDriver driver, int month) {

        element = driver.findElement(By.xpath("//*/div[1]/select/option[" + month + "]"));
        return element;
    }

    public WebElement dateOfBirthYear(WebDriver driver, int year) {

        element = driver.findElement(By.xpath("//*/select[@class='react-datepicker__year-select']/option[@value='" + year + "']"));
        return element;
    }

    public WebElement dateOfBirthDay(WebDriver driver, int day) {

        element = driver.findElement(By.xpath("//*/div[contains(text(),'" + day + "') and @role='option']"));
        return element;
    }

    public WebElement subjects(WebDriver driver) {

        element = driver.findElement(By.id("subjectsInput"));
        return element;
    }

    public WebElement hobbies(WebDriver driver, String hobbies) {

        element = driver.findElement(By.xpath("//*/label[contains(text(),'" + hobbies + "')]/parent::div"));
        return element;
    }

    public WebElement currentAddress(WebDriver driver) {

        element = driver.findElement(By.id("currentAddress"));
        return element;
    }

}
