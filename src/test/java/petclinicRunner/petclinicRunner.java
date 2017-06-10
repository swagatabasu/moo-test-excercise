package petclinicRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sba88 on 09/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/com.example.petclinic.Features",
        glue="com.example.petclinic.steps",
        format = {"pretty", "html:target/cucumber"},
        tags = {"@addPetAndScheduleVisit"}
)
public class petclinicRunner {
}