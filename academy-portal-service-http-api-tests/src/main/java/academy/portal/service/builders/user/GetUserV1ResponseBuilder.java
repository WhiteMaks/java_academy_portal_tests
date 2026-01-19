package academy.portal.service.builders.user;

import academy.portal.service.db.models.User;
import academy.portal.service.http.api.models.user.GetUserV1Response;

public class GetUserV1ResponseBuilder {

	public GetUserV1Response prepareResponse(User userRecord) {
		var result = new GetUserV1Response();

		result.setId(userRecord.getId());
		result.setUsername(userRecord.getUsername());
		result.setRole(userRecord.getRole().name());

		return result;
	}

}
