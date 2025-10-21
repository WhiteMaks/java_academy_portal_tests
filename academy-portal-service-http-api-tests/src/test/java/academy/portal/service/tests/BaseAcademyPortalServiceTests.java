package academy.portal.service.tests;

import academy.portal.service.steps.AcademyPortalSteps;
import io.qameta.allure.Epic;

@Epic("academy-portal-service")
public class BaseAcademyPortalServiceTests {
	protected final static AcademyPortalSteps steps = new AcademyPortalSteps();
}
