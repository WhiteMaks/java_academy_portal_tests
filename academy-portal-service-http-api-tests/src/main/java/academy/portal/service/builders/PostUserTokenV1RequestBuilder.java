package academy.portal.service.builders;

import academy.portal.service.http.api.models.PostUserTokenV1Request;
import common.generators.StringGenerator;

public class PostUserTokenV1RequestBuilder {

	public PostUserTokenV1Request prepareRequest() {
		return prepareRequest(
			StringGenerator.generateRandomString(10),
			StringGenerator.generateRandomString(10)
		);
	}

	public PostUserTokenV1Request prepareRequest(String username, String password) {
		var result = new PostUserTokenV1Request();

		result.setUsername(username);
		result.setPassword(password);

		return result;
	}

}
