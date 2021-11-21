package com.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import static org.junit.jupiter.api.Assertions.*;

public class SelectOperations {

    private static final String URL_CALCULADORA = "https://testsheepnz.github.io/BasicCalculator.html";
    WebDriver driver = null;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Angie\\Cursos\\CursoTesting\\9-SemanaNovena15Nov\\selenium\\m4-selenium-mariaangeles-barba\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void SelectSubtractTest(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Subtract");
        sleep();

        WebElement firstSelectedOption = selectObject.getFirstSelectedOption();
        String op = firstSelectedOption.getAttribute("Value");
        assertEquals("1", op);
    }

    @Test
    void calculateButtonSubtractTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Subtract");

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("3");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("1");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement output = driver.findElement(By.name("numberAnswer"));
        String inputValue = output.getAttribute("value");
        assertEquals("2", inputValue);
    }

    @Test
    void SelectMultiplyTest(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Multiply");
        sleep();

        WebElement firstSelectedOption = selectObject.getFirstSelectedOption();
        String op = firstSelectedOption.getAttribute("Value");
        assertEquals("2", op);
    }

    @Test
    void calculateButtonMultiplyTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Multiply");

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("3");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement output = driver.findElement(By.name("numberAnswer"));
        String inputValue = output.getAttribute("value");
        assertEquals("6", inputValue);
    }

    @Test
    void SelectDivideTest(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Divide");
        sleep();

        WebElement firstSelectedOption = selectObject.getFirstSelectedOption();
        String op = firstSelectedOption.getAttribute("Value");
        assertEquals("3", op);
    }

    @Test
    void calculateButtonDivideTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Divide");

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("6");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement output = driver.findElement(By.name("numberAnswer"));
        String inputValue = output.getAttribute("value");
        assertEquals("3", inputValue);
    }

    @Test
    void calculateButtonDividebyZeroTest(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Divide");

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("6");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("0");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement errorMsg = driver.findElement(By.id("errorMsgField"));
        String inputValue = errorMsg.getText();
        assertEquals("Divide by zero error!", inputValue);
        sleep();

        boolean inputDisplayed = errorMsg.isDisplayed();
        assertTrue(inputDisplayed);
    }

    @Test
    void SelectConcatenateTest(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Concatenate");
        sleep();

        WebElement firstSelectedOption = selectObject.getFirstSelectedOption();
        String op = firstSelectedOption.getAttribute("Value");
        assertEquals("4", op);
    }

    @Test
    void calculateButtonConcatenateNumbersTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Concatenate");

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("1");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement output = driver.findElement(By.name("numberAnswer"));
        String inputValue = output.getAttribute("value");
        assertEquals("12", inputValue);
    }

    @Test
    void calculateButtonConcatenateStringsTestOK(){
        driver.get(URL_CALCULADORA);

        WebElement selector = driver.findElement(By.id("selectOperationDropdown"));
        Select selectObject = new Select(selector);

        selectObject.selectByVisibleText("Concatenate");

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        input1.sendKeys("Suma y ");
        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        input2.sendKeys("resta");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        assertEquals("btn btn-primary", calculateButton.getAttribute("class"));
        calculateButton.click();
        sleep();

        WebElement output = driver.findElement(By.name("numberAnswer"));
        String inputValue = output.getAttribute("value");
        assertEquals("Suma y resta", inputValue);
    }

    private void sleep() {
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
