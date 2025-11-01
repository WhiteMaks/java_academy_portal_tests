package academy.portal.service.builders.user;

import academy.portal.service.http.api.models.user.PostUserTokenV1Request;
import common.generators.StringGenerator;
import helper.User;

public class PostUserTokenV1RequestBuilder {

	public PostUserTokenV1Request prepareRequest() {
		return prepareRequest(
			StringGenerator.generateRandomString(10),
			StringGenerator.generateRandomString(10)
		);
	}

	public PostUserTokenV1Request prepareRequest(User user) {
		return prepareRequest(user.getUsername(), user.getPassword());
	}

	public PostUserTokenV1Request prepareRequest(String username, String password) {
		var result = new PostUserTokenV1Request();

		result.setUsername(username);
		result.setPassword(password);

		return result;
	}

}
