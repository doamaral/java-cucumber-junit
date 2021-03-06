package runners;
import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber_reports"},
		//features = "src/test/resources/features",
		features = "src/test/resources/features/account.feature",
		tags = "@Ready",
		//if have more tags, separate with comma
		//{"@InProgress, @Ready"}
		glue = "steps",
		//dryRun = true,
		monochrome = true,
		snippets = CucumberOptions.SnippetType.CAMELCASE
	)
public class Runner {
	@BeforeClass
	public static void resetUserDataBase() {
		getDriver().get("https://srbarriga.herokuapp.com/login");
		getDriver().findElement(By.id("email")).sendKeys("asdf@gmail.com");
		getDriver().findElement(By.id("senha")).sendKeys("123456");
		getDriver().findElement(By.xpath("//button[.=\"Entrar\"]")).click();
		getDriver().findElement(By.linkText("reset")).click();
		
	}
}
