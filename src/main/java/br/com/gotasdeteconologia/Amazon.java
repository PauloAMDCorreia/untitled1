package br.com.gotasdeteconologia;


import io.cucumber.java.BeforeStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeStep
    public static void setup() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeStep
    public void acessaHome() {
        driver.get("https://www.amazon.com.br");
        // Aguardar barra de pesquisa estar visível
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
    }

}
