package academy.portal.service.steps;

import academy.portal.service.builders.ErrorResponseBuilder;
import academy.portal.service.builders.PostUserTokenV1RequestBuilder;
import academy.portal.service.http.api.steps.AcademyPortalServiceHttpApiSteps;
import common.BaseTestSteps;
import lombok.Getter;

@Getter
public class AcademyPortalSteps extends BaseTestSteps {
	private final AcademyPortalServiceHttpApiSteps apiSteps;

	private final PostUserTokenV1RequestBuilder postUserTokenV1RequestBuilder;

	private final ErrorResponseBuilder errorResponseBuilder;

	public AcademyPortalSteps() {
		apiSteps = new AcademyPortalServiceHttpApiSteps();

		postUserTokenV1RequestBuilder = new PostUserTokenV1RequestBuilder();

		errorResponseBuilder = new ErrorResponseBuilder();
	}
}
