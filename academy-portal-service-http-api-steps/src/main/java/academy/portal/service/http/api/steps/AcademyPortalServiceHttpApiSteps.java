package academy.portal.service.http.api.steps;

import academy.portal.service.http.api.AcademyPortalService;
import academy.portal.service.http.api.models.*;
import base.http.api.RestResponse;
import base.http.api.StatusCode;
import common.configs.Config;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class AcademyPortalServiceHttpApiSteps {
	private final AcademyPortalService api;

	public AcademyPortalServiceHttpApiSteps() {
		api = new AcademyPortalService(Config.MICROSERVICE.getAcademyPortalService());
	}

	public PostUserV1Response postUserAdminV1(PostUserV1Request request) {
		return postUserAdminV1(request, StatusCode.CREATED)
			.getBodyByClass(PostUserV1Response.class);
	}

	public ErrorResponse postUserAdminV1Error(PostUserV1Request request, StatusCode expectedStatusCode) {
		return postUserAdminV1(request, expectedStatusCode)
			.getBodyByClass(ErrorResponse.class);
	}

	@Step("Отправка запроса на создание администратора. Ожидающий код ответа [{expectedStatusCode}]")
	public RestResponse postUserAdminV1(PostUserV1Request request, StatusCode expectedStatusCode) {
		var response = api.postUserAdminV1(request);
		checkStatusCode(response, expectedStatusCode);
		return response;
	}

	public PostUserV1Response postUserV1(PostUserV1Request request, String token) {
		return postUserV1(request, token, StatusCode.CREATED)
			.getBodyByClass(PostUserV1Response.class);
	}

	public ErrorResponse postUserV1Error(PostUserV1Request request, String token, StatusCode expectedStatusCode) {
		return postUserV1(request, token, expectedStatusCode)
			.getBodyByClass(ErrorResponse.class);
	}

	@Step("Отправка запроса на создание пользователя. Ожидающий код ответа [{expectedStatusCode}]")
	public RestResponse postUserV1(PostUserV1Request request, String token, StatusCode expectedStatusCode) {
		var response = api.postUserV1(request, token);
		checkStatusCode(response, expectedStatusCode);
		return response;
	}

	public PostUserTokenV1Response postUserTokenV1(PostUserTokenV1Request request) {
		return postUserTokenV1(request, StatusCode.OK)
			.getBodyByClass(PostUserTokenV1Response.class);
	}

	public ErrorResponse postUserTokenV1Error(PostUserTokenV1Request request, StatusCode expectedStatusCode) {
		return postUserTokenV1(request, expectedStatusCode)
			.getBodyByClass(ErrorResponse.class);
	}

	@Step("Отправка запроса на генерацию токена. Ожидающий код ответа [{expectedStatusCode}]")
	public RestResponse postUserTokenV1(PostUserTokenV1Request request, StatusCode expectedStatusCode) {
		var response = api.postUserTokenV1(request);
		checkStatusCode(response, expectedStatusCode);
		return response;
	}

	@Step("Проверка статус кода ответа")
	private void checkStatusCode(RestResponse response, StatusCode expectedStatusCode) {
		Assertions.assertEquals(expectedStatusCode, response.getStatus(), "Статус код не соответствует ожидаемому");
	}
}
