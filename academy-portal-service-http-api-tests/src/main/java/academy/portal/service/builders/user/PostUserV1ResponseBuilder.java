package academy.portal.service.builders.user;

import academy.portal.service.db.steps.AcademyPortalServiceDbSteps;
import academy.portal.service.http.api.models.PostUserV1Request;
import academy.portal.service.http.api.models.PostUserV1Response;

public class PostUserV1ResponseBuilder {
	private final AcademyPortalServiceDbSteps dbSteps;

	public PostUserV1ResponseBuilder(AcademyPortalServiceDbSteps dbSteps) {
		this.dbSteps = dbSteps;
	}

	public PostUserV1Response prepareResponse(PostUserV1Response actual, PostUserV1Request request) {
		var resultBuilder = actual.toBuilder();

		var userRecord = dbSteps.findUserByUsername(request.getUsername());

		resultBuilder.id(userRecord.getId());

		return resultBuilder.build();
	}
}
