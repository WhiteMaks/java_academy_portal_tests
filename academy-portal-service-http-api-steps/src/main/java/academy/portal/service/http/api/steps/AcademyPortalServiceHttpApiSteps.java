package academy.portal.service.http.api.steps;

import academy.portal.service.http.api.AcademyPortalService;
import academy.portal.service.http.api.models.ErrorResponse;
import academy.portal.service.http.api.models.PostUserTokenV1Request;
import academy.portal.service.http.api.models.PostUserTokenV1Response;
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
