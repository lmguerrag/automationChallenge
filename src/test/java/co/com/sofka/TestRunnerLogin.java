package co.com.sofka;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/Login.feature",
                snippets = CucumberOptions.SnippetType.CAMELCASE)
public class TestRunnerLogin {
}
