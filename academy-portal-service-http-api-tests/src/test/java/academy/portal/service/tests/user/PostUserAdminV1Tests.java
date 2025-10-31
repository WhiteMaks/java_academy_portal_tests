package academy.portal.service.tests.user;

import academy.portal.service.db.models.enums.Role;
import academy.portal.service.http.api.models.ErrorResponse;
import academy.portal.service.http.api.models.PostUserV1Request;
import base.http.api.StatusCode;
import common.generators.StringGenerator;
import helper.User;
import helper.annotations.AUserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("post-user-admin-v1")
@Story("post-user-admin-v1")
public class PostUserAdminV1Tests extends BaseUserTests {

	@Disabled
	@AUserConfig(generateToken = false)
	@Test
	@DisplayName("Проверка создание администратора")
	@Description("Запрос на создание администратора")
	public void postUserAdminV1_201(User user) {
		var request = steps.getPostUserV1RequestBuilder().prepareRequest(user);

		steps.getDbSteps().deleteUserByRole(Role.admin);

		var actualResponse = steps.getApiSteps().postUserAdminV1(request);
		var expectedResponse = steps.getPostUserV1ResponseBuilder().prepareResponse(actualResponse, request);

		var actualUserRecord = steps.getDbSteps().findUserById(actualResponse.getId());
		var expectedUserRecord = steps.getUserRecordBuilder().prepareRecord(actualUserRecord, request, Role.admin);

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
		steps.recordsMustBeEqually(expectedUserRecord, actualUserRecord);
	}

	private static Stream<Arguments> notValidParams() {
		var nullUsernameValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest(null, StringGenerator.generateRandomString(8));
		var nullUsernameValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Username' Error:Field validation for 'Username' failed on the 'required' tag");

		var minUsernameValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest(StringGenerator.generateRandomString(4), StringGenerator.generateRandomString(8));
		var minUsernameValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Username' Error:Field validation for 'Username' failed on the 'min' tag");

		var maxUsernameValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest(StringGenerator.generateRandomString(65), StringGenerator.generateRandomString(8));
		var maxUsernameValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Username' Error:Field validation for 'Username' failed on the 'max' tag");

		var invalidUsernameValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest("123апрnasd", StringGenerator.generateRandomString(8));
		var invalidUsernameValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Username' Error:Field validation for 'Username' failed on the 'alphanum' tag");

		var nullPasswordValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest(StringGenerator.generateRandomString(8), null);
		var nullPasswordValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Password' Error:Field validation for 'Password' failed on the 'required' tag");

		var minPasswordValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest(StringGenerator.generateRandomString(8), StringGenerator.generateRandomString(7));
		var minPasswordValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Password' Error:Field validation for 'Password' failed on the 'min' tag");

		var maxPasswordValueRequest = steps.getPostUserV1RequestBuilder().prepareRequest(StringGenerator.generateRandomString(8), StringGenerator.generateRandomString(65));
		var maxPasswordValueResponse = steps.getErrorResponseBuilder().prepareResponse("Key: 'PostUserV1Request.Password' Error:Field validation for 'Password' failed on the 'max' tag");

		return Stream.of(
			Arguments.of(nullUsernameValueRequest, nullUsernameValueResponse),
			Arguments.of(minUsernameValueRequest, minUsernameValueResponse),
			Arguments.of(maxUsernameValueRequest, maxUsernameValueResponse),
			Arguments.of(invalidUsernameValueRequest, invalidUsernameValueResponse),
			Arguments.of(nullPasswordValueRequest, nullPasswordValueResponse),
			Arguments.of(minPasswordValueRequest, minPasswordValueResponse),
			Arguments.of(maxPasswordValueRequest, maxPasswordValueResponse)
		);
	}

	@ParameterizedTest
	@MethodSource("notValidParams")
	@DisplayName("Проверка ошибки [Bad request] при запросе на создание администратора с невалидными параметрами")
	@Description("Запрос на создание администратора")
	public void postUserAdminV1_400(PostUserV1Request request, ErrorResponse expectedResponse) {
		var actualResponse = steps.getApiSteps().postUserAdminV1Error(request, StatusCode.BAD_REQUEST);

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

	@Test
	@DisplayName("Проверка ошибки [Not found] при запросе на создание администратора, когда он уже существует")
	@Description("Запрос на создание администратора")
	public void postUserAdminV1_404() {
		var request = steps.getPostUserV1RequestBuilder().prepareRequest();

		var actualResponse = steps.getApiSteps().postUserAdminV1Error(request, StatusCode.NOT_FOUND);
		var expectedResponse = steps.getErrorResponseBuilder().prepareResponse();

		steps.responsesMustBeEqually(expectedResponse, actualResponse);
	}

}
