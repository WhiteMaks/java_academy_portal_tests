package academy.portal.service.builders.user;

import academy.portal.service.http.api.models.user.PostUserV1Request;
import common.generators.StringGenerator;
import helper.User;

public class PostUserV1RequestBuilder {

	public PostUserV1Request prepareRequest() {
		return prepareRequest(StringGenerator.generateRandomString(10), StringGenerator.generateRandomString(10));
	}

	public PostUserV1Request prepareRequest(User user) {
		return prepareRequest(user.getUsername(), user.getPassword());
	}

	public PostUserV1Request prepareRequest(String username, String password) {
		var result = new PostUserV1Request();

		result.setUsername(username);
		result.setPassword(password);

		return result;
	}

}
