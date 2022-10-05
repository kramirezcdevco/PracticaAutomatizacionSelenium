package org.karenramirez.automatizacionselenium.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/purchase.feature",
        glue =  {"org.karenramirez.automatizacionselenium.stepdefinitions"},
        plugin = { "pretty",  "html:target/cucumber-reports/index.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class purchaseRunner {

}
