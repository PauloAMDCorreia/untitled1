package test.java.main.gotasdeteconologia.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/CucumberFeatures/sugestoes_pesquisa.feature",
        plugin = "pretty",
        tags = "@Test1",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AmazonTest {}
