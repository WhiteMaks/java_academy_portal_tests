package academy.portal.service.tests.microservice;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("get-microservice-v1")
@Story("get-microservice-v1")
public class GetMicroserviceV1Tests extends BaseMicroserviceTests {

	@Test
	@DisplayName("Проверка получения информации по микросервису")
	@Description("Запрос на получения информации по микросервису")
	public void getMicroserviceV1_200() {
		var actualResponse = steps.getApiSteps().getMicroserviceV1();
		var expectedResponse = steps.getGetMicroserviceV1ResponseBuilder().prepareResponse(actualResponse);

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

}
