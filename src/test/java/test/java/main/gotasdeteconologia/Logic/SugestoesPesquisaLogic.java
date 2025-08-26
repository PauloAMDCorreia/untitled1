package test.java.main.gotasdeteconologia.Logic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SugestoesPesquisaLogic {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void acessaHome() {
        driver.get("https://www.amazon.com.br");
        // Aguardar barra de pesquisa estar visível
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
    }

    public void digitarNaBarraDePesquisa(String termo) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        for (char c : termo.toCharArray()) {
            searchBox.sendKeys(String.valueOf(c));
            try {
                Thread.sleep(200); // Simula digitação natural
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean validarSugestoesRelacionadas(String termo) {
        By sugestoesLocator = By.cssSelector("div.s-suggestion-container"); // Ajuste conforme HTML real
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sugestoesLocator));
            List<WebElement> sugestoes = driver.findElements(sugestoesLocator);
            if (sugestoes.isEmpty()) {
                return false;
            }
            // Verifica se pelo menos uma sugestão contém o termo (case insensitive)
            return sugestoes.stream()
                    .anyMatch(s -> s.getText().toLowerCase().contains(termo.toLowerCase()));
        } catch (Exception e) {
            return false;
        }
    }
    @AfterAll
    public static void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

}
