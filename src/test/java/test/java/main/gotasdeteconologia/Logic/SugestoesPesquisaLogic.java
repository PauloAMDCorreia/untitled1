package test.java.main.gotasdeteconologia.Logic;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class SugestoesPesquisaLogic {

    private static WebDriver driver;
    private static WebDriverWait wait;


    public  SugestoesPesquisaLogic() {
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
                sleep(200); // Simula digitação natural
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean validarSugestoesRelacionadas(String termo) {
        By sugestoesLocator = By.cssSelector("div.s-suggestion-container");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sugestoesLocator));
            List<WebElement> sugestoes = driver.findElements(sugestoesLocator);
            if (sugestoes.isEmpty()) {
                return false;
            }
            // Verifica se pelo menos uma sugestão contém o termo
            return sugestoes.stream()
                    .anyMatch(s -> s.getText().toLowerCase().contains(termo.toLowerCase()));
        } catch (Exception e) {
            return false;
        }
    }

    public void oSistemaNaoDeveExibirNenhumaSugestao() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        String specialChars = "@#$%";

        searchBox.sendKeys(specialChars);

        sleep(2000);

        By suggestionsLocator = By.cssSelector("div.s-suggestion-container");
        List<WebElement> suggestions = driver.findElements(suggestionsLocator);

        Assert.assertTrue("Nenhuma sugestão deve aparecer para caracteres especiais", suggestions.isEmpty());

    }

    public void oUsuarioDigitarNaBarraDePesquisa() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // Digitar parte da palavra
        String partialTerm = "lap";
        for (char c : partialTerm.toCharArray()) {
            searchBox.sendKeys(String.valueOf(c));
            sleep(2000);
        }

        By suggestionsLocator = By.cssSelector("div.s-suggestion-container");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));
        List<WebElement> suggestionsPartial = driver.findElements(suggestionsLocator);
        Assert.assertTrue("Sugestões devem aparecer para termo parcial", suggestionsPartial.size() > 0);
    }

    public void continuaDigitando() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        // Digitar restante do termo
        String remainingTerm = "top";
        for (char c : remainingTerm.toCharArray()) {
            searchBox.sendKeys(String.valueOf(c));
            sleep(2000);
        }
        By suggestionsLocator = By.cssSelector("div.s-suggestion-container");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));
        List<WebElement> suggestionsPartial = driver.findElements(suggestionsLocator);
        Assert.assertTrue("Sugestões devem aparecer para termo parcial", suggestionsPartial.size() > 0);
    }

    public void clicaEmUmaSugestaoExibida() {
        By suggestionsLocator = By.cssSelector("div.s-suggestion-container");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));

        List<WebElement> suggestions = driver.findElements(suggestionsLocator);
        Assert.assertTrue("Sugestões devem aparecer", suggestions.size() > 0);

        WebElement firstSuggestion = suggestions.get(0);

        firstSuggestion.click();
    }

    public void oUsuarioDeveSerRedirecionadoParaAPaginaDeResultadosDaPesquisaCorrespondente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("phone"));

        // Get current URL
        String currentUrl = driver.getCurrentUrl();

        // Assert URL contains the search query (encoded)
        String searchQuery = "phone";
        String encodedQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        if (!currentUrl.contains(encodedQuery)) {
            throw new AssertionError("URL does not contain the search query. Expected to find: " + encodedQuery + " in " + currentUrl);
        }
    }

    @AfterEach
    public void fechaBrowser() {
        driver.close();
    }
}
