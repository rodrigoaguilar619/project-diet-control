package project.diet.control;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import project.diet.control.config.starter.AppDietControl;

@ActiveProfiles("test")
@SpringBootTest(classes = AppDietControl.class)
public abstract class ProjectIntegrationTest extends ProjectConfigFlywayTest {

}
