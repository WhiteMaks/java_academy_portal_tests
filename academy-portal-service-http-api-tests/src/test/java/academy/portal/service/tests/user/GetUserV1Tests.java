package academy.portal.service.tests.user;

import base.http.api.StatusCode;
import helper.User;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("post-user-v1")
@Story("post-user-v1")
public class GetUserV1Tests extends BaseUserTests {

	@Test
	@DisplayName("Проверка получения пользователя")
	@Description("Запрос на получение пользователя от лица авторизованного пользователя")
	public void getUserV1_200(User user) {
		var userRecord = steps.getDbSteps().findUserByUsername(user.getUsername());

		var actualResponse = steps.getApiSteps().getUserV1(user.getToken());
		var expectedResponse = steps.getGetUserV1ResponseBuilder().prepareResponse(userRecord);

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

	@Test
	@DisplayName("Проверка ошибки [Unauthorized] при запросе на получение пользователя")
	@Description("Запрос на получение пользователя от лица не авторизованного пользователя (без токена)")
	public void getUserV1_401() {
		var actualResponse = steps.getApiSteps().getUserV1Error(null, StatusCode.UNAUTHORIZED);
		var expectedResponse = steps.getErrorResponseBuilder().prepareInvalidTokenResponse();

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

}
