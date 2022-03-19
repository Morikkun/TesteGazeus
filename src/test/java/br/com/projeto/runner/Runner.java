package br.com.projeto.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = { "pretty",
		"json:target/report.json" }, features = "src/test/resources/features/", dryRun = false,
		snippets = CucumberOptions.SnippetType.CAMELCASE, monochrome = true, glue = "br.com.projeto.steps")
@RunWith(Cucumber.class)
public class Runner {

}
