package academy.portal.service.builders;

import academy.portal.service.http.api.models.ErrorResponse;

public class ErrorResponseBuilder {

	public ErrorResponse prepareResponse() {
		return prepareResponse(null);
	}

	public ErrorResponse prepareInvalidTokenResponse() {
		return prepareResponse("token is invalid");
	}

	public ErrorResponse prepareForbiddenResponse() {
		return prepareResponse("forbidden");
	}

	public ErrorResponse prepareResponse(String message) {
		var result = new ErrorResponse();

		result.setMessage(message);

		return result;
	}

}
