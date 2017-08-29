package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/**
 * Created by sba88 on 28/08/2017.
 */



@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/com.example.moo.Features",
        glue="com.example.moo.steps",
        format = {"pretty", "html:target/cucumber"},
        tags = {"@login"}
)

public class loginRunner {

}
