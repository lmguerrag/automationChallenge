package co.com.sofka;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/Logout.feature",
                snippets = CucumberOptions.SnippetType.CAMELCASE)
public class TestRunnerLogout {
}
