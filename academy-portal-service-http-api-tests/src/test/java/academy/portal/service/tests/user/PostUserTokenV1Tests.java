package academy.portal.service.tests.user;

import academy.portal.service.http.api.models.ErrorResponse;
import academy.portal.service.http.api.models.user.PostUserTokenV1Request;
import base.http.api.StatusCode;
import common.generators.StringGenerator;
import helper.User;
import helper.annotations.AUserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("post-user-token-v1")
@Story("post-user-token-v1")
public class PostUserTokenV1Tests extends BaseUserTests {

	@Test
	@AUserConfig(generateToken = false)
	@DisplayName("Проверка генерации токена")
	@Description("Запрос на генерацию токена от лица не авторизованного пользователя")
	public void postUserTokenV1_200(User user) {
		var request = steps.getPostUserTokenV1RequestBuilder().prepareRequest(user);

		var actualResponse = steps.getApiSteps().postUserTokenV1(request);

		Assertions.assertNotNull(actualResponse.getToken());
	}

	private static Stream<Arguments> notValidParams() {
		var nullUsernameValueRequest = steps.getPostUserTokenV1RequestBuilder().prepareRequest(null, StringGenerator.generateRandomString(8));
		var nullUsernameValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserTokenV1Request.Username' Error:Field validation for 'Username' failed on the 'required' tag");

		var nullPasswordValueRequest = steps.getPostUserTokenV1RequestBuilder().prepareRequest(StringGenerator.generateRandomString(8), null);
		var nullPasswordValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserTokenV1Request.Password' Error:Field validation for 'Password' failed on the 'required' tag");

		return Stream.of(
			Arguments.of(nullUsernameValueRequest, nullUsernameValueResponse),
			Arguments.of(nullPasswordValueRequest, nullPasswordValueResponse)
		);
	}

	@ParameterizedTest
	@MethodSource("notValidParams")
	@DisplayName("Проверка ошибки [Bad request] при запросе на генерацию токена с невалидными параметрами")
	@Description("Запрос на генерацию токена от лица не авторизованного пользователя")
	public void postUserTokenV1_400(PostUserTokenV1Request request, ErrorResponse expectedResponse) {
		var actualResponse = steps.getApiSteps().postUserTokenV1Error(request, StatusCode.BAD_REQUEST);

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

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
