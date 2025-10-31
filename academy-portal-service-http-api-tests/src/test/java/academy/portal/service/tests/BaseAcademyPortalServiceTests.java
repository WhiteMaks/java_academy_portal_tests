package academy.portal.service.tests;

import academy.portal.service.steps.AcademyPortalSteps;
import helper.resolvers.UserResolver;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
	UserResolver.class
})
@Epic("academy-portal-service")
public class BaseAcademyPortalServiceTests {
	protected final static AcademyPortalSteps steps = new AcademyPortalSteps();
}
