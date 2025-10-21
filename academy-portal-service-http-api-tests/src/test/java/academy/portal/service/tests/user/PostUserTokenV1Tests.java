package academy.portal.service.tests.user;

import base.http.api.StatusCode;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("post-user-token-v1")
@Story("post-user-token-v1")
public class PostUserTokenV1Tests extends BaseUserTests {

	@Test
	@DisplayName("Проверка ошибки [Unauthorized] при запросе на генерацию токена с рандомными значениями")
	@Description("Запрос на генерацию токена от лица не авторизованного пользователя")
	public void postUserTokenV1_401() {
		var request = steps.getPostUserTokenV1RequestBuilder().prepareRequest();

		var actualResponse = steps.getApiSteps().postUserTokenV1Error(request, StatusCode.UNAUTHORIZED);
		var expectedResponse = steps.getErrorResponseBuilder().prepareResponse("invalid credentials");

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

}
