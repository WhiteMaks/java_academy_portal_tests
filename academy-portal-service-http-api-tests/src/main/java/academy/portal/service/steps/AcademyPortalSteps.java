package academy.portal.service.steps;

import academy.portal.service.builders.ErrorResponseBuilder;
import academy.portal.service.builders.user.PostUserTokenV1RequestBuilder;
import academy.portal.service.builders.user.PostUserV1RequestBuilder;
import academy.portal.service.builders.user.PostUserV1ResponseBuilder;
import academy.portal.service.builders.user.UserRecordBuilder;
import academy.portal.service.db.steps.AcademyPortalServiceDbSteps;
import academy.portal.service.http.api.steps.AcademyPortalServiceHttpApiSteps;
import common.BaseTestSteps;
import lombok.Getter;

@Getter
public class AcademyPortalSteps extends BaseTestSteps {
	private final AcademyPortalServiceHttpApiSteps apiSteps;
	private final AcademyPortalServiceDbSteps dbSteps;

	private final PostUserTokenV1RequestBuilder postUserTokenV1RequestBuilder;
	private final PostUserV1RequestBuilder postUserV1RequestBuilder;

	private final PostUserV1ResponseBuilder postUserV1ResponseBuilder;
	private final ErrorResponseBuilder errorResponseBuilder;

	private final UserRecordBuilder userRecordBuilder;

	public AcademyPortalSteps() {
		apiSteps = new AcademyPortalServiceHttpApiSteps();
		dbSteps = new AcademyPortalServiceDbSteps();

		postUserTokenV1RequestBuilder = new PostUserTokenV1RequestBuilder();
		postUserV1RequestBuilder = new PostUserV1RequestBuilder();

		postUserV1ResponseBuilder = new PostUserV1ResponseBuilder(dbSteps);
		errorResponseBuilder = new ErrorResponseBuilder();

		userRecordBuilder = new UserRecordBuilder();
	}
}
